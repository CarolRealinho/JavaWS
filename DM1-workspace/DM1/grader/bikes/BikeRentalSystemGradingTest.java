package bikes;

import static com.github.stefanbirkner.systemlambda.SystemLambda.tapSystemErrAndOutNormalized;
import static org.mockito.Mockito.RETURNS_DEEP_STUBS;
import static org.mockito.Mockito.mockConstruction;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.withSettings;

import org.assertj.core.api.Condition;
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
import org.mockito.MockedConstruction;

import fr.supaero.grader.annotations.Grade;
import fr.supaero.grader.annotations.GradedTest;
import fr.supaero.matchers.assertions.TypeSoftAssertions;
import fr.supaero.matchers.utils.FieldInfo;
import fr.supaero.matchers.utils.TypeInfo;

@GradedTest(gradesFile = "Ex-2.3.txt", summaryFile = "Ex-2.3.csv")
@ExtendWith(SoftAssertionsExtension.class)
@DisplayName("2.3 BikeRentalSystem class (5 points)")
@TestMethodOrder(MethodOrderer.DisplayName.class)
public class BikeRentalSystemGradingTest implements WithAssertions {

    final private MockedConstruction<Bike> makeMockBike() {
        return mockConstruction(
                Bike.class,
                withSettings().defaultAnswer(RETURNS_DEEP_STUBS),
                (mock, context) -> {
                    String id = (String) context.arguments().get(0);
                    when(mock.getId()).thenReturn(id);
                    when(mock.toString()).thenReturn(String.format("Bike %s", id));
                });
    }

    final private MockedConstruction<Rental> makeMockRental() {
        return mockConstruction(
                Rental.class,
                withSettings().defaultAnswer(RETURNS_DEEP_STUBS),
                (mock, context) -> {
                    Bike bike = (Bike) context.arguments().get(0);
                    String str = bike.toString();
                    String name = (String) context.arguments().get(1);
                    double distance = (double) context.arguments().get(2);
                    when(mock.toString())
                            .thenReturn(String.format("%s %s %.2f", str, name, distance));
                });
    }

    @Rule
    public final JUnitSoftAssertions softly = new JUnitSoftAssertions();

    @Rule
    public final TypeSoftAssertions type_softly = new TypeSoftAssertions();

    private Condition<FieldInfo> declaredAs(String type) {
        return new Condition<>(fieldInfo -> fieldInfo.type.equals(type),
                "is declared as " + type);
    }

    @SuppressWarnings("unchecked")
    @DisplayName("2.3.1 bikes attribute type and initialization")
    @Grade(value = 1, feedback = "bikes attribute should be a map and rentals should be a list, initialized as empty in the constructor")
    @Test
    public void testSystemConstruction() {
        // When
        BikeRentalSystem system = new BikeRentalSystem();

        // Then
        softly.assertThat(system).extracting("bikes")
                .isNotNull()
                .asInstanceOf(InstanceOfAssertFactories.MAP)
                .isEmpty();
        softly.assertThat(system).extracting("rentals")
                .isNotNull()
                .asInstanceOf(InstanceOfAssertFactories.LIST)
                .isEmpty();
        softly.assertAll();

        TypeInfo info = TypeInfo.info(BikeRentalSystem.class);
        FieldInfo fieldInfo = info.getField("bikes");
        type_softly.assertThat(fieldInfo)
                .is(anyOf(
                        declaredAs("Map<String, Bike>"),
                        declaredAs("TreeMap<String, Bike>"),
                        declaredAs("HashMap<String, Bike>"),
                        declaredAs("LinkedHashMap<String, Bike>"),
                        declaredAs("Hashtable<String, Bike>")));
    }

    // Bikes management parts

    @DisplayName("2.3.2 addBike() method")
    @Grade(value = 1, feedback = "addBike() method should create and add a bike to the bikes map")
    @Test
    public void testAddBike() {
        try (MockedConstruction<Bike> mockBike = makeMockBike()) {
            // Given
            BikeRentalSystem system = new BikeRentalSystem();

            // When
            system.addBike("X");
            system.addBike("Y");

            // Then
            softly.assertThat(system).extracting("bikes")
                    .asInstanceOf(InstanceOfAssertFactories.MAP)
                    .hasSize(2)
                    .containsOnlyKeys("X", "Y");
            softly.assertThat(system).extracting("bikes")
                    .asInstanceOf(InstanceOfAssertFactories.MAP)
                    .extractingByKey("X", InstanceOfAssertFactories.type(Bike.class))
                    .matches(bike -> bike.getId().equals("X"), "X bike id is X");
            softly.assertThat(system).extracting("bikes")
                    .asInstanceOf(InstanceOfAssertFactories.MAP)
                    .extractingByKey("Y", InstanceOfAssertFactories.type(Bike.class))
                    .matches(bike -> bike.getId().equals("Y"), "Y bike id is Y");
            softly.assertAll();
        }
    }

    @DisplayName("2.3.3 addBike() method with duplicate")
    @Grade(value = 0.5, feedback = "addBike() method should report an error when adding a duplicate bike")
    @Test
    public void testAddDuplicateBike() throws Exception {
        try (MockedConstruction<Bike> mockBike = makeMockBike()) {
            // Given
            BikeRentalSystem sys = new BikeRentalSystem();
            sys.addBike("X");
            sys.addBike("Y");

            // When
            String text = tapSystemErrAndOutNormalized(() -> {
                try {
                    sys.addBike("X");
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            });

            // Then
            softly.assertThat(text).isNotBlank(); // ideally should contain "Bike already exists" or something similar
            softly.assertThat(sys).extracting("bikes")
                    .asInstanceOf(InstanceOfAssertFactories.MAP)
                    .extractingByKey("Y", InstanceOfAssertFactories.type(Bike.class))
                    .matches(bike -> bike.getId().equals("Y"), "Y bike id is Y");
            softly.assertAll();
        }
    }

    // Rentals management part

    @DisplayName("2.3.4 recordRental() method")
    @Grade(value = 1, feedback = "recordRental() method should create and add a rental to the rentals list")
    @Test
    public void testRecordRental() {
        try (MockedConstruction<Bike> mockBike = makeMockBike();
                MockedConstruction<Rental> mockRental = makeMockRental()) {
            // Given
            BikeRentalSystem system = new BikeRentalSystem();
            system.addBike("X");
            system.addBike("Y");

            // When
            system.recordRental("X", "Alice", 42.42);
            system.recordRental("Y", "Bob", 24.24);
            system.recordRental("Y", "Alice", 100);

            // Then
            softly.assertThat(system).extracting("rentals")
                    .asInstanceOf(InstanceOfAssertFactories.LIST)
                    .hasSize(3)
                    .element(0, InstanceOfAssertFactories.type(Rental.class))
                    .hasToString("Bike X Alice 42.42");
            softly.assertThat(system).extracting("rentals")
                    .asInstanceOf(InstanceOfAssertFactories.LIST)
                    .element(1, InstanceOfAssertFactories.type(Rental.class))
                    .hasToString("Bike Y Bob 24.24");
            softly.assertThat(system).extracting("rentals")
                    .asInstanceOf(InstanceOfAssertFactories.LIST)
                    .element(2, InstanceOfAssertFactories.type(Rental.class))
                    .hasToString("Bike Y Alice 100.00");
            softly.assertAll();
        }
    }

    @DisplayName("2.3.5 recordRental() method with unknown bike")
    @Grade(value = 0.5, feedback = "recordRental() method should report an error when adding a rental for an unknown bike")
    @Test
    public void testRecordRentalBikeNotFound() throws Exception {
        try (MockedConstruction<Bike> mockBike = makeMockBike();
                MockedConstruction<Rental> mockRental = makeMockRental()) {
            // Given
            BikeRentalSystem system = new BikeRentalSystem();
            system.addBike("X");
            system.addBike("Y");

            // When
            system.recordRental("X", "Alice", 42.42);
            system.recordRental("Y", "Bob", 24.24);
            system.recordRental("Y", "Alice", 100);
            String text = tapSystemErrAndOutNormalized(() -> {
                try {
                    system.recordRental("Z", "Alice", 777);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            });

            // Then
            softly.assertThat(text).isNotBlank(); // ideally should contain "Bike does not exist" or something similar
            softly.assertThat(system).extracting("rentals")
                    .asInstanceOf(InstanceOfAssertFactories.LIST)
                    .hasSize(3)
                    .element(0, InstanceOfAssertFactories.type(Rental.class))
                    .hasToString("Bike X Alice 42.42");
            softly.assertThat(system).extracting("rentals")
                    .asInstanceOf(InstanceOfAssertFactories.LIST)
                    .element(1, InstanceOfAssertFactories.type(Rental.class))
                    .hasToString("Bike Y Bob 24.24");
            softly.assertThat(system).extracting("rentals")
                    .asInstanceOf(InstanceOfAssertFactories.LIST)
                    .element(2, InstanceOfAssertFactories.type(Rental.class))
                    .hasToString("Bike Y Alice 100.00");

            softly.assertAll();
        }
    }

    @DisplayName("2.3.6 showAll() method")
    @Grade(value = 0.5, feedback = "showAll() method should print all bikes and rentals")
    @Test
    public void testShowAll() throws Exception {
        try (MockedConstruction<Bike> mockBike = makeMockBike();
                MockedConstruction<Rental> mockRental = makeMockRental()) {
            // Given
            BikeRentalSystem system = new BikeRentalSystem();
            system.addBike("X");
            system.addBike("Y");
            system.recordRental("X", "Alice", 42.42);
            system.recordRental("Y", "Bob", 24.24);
            system.recordRental("Y", "Alice", 100);

            // When
            String text = tapSystemErrAndOutNormalized(() -> {
                system.showAll();
            });

            // Then (mockups toString() methods)
            assertThat(text).contains(
                    "Bike X",
                    "Bike Y",
                    "Bike X Alice 42.42",
                    "Bike Y Bob 24.24",
                    "Bike Y Alice 100.00");
        }
    }

    @DisplayName("2.3.7 public and private visibility")
    @Grade(value = 0.5, feedback = "attributes should be private, the rest should be public")
    @Test
    public void testBikeVisibility() {
        TypeInfo bikesRentalSystemClass = TypeInfo.info(BikeRentalSystem.class);
        type_softly.assertThat(bikesRentalSystemClass)
                .hasFieldCountGreaterThanOrEqualTo(1)
                .hasOnlyPrivateAttributes()
                .hasConstructorCountGreaterThanOrEqualTo(1)
                .hasOnlyPublicConstructors()
                .hasMethodCountGreaterThanOrEqualTo(1)
                .hasOnlyPublicMethods()
                .hasVisibility("public");
        type_softly.assertAll();
    }
}