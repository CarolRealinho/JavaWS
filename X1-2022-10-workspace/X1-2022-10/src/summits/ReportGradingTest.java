package summits;

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
import fr.supaero.matchers.utils.TypeInfo;
import fr.supaero.matchers.assertions.TypeSoftAssertions;

@GradedTest(gradesFile = "Ex-1.1.txt", summaryFile = "Ex-1.1.csv")
@ExtendWith(SoftAssertionsExtension.class)
@DisplayName("1.1 Report class")
@TestMethodOrder(MethodOrderer.DisplayName.class)
public class ReportGradingTest implements WithAssertions {

   @InjectSoftAssertions
   TypeSoftAssertions soft;
   TypeInfo info = TypeInfo.info(Report.class);

   @DisplayName("1.1a Private attributes")
   @Test
   @Grade(value = 0.5, feedback = "Attributes should be private")
   public void attributesVisibility() {
      soft.assertThat(info).hasOnlyPrivateAttributes();
      soft.assertThat(info).hasFieldCountGreaterThanOrEqualTo(1);
   }

   @DisplayName("1.1b Public constructor and methods")
   @Test
   @Grade(value = 0.5, feedback = "Constructors and methods should be public")
   public void constructorAndMembersVisibility() {
      soft.assertThat(info).hasOnlyPublicConstructors();
      soft.assertThat(info).hasOnlyPublicMethods();
      soft.assertThat(info).hasConstructorCountGreaterThanOrEqualTo(1);
      soft.assertThat(info).hasMethodCountGreaterThanOrEqualTo(1);
   }

   @DisplayName("1.1c Attributes, constructor and toString()")
   @Test
   @Grade(value = 1, feedback = "Constructor parameters should be stored in attributes and used in toString()")
   public void constructionBasics() {
      int difficultyLevel = 2;
      String description = "A description";
      Report report = new Report(description, difficultyLevel);
      soft.assertThat(report).isNotNull();
      soft.assertThat(report).extracting("description").isEqualTo(description);
      soft.assertThat(report).extracting("difficultyLevel").isEqualTo(difficultyLevel);
      soft.assertThat(report.toString()).contains(description, Integer.toString(difficultyLevel), "4");
   }

   @DisplayName("1.1d Difficulty level: 1 to 4")
   @Test
   @Grade(value = 1, feedback = "difficultyLevel in 1..4 should be stored without modification")
   public void getDifficultyLevelForNormalValues() {
      soft.assertThat(new Report("Description", 1).getDifficultyLevel()).isEqualTo(1);
      soft.assertThat(new Report("Description", 3).getDifficultyLevel()).isEqualTo(3);
      soft.assertThat(new Report("Description", 2).getDifficultyLevel()).isEqualTo(2);
      soft.assertThat(new Report("Description", 4).getDifficultyLevel()).isEqualTo(4);
   }

   @DisplayName("1.1e Difficulty level: <= 0")
   @Test
   @Grade(value = 0.5, feedback = "difficultyLevel <= 0 should be stored as 1")
   public void getDifficultyLevelForLowValues() {
      soft.assertThat(new Report("Description", 0).getDifficultyLevel()).isEqualTo(1);
      soft.assertThat(new Report("Description", -33).getDifficultyLevel()).isEqualTo(1);
   }

   @DisplayName("1.1f Difficulty level: >= 5")
   @Test
   @Grade(value = 0.5, feedback = "difficultyLevel >= 5 should be stored as 4")
   public void getDifficultyLevelForHighValues() {
      soft.assertThat(new Report("Description", 5).getDifficultyLevel()).isEqualTo(4);
      soft.assertThat(new Report("Description", 18).getDifficultyLevel()).isEqualTo(4);
   }
}
