package bikes;

import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

@TestMethodOrder(OrderAnnotation.class)
public class RentalPartialTest implements WithAssertions {

   @Test
   @Order(1)
   public void testRentalState() {
      Bike bike = new Bike("B1");
      Rental rental = new Rental(bike, "Bob", 10.0);
      assertThat(rental).extracting("user").isEqualTo("Bob");
      assertThat(rental).extracting("bike").isEqualTo(bike);
      assertThat(rental).extracting("distance").isEqualTo(10.0);
   }

   @Test
   @Order(2)
   public void testRentalIsStoredInBike() {
      Bike bike = new Bike("B1");
      Rental rental = new Rental(bike, "Bob", 10.0);
      assertThat(bike.getRentals()).containsExactly(rental);
   }

   @Test
   @Order(3)
   public void testRentalEffectOnBikeDistance() {
      Bike bike = new Bike("B1");
      new Rental(bike, "Bob", 10.0);
      assertThat(bike.getTotalDistance()).isEqualTo(10.0);
   }

   @Test
   @Order(4)
   public void testSeveralRentals() {
      Bike bike1 = new Bike("B1");
      Bike bike2 = new Bike("B2");

      Rental rental1 = new Rental(bike1, "U1", 10.0);
      Rental rental2 = new Rental(bike2, "U1", 20.0);
      Rental rental3 = new Rental(bike2, "U2", 100.0);

      assertThat(bike1.getRentals()).containsExactly(rental1);
      assertThat(bike2.getRentals()).containsExactly(rental2, rental3);

      assertThat(bike1.getTotalDistance()).isEqualTo(10.0);
      assertThat(bike2.getTotalDistance()).isEqualTo(120.0);
   }

   @Test
   @Order(5)
   public void testToString() {
      Bike bike = new Bike("B1");
      Rental rental = new Rental(bike, "Bob", 10.0);
      assertThat(rental.toString()).contains("B1", "Bob", "10");
   }
}