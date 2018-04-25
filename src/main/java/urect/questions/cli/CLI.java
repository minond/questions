package urect.questions.cli;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import urect.questions.Answer;
import urect.questions.Question;

public class CLI {
  protected Scanner input;

  CLI(Scanner input) {
    this.input = input;
  }

  public void ask(Question question, int number) {
    List<Answer> answers = question.getAnswers();

    System.out.printf("\n\nQuestion #%d: %s\n\n", number, question.getText());

    for (int j = 0, max = answers.size(); j < max; j++) {
      Answer answer = answers.get(j);
      System.out.printf("Answer #%d: %s\n", j + 1, answer.getText());
    }

    System.out.print("Your comma separated answers: ");
    List<String> numbers = Arrays.asList(input.nextLine().split(","));
    List<Answer> selected =
        new ArrayList<Answer>() {
          {
            for (String num : numbers) {
              try {
                add(answers.get(Integer.parseInt(num.trim()) - 1));
              } catch (NumberFormatException err) {
                System.out.printf("Error converting '%s' into a valid response.\n", num);
              } catch (ArrayIndexOutOfBoundsException err) {
                System.out.printf("Answer #%s does not exists.\n", num);
              }
            }
          }
        };

    if (selected.size() > 0) {
      System.out.println("Your answers were:");
      for (Answer answer : selected) {
        System.out.printf(" - %s\n", answer.getText());
      }
    } else {
      System.out.println("You selected no answers.");
    }

    if (question.isCorrect(selected)) {
      System.out.println("\nCorrect!");
    } else {
      System.out.println("\nIncorrect.");
    }
  }
}
