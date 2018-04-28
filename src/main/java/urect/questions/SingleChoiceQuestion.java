package urect.questions;

import java.util.List;

public class SingleChoiceQuestion extends Question {
  public SingleChoiceQuestion(String text, String explination, List<Answer> answers) {
    super(text, explination, answers);
  }

  public boolean isCorrect(List<Answer> selected) {
    List<Answer> correct = getCorrectAnswers();
    return selected.size() == 1
        && correct.size() == 1
        && selected.get(0).getUUID().equals(correct.get(0).getUUID());
  }

  public boolean isValid() {
    List<Answer> correct = getCorrectAnswers();
    return super.isValid() && answers.size() > 1 && correct.size() == 1;
  }
}
