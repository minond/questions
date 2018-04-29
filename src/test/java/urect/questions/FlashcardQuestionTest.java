package urect.questions;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class FlashcardQuestionTest {
  @Test
  public void testFlashcardQuestionsAreInvalidWithNoText() {
    Question q = new FlashcardQuestion("", "hi");
    assertFalse(q.isValid());
  }

  @Test
  public void testFlashcardQuestionsAreInvalidWithNoExplination() {
    Question q = new FlashcardQuestion("hi", "");
    assertFalse(q.isValid());
  }

  @Test
  public void testFlashcardQuestionsAreValidWithTextAndExplination() {
    Question q = new FlashcardQuestion("hi", "bye");
    assertTrue(q.isValid());
  }

  @Test
  public void testFlashcardQuestionsAreNotAnswerable() {
    Question q = new FlashcardQuestion("hi", "bye");
    assertFalse(q.isAnswerable());
  }
}
