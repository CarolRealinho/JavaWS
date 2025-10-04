package summits;

import java.lang.reflect.Field;

import org.assertj.core.api.WithAssertions;
import org.assertj.core.api.junit.jupiter.InjectSoftAssertions;
import org.assertj.core.api.junit.jupiter.SoftAssertionsExtension;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;

import fr.supaero.grader.annotations.Grade;
import fr.supaero.grader.annotations.GradedTest;
import fr.supaero.matchers.assertions.TypeSoftAssertions;
import fr.supaero.matchers.utils.TypeInfo;

@GradedTest(gradesFile = "Ex-1.2.txt", summaryFile = "Ex-1.2.csv")
@ExtendWith(SoftAssertionsExtension.class)
@DisplayName("1.2 Summit class")
@TestMethodOrder(MethodOrderer.DisplayName.class)
public class SummitGradingTest implements WithAssertions {

   @InjectSoftAssertions
   TypeSoftAssertions soft;
   TypeInfo info = TypeInfo.info(Summit.class);

   Report r1, r2, r3, r4, r5;

   @BeforeEach
   public void setupExpectedReportAttributeValues()  {

      r1 = new Report("R1", 3);
      r2 = new Report("R2", 3);
      r3 = new Report("R3", 2);
      r4 = new Report("R4", 1);
      r5 = new Report("R5", 1);
      try {
         Field difficultyLevel = Report.class.getDeclaredField("difficultyLevel");
         difficultyLevel.setAccessible(true);
         difficultyLevel.set(r1, 3);
         difficultyLevel.set(r2, 3);
         difficultyLevel.set(r3, 2);
         difficultyLevel.set(r4, 1);
         difficultyLevel.set(r5, 1);
      } catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
         // do not stop tests if field cannot be accessed
      }

      try {
         Field description = Report.class.getDeclaredField("description");
         description.setAccessible(true);
         description.set(r1, "R1");
         description.set(r2, "R2");
         description.set(r3, "R3");
         description.set(r4, "R4");
         description.set(r5, "R5");
      } catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
         // do not stop tests if field cannot be accessed
      }
   }

   @DisplayName("1.2a Private attributes")
   @Test
   @Grade(value = 0.5, feedback = "Attributes should be private")
   public void attributesVisibility() {
      soft.assertThat(info).hasOnlyPrivateAttributes();
      soft.assertThat(info).hasFieldCountGreaterThanOrEqualTo(1);
   }

   @DisplayName("1.2b Public constructor and methods")
   @Test
   @Grade(value = 0.5, feedback = "Constructors and methods should be public")
   public void constructorAndMembersVisibility() {
      soft.assertThat(info).hasOnlyPublicConstructors();
      soft.assertThat(info).hasOnlyPublicMethods();
      soft.assertThat(info).hasConstructorCountGreaterThanOrEqualTo(1);
      soft.assertThat(info).hasMethodCountGreaterThanOrEqualTo(1);
   }

   @DisplayName("1.2c Attributes, constructor, getName() and first part of toString()")
   @Test
   @Grade(value = 0.5, feedback = "Constructor parameters should be stored in attributes and used in toString()")
   public void constructionBasics() {
      Summit summit = new Summit("Pique Longue", 3298);
      soft.assertThat(summit).isNotNull();
      soft.assertThat(summit).extracting("name").isEqualTo("Pique Longue");
      soft.assertThat(summit).extracting("altitude").isEqualTo(3298);
      soft.assertThat(summit.getName()).isEqualTo("Pique Longue");
      soft.assertThat(summit.toString()).contains("Pique Longue", "3298");
   }

   @DisplayName("1.2d Summit-Report association: type of reports attribute")
   @Test
   @Grade(value = 0.5, feedback = "Summit should have an ArrayList<Report> reports attribute")
   public void reportsType() {
      soft.assertThat(info.getField("reports").field).hasType("ArrayList<Report>");
   }

   @DisplayName("1.2e Summit-Report association: managing reports")
   @Test
   @Grade(value = 1, feedback = "Added reports should be stored in the reports list")
   public void reportsAddition() {
      Summit summit = new Summit("Pique Longue", 3298);
      soft.assertThat(summit).extracting("reports").isNotNull();
      soft.assertThat(summit).extracting("reports").asList().isEmpty();
      summit.addReport(r1);
      soft.assertThat(summit).extracting("reports").asList().hasSize(1);
      summit.addReport(r2);
      soft.assertThat(summit).extracting("reports").asList().hasSize(2);
      summit.addReport(r3);
      soft.assertThat(summit).extracting("reports").asList().hasSize(3);
   }

   @DisplayName("1.2f Summit-Report association: computing mean difficulty level")
   @Test
   @Grade(value = 0.5, feedback = "Mean difficulty level should take into account all added reports")
   public void meanDifficultyLevel() {
      Summit summit = new Summit("Pique Longue", 3298);
      soft.assertThat(summit.meanDifficultyLevel()).isNaN();
      summit.addReport(r1);
      soft.assertThat(summit.meanDifficultyLevel()).isEqualTo(3.0, within(1e-3));
      summit.addReport(r2);
      soft.assertThat(summit.meanDifficultyLevel()).isEqualTo(3.0, within(1e-3));
      summit.addReport(r3);
      summit.addReport(r4);
      summit.addReport(r5);
      soft.assertThat(summit.meanDifficultyLevel()).isEqualTo(2.0, within(1e-3));
   }

   @DisplayName("1.2g toString() should show name, altitude and reports information")
   @Test
   @Grade(value = 0.5, feedback = "toString() should show name, altitude and reports information")
   public void testToString() {
      Summit summit = new Summit("Pique Longue", 3298);
      soft.assertThat(summit.toString()).contains("Pique Longue", "3298");
      summit.addReport(r1);
      soft.assertThat(summit.toString()).contains("Pique Longue", "3298", "1", "3");
      summit.addReport(r2);
      soft.assertThat(summit.toString()).contains("Pique Longue", "3298", "2", "3");
      summit.addReport(r3);
      summit.addReport(r4);
      summit.addReport(r5);
      soft.assertThat(summit.toString()).contains("Pique Longue", "3298", "5", "2");
   }
}
