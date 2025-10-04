package bikes;

import static com.github.stefanbirkner.systemlambda.SystemLambda.tapSystemErrAndOutNormalized;

import org.assertj.core.api.InstanceOfAssertFactories;
import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(OrderAnnotation.class)
public class BikeRentalSystemPartialTest implements WithAssertions {

    @Test
    @Order(1)
    public void testConstructor() {
        BikeRentalSystem sys = new BikeRentalSystem();

        assertThat(sys).isNotNull();
        assertThat(sys).extracting("bikes")
                .isNotNull()
                .asInstanceOf(InstanceOfAssertFactories.MAP).isEmpty();
        assertThat(sys).extracting("rentals")
                .isNotNull()
                .asInstanceOf(InstanceOfAssertFactories.LIST).isEmpty();
    }

    @Test
    @Order(2)
    public void testAddBike() {
        BikeRentalSystem sys = new BikeRentalSystem();
        sys.addBike("X");
        sys.addBike("Y");
        assertThat(sys).extracting("bikes")
                .asInstanceOf(InstanceOfAssertFactories.MAP)
                .hasSize(2)
                .containsOnlyKeys("X", "Y");
        assertThat(sys).extracting("bikes")
                .asInstanceOf(InstanceOfAssertFactories.MAP)
                .extractingByKeys("X", "Y")
                .isNotNull()
                .extracting("id")
                .containsExactly("X", "Y");
    }

    @Test
    @Order(3)
    public void testRecordRental() {
        BikeRentalSystem sys = new BikeRentalSystem();
        sys.addBike("X");
        sys.addBike("Y");
        sys.recordRental("X", "Bob", 10.0);
        sys.recordRental("Y", "Alice", 20.0);
        assertThat(sys).extracting("rentals")
                .asInstanceOf(InstanceOfAssertFactories.LIST)
                .hasSize(2);
        assertThat(sys).extracting("rentals")
                .asInstanceOf(InstanceOfAssertFactories.LIST)
                .extracting("bike.id")
                .contains("X", "Y");
        assertThat(sys).extracting("rentals")
                .asInstanceOf(InstanceOfAssertFactories.LIST)
                .extracting("user")
                .contains("Bob", "Alice");
        assertThat(sys).extracting("rentals")
                .asInstanceOf(InstanceOfAssertFactories.LIST)
                .extracting("distance")
                .contains(10.0, 20.0);
    }

    @Test
    @Order(4)
    public void testShowAll() throws Exception {
        BikeRentalSystem sys = new BikeRentalSystem();
        sys.addBike("X");
        sys.addBike("Y");
        sys.recordRental("X", "Bob", 10.0);
        sys.recordRental("Y", "Alice", 20.0);
        String text = tapSystemErrAndOutNormalized(() -> {
            sys.showAll();
        });
        assertThat(text).contains("X", "Y", "Bob", "Alice", "10", "20");
    }
}