package bikes;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.assertj.core.api.InstanceOfAssertFactories;
import org.assertj.core.api.JUnitSoftAssertions;
import org.assertj.core.api.WithAssertions;
import org.assertj.core.api.junit.jupiter.SoftAssertionsExtension;
import org.junit.Rule;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;

import fr.supaero.grader.annotations.Grade;
import fr.supaero.grader.annotations.GradedTest;
import fr.supaero.matchers.assertions.TypeSoftAssertions;
import fr.supaero.matchers.utils.TypeInfo;

@GradedTest(gradesFile = "Ex-2.2.txt", summaryFile = "Ex-2.2.csv")
@ExtendWith(SoftAssertionsExtension.class)
@DisplayName("2.2 Rental class and Bike.addRental() method (5 points)")
@TestMethodOrder(MethodOrderer.DisplayName.class)
public class RentalGradingTest implements WithAssertions {

    @Rule
    public final JUnitSoftAssertions softly = new JUnitSoftAssertions();

    @Rule
    public final TypeSoftAssertions type_softly = new TypeSoftAssertions();

    @DisplayName("2.2.1 Rental attributes and constructor")
    @Grade(value = 1, feedback = "A rental instance should have bike, user and distance attributes. The constructor should initialize them.")
    @Test
    public void testRentalConstruction() {
        // Given
        Bike bike = mock(Bike.class);

        // When
        Rental rental = new Rental(bike, "Bob", 42.42);

        // Then
        softly.assertThat(rental).extracting("user").isEqualTo("Bob");
        softly.assertThat(rental).extracting("bike").isEqualTo(bike);
        softly.assertThat(rental).extracting("distance").isEqualTo(42.42);
        softly.assertAll();
    }

    @DisplayName("2.2.2 Rental toString() method")
    @Grade(value = 1, feedback = "toString() should include all attributes : bike, user and distance.")
    @Test
    public void testRentalToString() {
        // Given
        Bike bike = mock(Bike.class);
        given(bike.getId()).willReturn("B42");
        given(bike.getTotalDistance()).willReturn(100.0);
        given(bike.toString()).willReturn("B42 (100 km)");

        // When
        Rental rental = new Rental(bike, "Bob", 42.42);

        // Then
        assertThat(rental.toString())
                .contains("B42", "Bob", "42.42");
    }

    @DisplayName("2.2.3 Rental public and private visibility")
    @Grade(value = 0.5, feedback = "attributes should be private, the rest should be public")
    @Test
    public void testRentalVisibility() {
        TypeInfo rentalClass = TypeInfo.info(Rental.class);
        type_softly.assertThat(rentalClass)
                .hasFieldCountGreaterThanOrEqualTo(3)
                .hasOnlyPrivateAttributes()
                .hasConstructorCountGreaterThanOrEqualTo(1)
                .hasOnlyPublicConstructors()
                .hasMethodCountGreaterThanOrEqualTo(1)
                .hasOnlyPublicMethods()
                .hasVisibility("public");
        type_softly.assertAll();
    }

    @DisplayName("2.2.4 Rental constructor calling Bike's addRental() method")
    @Grade(value = 1, feedback = "The rental constructor should call 'bike.addRental(this)''.")
    @Test
    public void testAddRentalCalledInBike() {
        // Given
        Bike bike = mock(Bike.class);

        // When
        Rental rental = new Rental(bike, "Bob", 42.42);

        // Then
        verify(bike).addRental(rental); // addRental() was called with a reference to the rental object
    }

    @DisplayName("2.2.5 Bike: rentals storage")
    @Grade(value = 1, feedback = "Every new rental should be added to the rentals list of the associated bike.")
    @Test
    public void testRentalsAreStoredInBike() {
        // Given
        Bike cargo = new Bike("Cargo");
        Bike vtt = new Bike("VTT");

        // When
        Rental rental1 = new Rental(cargo, "Alice", 10.0);

        // Then
        softly.assertThat(cargo)
                .extracting("rentals").asInstanceOf(InstanceOfAssertFactories.LIST)
                .hasSize(1)
                .contains(rental1);
        softly.assertThat(cargo)
                .extracting("rentals").asInstanceOf(InstanceOfAssertFactories.LIST)
                .isEmpty();

        // And then when
        Rental rental2 = new Rental(vtt, "Alice", 20.0);
        Rental rental3 = new Rental(vtt, "Bob", 100.0);
        Rental rental4 = new Rental(cargo, "Bob", 32.0);

        // Then
        assertThat(cargo)
                .extracting("rentals").asInstanceOf(InstanceOfAssertFactories.LIST)
                .hasSize(2)
                .contains(rental1, rental4);
        assertThat(vtt)
                .extracting("rentals").asInstanceOf(InstanceOfAssertFactories.LIST)
                .hasSize(2)
                .contains(rental2, rental3);
    }

    @DisplayName("2.2.6 Bike: total distance update")
    @Grade(value = 0.5, feedback = "Every rental creation should trigger an update of the total distance of the associated bike.")
    @Test
    public void testRentalEffectOnBikeDistance() {
        // Given
        Bike bike = new Bike("B1");

        // When
        new Rental(bike, "Bob", 4);

        // Then
        assertThat(bike.getTotalDistance()).isEqualTo(4);

        // And then when
        new Rental(bike, "Alice", 42);

        // Then
        assertThat(bike.getTotalDistance()).isEqualTo(46);
    }

}
