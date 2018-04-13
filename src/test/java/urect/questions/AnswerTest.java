package urect.questions;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class AnswerTest {
  @Test
  public void testAnswerWithNoTextIsInvalid() {
    Answer a = new Answer("", false);
    assertFalse(a.isValid());
  }

  @Test
  public void testAnswerWithTextIsValid() {
    Answer a = new Answer("a", false);
    assertTrue(a.isValid());
  }
}
