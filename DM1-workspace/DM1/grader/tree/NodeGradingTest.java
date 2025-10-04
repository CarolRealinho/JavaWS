package tree;

import org.assertj.core.api.InstanceOfAssertFactories;
import org.assertj.core.api.WithAssertions;
import org.assertj.core.api.junit.jupiter.InjectSoftAssertions;
import org.assertj.core.api.junit.jupiter.SoftAssertionsExtension;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;

import fr.supaero.grader.annotations.Grade;
import fr.supaero.grader.annotations.GradedTest;
import fr.supaero.matchers.assertions.TypeSoftAssertions;
import fr.supaero.matchers.utils.TypeInfo;

@GradedTest(gradesFile = "Ex-3.1.txt", summaryFile = "Ex-3.1.csv")
@ExtendWith(SoftAssertionsExtension.class)
@DisplayName("3.1 Node class (3 points)")
@TestMethodOrder(MethodOrderer.DisplayName.class)
public class NodeGradingTest implements WithAssertions {

        @InjectSoftAssertions
        TypeSoftAssertions soft;

        @DisplayName("3.1.1 Node creation")
        @Grade(value = 0.5, feedback = "A newly created node should have the correct element and an empty non-null list, set or map of children")
        @Test
        public void testNewNode() {
                Node<Integer> node = new Node<>(42);

                soft.assertThat(node)
                                .extracting("element")
                                .isEqualTo(42);
                soft.assertThat(node)
                                .extracting("children")
                                .isNotNull();

                TypeInfo nodeType = TypeInfo.info(Node.class);
                String childrenType = nodeType.getField("children").type;
                if (childrenType.contains("Map")) {
                        soft.assertThat(node)
                                        .extracting("children")
                                        .asInstanceOf(InstanceOfAssertFactories.MAP)
                                        .isEmpty();
                } else {
                        soft.assertThat(node)
                                        .extracting("children")
                                        .asInstanceOf(InstanceOfAssertFactories.COLLECTION)
                                        .isEmpty();
                }

        }

        @DisplayName("3.1.2 Child addition")
        @Grade(value = 0.5, feedback = "addChild(X) should add X to the children attribute without modifying the element attribute")
        @Test
        public void testAddChild() {
                Node<Integer> node = new Node<>(42);
                Node<Integer> child1 = new Node<>(43);
                Node<Integer> child2 = new Node<>(44);
                Node<Integer> child3 = new Node<>(45);

                TypeInfo nodeType = TypeInfo.info(Node.class);
                String childrenType = nodeType.getField("children").type;
                if (childrenType.contains("Map")) { // HashMap or TreeMap
                        node.addChild(child1);
                        soft.assertThat(node)
                                        .extracting("children")
                                        .asInstanceOf(InstanceOfAssertFactories.MAP)
                                        .hasSize(1)
                                        .containsValue(child1);
                        soft.assertThat(node)
                                        .extracting("element")
                                        .isEqualTo(42);
                        node.addChild(child2);
                        node.addChild(child3);
                        soft.assertThat(node)
                                        .extracting("children")
                                        .asInstanceOf(InstanceOfAssertFactories.MAP)
                                        .hasSize(3)
                                        .containsValues(child1, child2, child3);
                        soft.assertThat(node)
                                        .extracting("element")
                                        .isEqualTo(42);
                } else { // ArrayList or HashSet or TreeSet
                        node.addChild(child1);
                        soft.assertThat(node)
                                        .extracting("children")
                                        .asInstanceOf(InstanceOfAssertFactories.COLLECTION)
                                        .hasSize(1)
                                        .contains(child1);
                        soft.assertThat(node)
                                        .extracting("element")
                                        .isEqualTo(42);
                        node.addChild(child2);
                        node.addChild(child3);
                        soft.assertThat(node)
                                        .extracting("children")
                                        .asInstanceOf(InstanceOfAssertFactories.COLLECTION)
                                        .hasSize(3)
                                        .contains(child1, child2, child3);
                        soft.assertThat(node)
                                        .extracting("element")
                                        .isEqualTo(42);
                }
        }

        @DisplayName("3.1.3 String representation: elements in addition order")
        @Grade(value = 0.5, feedback = "toString() should contain all elements of the tree in the depth-first order")
        @Test
        public void testToStringSingleLevel() {
                Node<Integer> node = new Node<>(42);

                soft.assertThat(node.toString()).contains("42");

                Node<Integer> child1 = new Node<>(421);
                Node<Integer> child2 = new Node<>(422);
                Node<Integer> child3 = new Node<>(423);

                node.addChild(child1);
                node.addChild(child2);
                node.addChild(child3);
                soft.assertThat(node.toString()).contains("42", "421", "422", "423");
                soft.assertThat(node.toString()).containsSubsequence("42", "421", "422", "423");

                Node<Integer> subchild21 = new Node<>(4221);
                Node<Integer> subchild22 = new Node<>(4222);
                Node<Integer> subsubchild211 = new Node<>(42211);
                child2.addChild(subchild21);
                child2.addChild(subchild22);
                subchild21.addChild(subsubchild211);

                soft.assertThat(node.toString()).contains("42", "421", "422", "423", "4221", "4222", "42211");
                soft.assertThat(node.toString()).containsSubsequence("42", "421", "422", "4221", "42211", "4222",
                                "423");
        }

        @DisplayName("3.1.4 Node size and height")
        @Grade(value = 0.5, feedback = "Node size and height should be those of the node-rooted subtree")
        @Test
        public void testSize() {
                Node<Integer> node = new Node<>(0);
                Node<Integer> child1 = new Node<>(1);
                Node<Integer> child2 = new Node<>(2);
                Node<Integer> child3 = new Node<>(3);
                Node<Integer> subchild21 = new Node<>(21);
                Node<Integer> subchild22 = new Node<>(22);

                soft.assertThat(node.size()).isEqualTo(1);
                soft.assertThat(node.height()).isEqualTo(1);

                // adding one level
                node.addChild(child1);
                node.addChild(child2);
                node.addChild(child3);
                soft.assertThat(node.size()).isEqualTo(4);
                soft.assertThat(node.height()).isEqualTo(2);

                // adding one more level
                child2.addChild(subchild21);
                child2.addChild(subchild22);
                soft.assertThat(node.size()).isEqualTo(6);
                soft.assertThat(node.height()).isEqualTo(3);
        }

        @DisplayName("3.1.5 Node class visibilities")
        @Grade(value = 0.5, feedback = "All UML visibilities should be respected, in particular package-private visibility")
        @Test
        public void testNodeVisibility() {
                TypeInfo nodeType = TypeInfo.info(Node.class);
                soft.assertThat(nodeType)
                                .hasOnlyPrivateAttributes()
                                .hasVisibility(""); // package-private, not public
                soft.assertThat(nodeType)
                                .hasConstructor("Node(E)");
                soft.assertThat(nodeType.getConstructor("Node(E)").constructor)
                                .hasVisibility(""); // package-private, not public
                soft.assertThat(nodeType)
                                .hasMethod("addChild(Node<E>)");
                soft.assertThat(nodeType.getMethod("addChild(Node<E>)").method)
                                .hasVisibility(""); // package-private, not public
                soft.assertThat(nodeType)
                                .hasMethod("size()");
                soft.assertThat(nodeType.getMethod("size()").method)
                                .hasVisibility(""); // package-private, not public
                soft.assertThat(nodeType)
                                .hasMethod("height()");
                soft.assertThat(nodeType.getMethod("height()").method)
                                .hasVisibility(""); // package-private, not public
        }

        @DisplayName("3.1.6 String representation: indentation")
        @Grade(value = 0.5, feedback = "Children nodes should be indented in a way that reflects their depth in the tree")
        @Test
        public void testToStringMultipleLevels() {
                Node<Integer> node = new Node<>(0);
                Node<Integer> child1 = new Node<>(1);
                Node<Integer> child2 = new Node<>(2);
                Node<Integer> child3 = new Node<>(3);
                Node<Integer> subchild21 = new Node<>(21);
                Node<Integer> subchild22 = new Node<>(22);
                Node<Integer> subsubchild211 = new Node<>(211);
                node.addChild(child1);
                node.addChild(child2);
                node.addChild(child3);
                child2.addChild(subchild21);
                child2.addChild(subchild22);
                subchild21.addChild(subsubchild211);

                soft.assertThat(node.toString()).contains("0", "1", "2", "3", "21", "22", "211");
                soft.assertThat(node.toString()).containsSubsequence("0", "1", "2", "21", "211", "22", "3");

                // Note: manual teacher review needed
                // - look for any type of consistent indentation like this:
                // 0
                // -- 1
                // -- 2
                // ---- 21
                // ------ 211
                // ---- 22
                // -- 3
                fail("\nCustom indentation cannot be tested automatically.\nIs the following tree well indented and does it have the right content?\n\n"
                                + node.toString());
        }
}