package urect.questions;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public abstract class Question {
  private UUID uuid;
  protected String text;
  protected String explination;
  protected List<Answer> answers;

  public Question(String text, String explination, List<Answer> answers) {
    this.uuid = UUID.randomUUID();
    this.text = text;
    this.explination = explination;
    this.answers = answers;
  }

  public abstract boolean isCorrect(List<Answer> selected);

  public UUID getUUID() {
    return uuid;
  }

  public String getText() {
    return text;
  }

  public String getExplination() {
    return explination;
  }

  public List<Answer> getAnswers() {
    return answers;
  }

  public boolean isAnswerable() {
    return answers.size() != 0;
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
