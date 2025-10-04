package summits;

import java.util.Collection;
import java.util.Map;

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

@GradedTest(gradesFile = "Ex-1.3.txt", summaryFile = "Ex-1.3.csv")
@ExtendWith(SoftAssertionsExtension.class)
@DisplayName("1.3 SummitCollection class")
@TestMethodOrder(MethodOrderer.DisplayName.class)
public class SummitCollectionGradingTest implements WithAssertions {

	@InjectSoftAssertions
	TypeSoftAssertions soft;
	TypeInfo info = TypeInfo.info(SummitCollection.class);

	@DisplayName("1.3a Private attributes")
	@Test
	@Grade(value = 0.5, feedback = "Attributes should be private")
	public void attributesVisibility() {
		soft.assertThat(info).hasOnlyPrivateAttributes();
		soft.assertThat(info).hasFieldCountGreaterThanOrEqualTo(1);
	}

	@DisplayName("1.3b Public constructor and methods")
	@Test
	@Grade(value = 0.5, feedback = "Constructors and methods should be public")
	public void constructorAndMembersVisibility() {
		soft.assertThat(info).hasOnlyPublicConstructors();
		soft.assertThat(info).hasOnlyPublicMethods();
		soft.assertThat(info).hasConstructorCountGreaterThanOrEqualTo(1);
		soft.assertThat(info).hasMethodCountGreaterThanOrEqualTo(1);
	}

	@DisplayName("1.3c SummitCollection-Summit association: type of summits attribute")
	@Test
	@Grade(value = 1, feedback = "Summit should have an HashMap<String, Summit> summits attribute")
	public void summitsType() {
		soft.assertThat(info.getField("summits").field).hasType("HashMap<String, Summit>");
	}

	@DisplayName("1.3d SummitCollection-Summit association: adding summits")
	@Test
	@Grade(value = 1, feedback = "Add should store the specified summits in the collection")
	public void addSummits() {
		Summit s1 = new Summit("S1", 1000);
		Summit s2 = new Summit("S2", 2000);
		Summit s3 = new Summit("S3", 3000);
		Summit s4 = new Summit("S4", 4000);

		Class<?> attributeClass = info.getField("summits").field.getType();

		SummitCollection collection = new SummitCollection();
		soft.assertThat(collection).isNotNull();
		soft.assertThat(collection).extracting("summits").isNotNull();

		if (Map.class.isAssignableFrom(attributeClass)) {
			soft.assertThat(collection).extracting("summits")
					.asInstanceOf(MAP)
					.isEmpty();
			collection.add(s1);
			soft.assertThat(collection).extracting("summits")
					.asInstanceOf(MAP)
					.containsEntry("S1", s1);
			collection.add(s2);
			collection.add(s3);
			collection.add(s4);
			soft.assertThat(collection).extracting("summits")
					.asInstanceOf(MAP)
					.containsOnly(entry("S1", s1), entry("S2", s2), entry("S3", s3), entry("S4", s4));
		} else if (Collection.class.isAssignableFrom(attributeClass)) {
			soft.assertThat(collection).extracting("summits")
					.asInstanceOf(COLLECTION)
					.isEmpty();
			collection.add(s1);
			soft.assertThat(collection).extracting("summits")
					.asInstanceOf(COLLECTION)
					.contains(s1);
			collection.add(s2);
			collection.add(s3);
			collection.add(s4);
			soft.assertThat(collection).extracting("summits")
					.asInstanceOf(COLLECTION)
					.containsExactlyInAnyOrder(s1, s2, s3, s4);
		} else {
			fail("should be some collection");
		}

	}

	@DisplayName("1.3e SummitCollection-Summit association: getting summits")
	@Test
	@Grade(value = 1, feedback = "Get should retrieve any added summit without breaking the collection")
	public void testAddGetFourSummits() {
		SummitCollection collection = new SummitCollection();

		// add 4 summits
		Summit s1 = new Summit("S1", 1000);
		Summit s2 = new Summit("S2", 2000);
		Summit s3 = new Summit("S3", 3000);
		Summit s4 = new Summit("S4", 4000);
		collection.add(s1);
		collection.add(s2);
		collection.add(s3);
		collection.add(s4);

		// random order for get
		soft.assertThat(collection.get("S3"))
				.isNotNull()
				.extracting("name", "altitude").containsExactly("S3", 3000);
		soft.assertThat(collection.get("S4"))
				.isNotNull()
				.extracting("name", "altitude").containsExactly("S4", 4000);
		soft.assertThat(collection.get("S2"))
				.isNotNull()
				.extracting("name", "altitude").containsExactly("S2", 2000);
		soft.assertThat(collection.get("S1"))
				.isNotNull()
				.extracting("name", "altitude").containsExactly("S1", 1000);

		// collection was not broken by calls to get(): can do it again
		soft.assertThat(collection.get("S1"))
				.isNotNull()
				.extracting("name", "altitude").containsExactly("S1", 1000);
		soft.assertThat(collection.get("S2"))
				.isNotNull()
				.extracting("name", "altitude").containsExactly("S2", 2000);
		soft.assertThat(collection.get("S3"))
				.isNotNull()
				.extracting("name", "altitude").containsExactly("S3", 3000);
		soft.assertThat(collection.get("S4"))
				.isNotNull()
				.extracting("name", "altitude").containsExactly("S4", 4000);
	}
}
