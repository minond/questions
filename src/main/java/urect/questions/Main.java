package urect.questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    List<Question> questions = getQuestions();
    Scanner input = new Scanner(System.in);

    for (int i = 0, imax = questions.size(); i < imax; i++) {
      ask(questions.get(i), input, i);
    }
  }

  public static void ask(Question question, Scanner input, int index) {
    List<Answer> answers = question.getAnswers();

    System.out.printf("\n\nQuestion #%d: %s\n\n", index + 1, question.getText());

    for (int j = 0, jmax = answers.size(); j < jmax; j++) {
      Answer answer = answers.get(j);
      System.out.printf("Answer #%d: %s\n", j + 1, answer.getText());
    }

    System.out.print("Your comma separated answers: ");
    List<String> numbers = Arrays.asList(input.nextLine().split(","));
    List<Answer> selected =
        new ArrayList<Answer>() {
          {
            for (String num : numbers) {
              // NOTE Let it crash on formatting and out of bound errors
              add(answers.get(Integer.parseInt(num) - 1));
            }
          }
        };

    if (question.isCorrect(selected)) {
      System.out.println("Correct!");
    } else {
      System.out.println("That is incorrect.");
    }
  }

  public static List<Question> getQuestions() {
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
