package urect.questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Loader {
  public class NumberedQuestion {
    private int number;
    private Question question;

    NumberedQuestion(int number, Question question) {
      this.number = number;
      this.question = question;
    }

    public int getNumber() {
      return number;
    }

    public Question getQuestion() {
      return question;
    }
  }

  public List<NumberedQuestion> getNumberedQuestions() {
    List<Question> questions = getQuestions();
    return new ArrayList<NumberedQuestion>() {
      {
        for (int i = 0, max = questions.size(); i < max; i++) {
          add(new NumberedQuestion(i + 1, questions.get(i)));
        }
      }
    };
  }

  public List<Question> getQuestions() {
    return Arrays.asList(
        new SingleChoiceQuestion(
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
            Arrays.asList(
                new Answer("Ut enim ad minima veniam", false),
                new Answer("Nostrum exercitationem ullam", false),
                new Answer("Perspiciatis unde omnis", true),
                new Answer("Reprehenderit qui in", false))),
        new SingleChoiceQuestion(
            "Ut enim ad minim veniam, quis nostrud exercitation.",
            Arrays.asList(
                new Answer("Magni dolores eos qui", false),
                new Answer("Neque porro quisquam", true),
                new Answer("Excepteur sint occaecat", false),
                new Answer("Duis aute irure dolor in reprehenderit", false))),
        new SingleChoiceQuestion(
            "Duis aute irure dolor in reprehenderit in voluptate.",
            Arrays.asList(
                new Answer("Aliquam quaerat voluptatem", false),
                new Answer("Magni dolores eos", false),
                new Answer("Aut odit aut fugit", false),
                new Answer("Incidunt ut labore", true))));
  }
}
