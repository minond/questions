package urect.questions;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;

public class SingleChoiceQuestionTest {
  @Test
  public void testSingleChoiceQuestionWithNoTextIsInvalid() {
    Question q = new SingleChoiceQuestion("", "", new ArrayList<Answer>());
    assertFalse(q.isValid());
  }

  @Test
  public void testSingleChoiceQuestionWithNoAnswersIsInvalid() {
    Question q = new SingleChoiceQuestion("q1", "", new ArrayList<Answer>());
    assertFalse(q.isValid());
  }

  @Test
  public void testSingleChoiceQuestionWithNoCorrectAnswersIsInvalid() {
    List<Answer> answers =
        Arrays.asList(
            new Answer("1", false),
            new Answer("2", false),
            new Answer("3", false),
            new Answer("4", false));

    Question q = new SingleChoiceQuestion("q1", "", answers);
    assertFalse(q.isValid());
  }

  @Test
  public void testSingleChoiceQuestionWithMultipleCorrectAnswersIsInvalid() {
    List<Answer> answers =
        Arrays.asList(
            new Answer("1", false),
            new Answer("2", true),
            new Answer("3", false),
            new Answer("4", true));

    Question q = new SingleChoiceQuestion("q1", "", answers);
    assertFalse(q.isValid());
  }

  @Test
  public void testSingleChoiceQuestionWithTextAndOneCorrectAnswerIsValid() {
    List<Answer> answers =
        Arrays.asList(
            new Answer("1", false),
            new Answer("2", true),
            new Answer("3", false),
            new Answer("4", false));

    Question q = new SingleChoiceQuestion("q1", "", answers);
    assertTrue(q.isValid());
  }
}
