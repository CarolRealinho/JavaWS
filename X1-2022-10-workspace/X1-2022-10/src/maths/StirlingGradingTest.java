package maths;

import java.io.File;

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

@GradedTest(gradesFile = "Ex-2.txt", summaryFile = "Ex-2.csv")
@ExtendWith(SoftAssertionsExtension.class)
@DisplayName("2 Stirling class")
@TestMethodOrder(MethodOrderer.DisplayName.class)
public class StirlingGradingTest implements WithAssertions {

   @InjectSoftAssertions
   TypeSoftAssertions soft;

   TypeInfo info = TypeInfo.info(Stirling.class);

   @DisplayName("2a Factorial method declaration")
   @Test
   @Grade(value = 0.5, feedback = "factorial should be static")
   public void staticMethod() {
      soft.assertThat(info.getMethod("factorial(int)").method)
            .hasAllModifiersOf("static");
   }

   @DisplayName("2b Factorial method declaration, continued")
   @Test
   @Grade(value = 0.5, feedback = "factorial should be public and return double")
   public void attributesVisibility() {
      soft.assertThat(info.getMethod("factorial(int)").method)
            .hasVisibility("public")
            .hasReturnType("double");
   }

   @DisplayName("2c Computes approximately n!")
   @Test
   @Grade(value = 1, feedback = "factorial(n) should return something close (5%) to n!")
   void approximateFactorialN() {
      Stirling stirling = new Stirling();
      soft.assertThat((double)stirling.factorial(7)).isCloseTo(5040, withinPercentage(5));
      soft.assertThat((double)stirling.factorial(8)).isCloseTo(40320, withinPercentage(5));
      soft.assertThat((double)stirling.factorial(9)).isCloseTo(362880, withinPercentage(5));
      soft.assertThat((double)stirling.factorial(11)).isCloseTo(39916800, withinPercentage(5));
   }

   @DisplayName("2d Computes the given Stirling formula")
   @Test
   @Grade(value = 1, feedback = "factorial(n) should return exactly the value from the formula")
   void exactStirling() {
      Stirling stirling = new Stirling();
      soft.assertThat((double)stirling.factorial(7)).isCloseTo(5039.686258179277, within(0.001));
      soft.assertThat((double)stirling.factorial(8)).isCloseTo(40318.045405288554, within(0.001));
      soft.assertThat((double)stirling.factorial(9)).isCloseTo(362865.9179608553, within(0.001));
      soft.assertThat((double)stirling.factorial(11)).isCloseTo(3.991574342217284E7, within(0.001));
   }

   @DisplayName("2e Calls static Math methods pow and sqrt")
   @Test
   @Grade(value = 0.5, feedback = "factorial(n) should call Math.pow() and Math.sqrt()")
   void makesStaticCallsToMath() {
      File actualFile = new File("src/maths/Stirling.java");
      soft.assertThat(contentOf(actualFile)).contains("Math.pow", "Math.sqrt");
   }

   @DisplayName("2f Uses Math constants E and PI")
   @Test
   @Grade(value = 0.5, feedback = "factorial(n) should use Math.E and Math.PI")
   void usesMathConstants() {
      File actualFile = new File("src/maths/Stirling.java");
      soft.assertThat(contentOf(actualFile)).contains("Math.E", "Math.PI");
   }
}
