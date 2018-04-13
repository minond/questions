package urect.questions;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public abstract class Question {
  private UUID uuid;
  protected String text;
  protected List<Answer> answers;

  public Question(String text, List<Answer> answers) {
    this.uuid = UUID.randomUUID();
    this.text = text;
    this.answers = answers;
  }

  public abstract boolean isCorrect(List<Answer> selected);

  public UUID getUUID() {
    return uuid;
  }

  public String getText() {
    return text;
  }

  public List<Answer> getAnswers() {
    return answers;
  }

  public List<Answer> getCorrectAnswers() {
    List<Answer> correct = new ArrayList<Answer>();

    for (int i = 0, len = answers.size(); i < len; i++) {
      if (answers.get(i).isCorrect()) {
        correct.add(answers.get(i));
      }
    }

    return correct;
  }

  public boolean isValid() {
    return !text.equals("");
  }
}
