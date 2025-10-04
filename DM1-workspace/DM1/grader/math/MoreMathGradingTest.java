package math;

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
import fr.supaero.matchers.assertions.TypeSoftAssertions;
import fr.supaero.matchers.utils.TypeInfo;

@GradedTest(gradesFile = "Ex-1.txt", summaryFile = "Ex-1.csv")
@ExtendWith(SoftAssertionsExtension.class)
@DisplayName("1 MoreMath class (4 points)")
@TestMethodOrder(MethodOrderer.DisplayName.class)
public class MoreMathGradingTest implements WithAssertions {

   @InjectSoftAssertions
   TypeSoftAssertions soft;

   @DisplayName("1.1 asinh() computes the right value")
   @Grade(value = 1, feedback = "asinh() should return exactly the value from the formula")
   @Test
   @SuppressWarnings("static-access")
   void asinhForValidInputWorks() {
      MoreMath mm = new MoreMath();
      soft.assertThat(mm.asinh(1.5)).isEqualTo(1.19476, within(1e-5));
   }

   @DisplayName("1.2 acosh(x) computes the right value for valid x")
   @Grade(value = 1, feedback = "acosh() should return exactly the value from the formula")
   @Test
   @SuppressWarnings("static-access")
   void acoshForValidInputWorks() {
      MoreMath mm = new MoreMath();
      soft.assertThat(mm.acosh(2.0)).isEqualTo(1.31696, within(1e-5));
   }

   @DisplayName("1.3 acosh(x) method returns NaN for invalid x")
   @Grade(value = 0.5, feedback = "acosh(x) should return NaN when x < 1")
   @Test
   @SuppressWarnings("static-access")
   void acoshForInvalidInputIsNaN() {
      MoreMath mm = new MoreMath();
      soft.assertThat(mm.acosh(0)).isNaN();
      soft.assertThat(mm.acosh(Math.nextDown(1.0))).isNaN();
   }

   @DisplayName("1.4 Methods are static")
   @Grade(value = 0.5, feedback = "asinh and acosh should be declared static")
   @Test
   public void methodsAreStatic() {
      TypeInfo moreMathClass = TypeInfo.info(MoreMath.class);

      soft.assertThat(moreMathClass.getDeclaredMethodsNames()).contains("asinh");
      for (String signature : moreMathClass.getDeclaredMethodsSignatures()) {
         soft.assertThat(moreMathClass.getMethod(signature).method)
               .hasAllModifiersOf("static");
      }

      soft.assertThat(moreMathClass.getDeclaredMethodsNames()).contains("acosh");
      for (String signature : moreMathClass.getDeclaredMethodsSignatures()) {
         if (signature.contains("acosh")) {
            soft.assertThat(moreMathClass.getMethod(signature).method)
                  .hasAllModifiersOf("static");
         }
      }
   }

   @DisplayName("1.5 Methods are public and return double (Double also accepted)")
   @Grade(value = 0.5, feedback = "asinh and acosh should be public and return double")
   @Test
   public void methodsArePublicAndReturnDouble() {
      TypeInfo moreMathClass = TypeInfo.info(MoreMath.class);

      soft.assertThat(moreMathClass.getDeclaredMethodsNames()).contains("asinh");
      for (String signature : moreMathClass.getDeclaredMethodsSignatures()) {
         if (signature.contains("asinh")) {
            soft.assertThat(moreMathClass.getMethod(signature).method)
                  .hasVisibility("public")
                  .hasReturnTypeIn("double, Double");
         }
      }

      soft.assertThat(moreMathClass.getDeclaredMethodsNames()).contains("acosh");
      for (String signature : moreMathClass.getDeclaredMethodsSignatures()) {
         if (signature.contains("acosh")) {
            soft.assertThat(moreMathClass.getMethod(signature).method)
                  .hasVisibility("public")
                  .hasReturnTypeIn("double, Double");
         }
      }
   }

   @DisplayName("1.6 Predefined Math methods are used")
   @Test
   @Grade(value = 0.5, feedback = "MoreMath code should use Math.log() and Math.sqrt()")
   void predefinedMathMethodsAreUsed() {
      File actualFile = new File("src/math/MoreMath.java");
      soft.assertThat(contentOf(actualFile))
            .contains("Math.log")
            .contains("Math.sqrt");
   }

}
