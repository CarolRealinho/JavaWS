package bikes;

import java.lang.reflect.Field;

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

@GradedTest(gradesFile = "Ex-2.1.txt", summaryFile = "Ex-2.1.csv")
@ExtendWith(SoftAssertionsExtension.class)
@DisplayName("2.1 Bike class (4 points)")
@TestMethodOrder(MethodOrderer.DisplayName.class)
public class BikeGradingTest implements WithAssertions {

   @InjectSoftAssertions
   TypeSoftAssertions soft;

   @DisplayName("2.1.1 Constructor, id and totalDistance attributes and getters")
   @Grade(value = 1, feedback = "constructor should initialize id and totalDistance attributes, getters should return them")
   @Test
   void testBikeAttributesAndConstructor() {
      Bike bike = new Bike("Foo");

      soft.assertThat(bike).isNotNull();
      soft.assertThat(bike).extracting("id").isEqualTo("Foo");
      soft.assertThat(bike).extracting("totalDistance").isEqualTo(0.0);
      soft.assertThat(bike.getId()).isEqualTo("Foo");
      soft.assertThat(bike.getTotalDistance()).isEqualTo(0.0);
   }

   @DisplayName("2.1.2 toString() method")
   @Grade(value = 1, feedback = "toString() should return a string with the id and totalDistance attributes")
   @Test
   public void testBikeToString() {
      Bike bike = new Bike("Baz");

      soft.assertThat(bike.toString()).contains("Baz", "0");

      // check that toString() uses the id and totalDistance attributes
      try {
         // change attribute id even if it is private
         Field id = bike.getClass().getDeclaredField("id");
         id.setAccessible(true);
         id.set(bike, "Qux");
         // change attribute totalDistance even if it is private
         Field totalDistance = bike.getClass().getDeclaredField("totalDistance");
         totalDistance.setAccessible(true);
         totalDistance.set(bike, 1650.0);
         // check that toString() uses the new values of id and totalDistance
         soft.assertThat(bike.toString()).contains("Qux", "1650.0");
      } catch (Exception e) {
         soft.fail("attribute 'id' or 'totalDistance' missing or badly typed in class Bike");
      }
   }

   @DisplayName("2.1.3 rentals attribute and getter")
   @Grade(value = 1, feedback = "rentals attribute should be initialized to an empty list, getter should return it")
   @Test
   public void testBikeRentalsIsAnInitiallyEmptyList() {
      Bike bike = new Bike("Bar");

      soft.assertThat(bike).extracting("rentals")
            .isNotNull()
            .asInstanceOf(InstanceOfAssertFactories.LIST).isEmpty();
      soft.assertThat(bike.getRentals())
            .isNotNull()
            .asInstanceOf(InstanceOfAssertFactories.LIST).isEmpty();
      soft.assertThat(bike).extracting("rentals")
            .isEqualTo(bike.getRentals());
   }

   @DisplayName("2.1.4 public and private visibility")
   @Grade(value = 1, feedback = "attributes should be private, the rest should be public")
   @Test
   public void testBikeVisibility() {
      TypeInfo bikeClass = TypeInfo.info(Bike.class);
      soft.assertThat(bikeClass)
            .hasFieldCountGreaterThanOrEqualTo(1)
            .hasOnlyPrivateAttributes()
            .hasConstructorCountGreaterThanOrEqualTo(1)
            .hasOnlyPublicConstructors()
            .hasMethodCountGreaterThanOrEqualTo(1)
            .hasOnlyPublicMethods()
            .hasVisibility("public");
   }
}
