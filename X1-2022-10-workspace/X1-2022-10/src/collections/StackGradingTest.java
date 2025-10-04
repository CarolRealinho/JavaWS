package collections;

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
import fr.supaero.matchers.utils.TypeInfo;
import fr.supaero.matchers.assertions.TypeSoftAssertions;

@GradedTest(gradesFile = "Ex-3.txt", summaryFile = "Ex-3.csv")
@ExtendWith(SoftAssertionsExtension.class)
@DisplayName("3 Stack generic class")
@TestMethodOrder(MethodOrderer.DisplayName.class)
public class StackGradingTest implements WithAssertions {

   @InjectSoftAssertions
   TypeSoftAssertions soft;

   TypeInfo info = TypeInfo.info(Stack.class);

   @DisplayName("3a Stack class declaration")
   @Test
   @Grade(value = 1, feedback = "Stack should be generic")
   public void genericClass() {
      soft.assertThat(info.signature).matches("class Stack<\\w+>");
   }

   @DisplayName("3b Stack constructor")
   @Test
   @Grade(value = 0.5, feedback = "new Stack() should return an empty stack")
   public void canCreateStack() {
      Stack<String> q = new Stack<>();
      assertThat(q).extracting("elements")
            .isNotNull()
            .asList()
            .isEmpty();
   }

   @DisplayName("3c Stack element pushing")
   @Test
   @Grade(value = 0.5, feedback = "push(X) should store X in elements list")
   public void canPush() {
      Stack<String> stack = new Stack<>();
      stack.push("X");
      stack.push("Y");
      stack.push("Z");
      assertThat(stack).extracting("elements")
            .asList()
            .contains("X", "Y", "Z");
   }

   @DisplayName("3d Stack LIFO behavior")
   @Test
   @Grade(value = 1, feedback = "pop() should return elements in LIFO order")
   public void popOrderIsOk() {
      Stack<String> stack = new Stack<>();
      stack.push("X");
      stack.push("Y");
      stack.push("Z");
      soft.assertThat(stack.pop()).isEqualTo("Z");
      soft.assertThat(stack).extracting("elements")
            .asList()
            .doesNotContain("Z");
      soft.assertThat(stack.pop()).isEqualTo("Y");
      soft.assertThat(stack).extracting("elements")
            .asList()
            .doesNotContain("Y");
      soft.assertThat(stack.pop()).isEqualTo("X");
      soft.assertThat(stack).extracting("elements")
            .asList()
            .doesNotContain("X");

   }

   @DisplayName("3e Stack isEmpty() check")
   @Test
   @Grade(value = 0.5, feedback = "isEmpty() should return true iff stack is logically empty")
   public void testIsEmpty() {
      Stack<String> stack = new Stack<>();
      assertThat(stack.isEmpty()).isTrue();

      stack.push("X");
      assertThat(stack.isEmpty()).isFalse();

      stack.pop();
      assertThat(stack.isEmpty()).isTrue();

      stack.push("Y");
      stack.push("Z");
      assertThat(stack.isEmpty()).isFalse();

      stack.pop();
      assertThat(stack.isEmpty()).isFalse();
      stack.pop();
      assertThat(stack.isEmpty()).isTrue();
   }

   @DisplayName("3f Stack robustness")
   @Test
   @Grade(value = 0.5, feedback = "pop() should not break the stack when elements list is empty")
   public void popEmptyStackDoesNotBreakStack() {
      Stack<String> stack = new Stack<>();
      stack.pop();
      stack.push("X");
      assertThat(stack).extracting("elements")
            .asList()
            .contains("X");
   }
}
