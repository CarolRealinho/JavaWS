package bikes;

import java.lang.reflect.Field;

import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

@TestMethodOrder(OrderAnnotation.class)
public class BikePartialTest implements WithAssertions {

   @Test
   @Order(1)
   public void testConstructor() {
      Bike bike = new Bike("B1");

      assertThat(bike).isNotNull();
      assertThat(bike).extracting("id").isEqualTo("B1");
      assertThat(bike).extracting("totalDistance").isEqualTo(0.0);
   }

   @Test
   @Order(2)
   public void testGetters() {
      Bike bike = new Bike("B2");

      assertThat(bike.getId()).isEqualTo("B2");
      assertThat(bike.getTotalDistance()).isEqualTo(0.0);
      assertThat(bike.getRentals()).isNotNull().isEmpty();
   }

   @Test
   @Order(3)
   public void testToString() {
      Bike bike = new Bike("B3");

      assertThat(bike.toString()).contains("B3", "0");

      // check that toString() uses the id and totalDistance attributes
      try {
         // change attribute id to "B2" even if it is private
         Field id = bike.getClass().getDeclaredField("id");
         id.setAccessible(true);
         id.set(bike, "B2");
         // change attribute totalDistance to 42.0 even if it is private
         Field totalDistance = bike.getClass().getDeclaredField("totalDistance");
         totalDistance.setAccessible(true);
         totalDistance.set(bike, 42.0);
         // check that toString() uses the new values of id and totalDistance
         assertThat(bike.toString()).contains("B2", "42.0");
      } catch (Exception e) {
         fail("attribute 'id' or 'totalDistance' missing or badly typed in class Bike");
      }
   }

}