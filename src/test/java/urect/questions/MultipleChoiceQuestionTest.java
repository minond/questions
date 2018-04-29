package urect.questions;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;

public class MultipleChoiceQuestionTest {
  @Test
  public void testMultipleChoiceQuestionWithNoTextIsInvalid() {
    Question q = new MultipleChoiceQuestion("", "", new ArrayList<Answer>());
    assertFalse(q.isValid());
  }

  @Test
  public void testMultipleChoiceQuestionWithNoAnswersIsInvalid() {
    Question q = new MultipleChoiceQuestion("q1", "", new ArrayList<Answer>());
    assertFalse(q.isValid());
  }

  @Test
  public void testMultipleChoiceQuestionWithTextAndNoCorrectAnswersIsValid() {
    List<Answer> answers =
        Arrays.asList(
            new Answer("1", false),
            new Answer("2", false),
            new Answer("3", false),
            new Answer("4", false));

    Question q = new MultipleChoiceQuestion("q1", "", answers);
    assertTrue(q.isValid());
  }

  @Test
  public void testMultipleChoiceQuestionWithTextAndMultipleCorrectAnswersIsValid() {
    List<Answer> answers =
        Arrays.asList(
            new Answer("1", false),
            new Answer("2", true),
            new Answer("3", false),
            new Answer("4", true));

    Question q = new MultipleChoiceQuestion("q1", "", answers);
    assertTrue(q.isValid());
  }

  @Test
  public void testMultipleChoiceQuestionWithTextAndOneCorrectAnswerIsValid() {
    List<Answer> answers =
        Arrays.asList(
            new Answer("1", false),
            new Answer("2", true),
            new Answer("3", false),
            new Answer("4", false));

    Question q = new MultipleChoiceQuestion("q1", "", answers);
    assertTrue(q.isValid());
  }

  @Test
  public void testValidMultipleChoiceQuestionAreAnswerable() {
    List<Answer> answers =
        Arrays.asList(
            new Answer("1", false),
            new Answer("2", true),
            new Answer("3", false),
            new Answer("4", false));

    Question q = new MultipleChoiceQuestion("q1", "", answers);
    assertTrue(q.isAnswerable());
  }
}
