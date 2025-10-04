package math;

import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.Test;

// Values from Wolfram Alpha, e.g.:
//    https://reference.wolfram.com/language/ref/ArcSinh.html?q=ArcSinh
@SuppressWarnings("all")
public class MoreMathPartialTest implements WithAssertions {

   @Test
   void testValidAsinh() {
      MoreMath mm = new MoreMath();
      assertThat(mm.asinh(1.5)).isEqualTo(1.19476, within(1e-5));
   }

   @Test
   void testValidAcosh() {
      MoreMath mm = new MoreMath();
      assertThat(mm.acosh(2)).isEqualTo(1.31696, within(1e-5));
   }

   @Test
   void testInvalidAcosh() {
      MoreMath mm = new MoreMath();
      assertThat(mm.acosh(0)).isNaN();
   }

}
