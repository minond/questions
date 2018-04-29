package urect.questions;

import java.util.Collections;
import java.util.List;

public class FlashcardQuestion extends Question {
  public FlashcardQuestion(String text, String explination) {
    super(text, explination, Collections.emptyList());
  }

  public boolean isCorrect(List<Answer> selected) {
    return true;
  }

  public boolean isValid() {
    return super.isValid() && !explination.equals("");
  }
}
