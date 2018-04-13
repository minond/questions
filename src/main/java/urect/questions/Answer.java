package urect.questions;

import java.util.UUID;

public class Answer {
  private UUID uuid;
  protected String text;
  protected boolean correct;

  public Answer(String text, boolean correct) {
    this.uuid = UUID.randomUUID();
    this.text = text;
    this.correct = correct;
  }

  public UUID getUUID() {
    return uuid;
  }

  public String getText() {
    return text;
  }

  public boolean isCorrect() {
    return correct;
  }
}
