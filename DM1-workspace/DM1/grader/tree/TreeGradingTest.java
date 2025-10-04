package tree;

import static com.github.stefanbirkner.systemlambda.SystemLambda.tapSystemErrAndOutNormalized;

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

@GradedTest(gradesFile = "Ex-3.2.txt", summaryFile = "Ex-3.2.csv")
@ExtendWith(SoftAssertionsExtension.class)
@DisplayName("3.2 Tree class (3 points)")
@TestMethodOrder(MethodOrderer.DisplayName.class)
public class TreeGradingTest implements WithAssertions {

    @InjectSoftAssertions
    TypeSoftAssertions soft;

    @DisplayName("3.2.1 Nominal tree creation")
    @Grade(value = 0.5, feedback = "Constructor and addChild() methods should work as expected")
    @Test
    public void testCanCreateNominalTree() {
        Tree<Integer> t = new Tree<>(1);
        t.addChild(1, 2);
        t.addChild(1, 3);
        t.addChild(1, 4);
        t.addChild(2, 6);
        t.addChild(2, 5);
        t.addChild(3, 7);
        t.addChild(5, 8);

        soft.assertThat(t).extracting("root")
                .isNotNull()
                .extracting("element")
                .isEqualTo(1);
        soft.assertThat(t).extracting("nodes")
                .isNotNull()
                .asInstanceOf(InstanceOfAssertFactories.MAP)
                .hasSize(8)
                .containsKeys(1, 2, 3, 4, 5, 6, 7, 8);
    }

    @DisplayName("3.2.2 Nominal tree string representation")
    @Grade(value = 0.5, feedback = "toString() should show the tree in a depth-first order")
    @Test
    public void testToString() {
        Tree<Integer> t = new Tree<>(1);
        t.addChild(1, 2);
        t.addChild(1, 3);
        t.addChild(1, 4);
        t.addChild(2, 6);
        t.addChild(2, 5);
        t.addChild(3, 7);
        t.addChild(5, 8);

        soft.assertThat(t.toString())
                .containsSubsequence("1", "2", "6", "5", "8", "3", "7", "4");
    }

    @DisplayName("3.2.3 Tree duplicate nodes handling")
    @Grade(value = 0.5, feedback = "Adding a duplicate child should trigger an error message")
    @Test
    public void testCannotInsertDuplicateNodes() throws Exception {
        Tree<Integer> t = new Tree<>(1);
        t.addChild(1, 2);
        t.addChild(1, 3);
        t.addChild(1, 4);
        String text = tapSystemErrAndOutNormalized(() -> {
            try {
                t.addChild(1, 2);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        });
        soft.assertThat(text).isNotBlank();
        soft.assertThat(t).extracting("nodes")
                .isNotNull()
                .asInstanceOf(InstanceOfAssertFactories.MAP)
                .hasSize(4)
                .containsKeys(1, 2, 3, 4);
    }

    @DisplayName("3.2.4 Tree size")
    @Grade(value = 0.5, feedback = "size() method should return the correct size after each node addition")
    @Test
    public void testSize() {
        Tree<Integer> t = new Tree<>(1);
        soft.assertThat(t.size()).isEqualTo(1);
        t.addChild(1, 2);
        soft.assertThat(t.size()).isEqualTo(2);
        t.addChild(1, 3);
        t.addChild(1, 4);
        soft.assertThat(t.size()).isEqualTo(4);
        t.addChild(2, 6);
        t.addChild(2, 5);
        t.addChild(3, 7);
        t.addChild(5, 8);
        soft.assertThat(t.size()).isEqualTo(8);
    }

    @DisplayName("3.2.5 Tree height")
    @Grade(value = 0.5, feedback = "height() method should return the correct height after each node addition")
    @Test
    public void testHeight() {
        Tree<Integer> t = new Tree<>(1);
        soft.assertThat(t.height()).isEqualTo(1);
        t.addChild(1, 2);
        soft.assertThat(t.height()).isEqualTo(2);
        t.addChild(1, 3);
        t.addChild(1, 4);
        soft.assertThat(t.height()).isEqualTo(2);
        t.addChild(2, 6);
        t.addChild(2, 5);
        t.addChild(3, 7);
        soft.assertThat(t.height()).isEqualTo(3);
        t.addChild(5, 8);
        soft.assertThat(t.height()).isEqualTo(4);
    }

    @DisplayName("3.2.6 Tree members visibility")
    @Grade(value = 0.5, feedback = "All UML visibilities should be respected")
    @Test
    public void testVisibility() {
        TypeInfo treeType = TypeInfo.info(Tree.class);
        soft.assertThat(treeType)
                .hasOnlyPrivateAttributes()
                .hasOnlyPublicConstructors()
                .hasOnlyPublicMethods();
    }
}
