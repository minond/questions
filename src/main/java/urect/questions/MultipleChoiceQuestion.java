package urect.questions;

import java.util.ArrayList;
import java.util.List;

public class MultipleChoiceQuestion extends Question {
  public MultipleChoiceQuestion(String text, List<Answer> answers) {
    super(text, answers);
  }

  public boolean isCorrect(List<Answer> selected) {
    List<Answer> correct = getCorrectAnswers();
    List<String> correctIds = new ArrayList<String>();

    for (Answer ans : correct) {
      correctIds.add(ans.getUUID().toString());
    }

    for (Answer ans : selected) {
      if (!correctIds.contains(ans.getUUID().toString())) {
        return false;
      }
    }

    return selected.size() == correct.size();
  }

  public boolean isValid() {
    return answers.size() > 1 && !text.equals("");
  }
}
