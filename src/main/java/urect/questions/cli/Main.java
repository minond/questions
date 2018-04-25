package urect.questions.cli;

import java.util.Scanner;
import urect.questions.Loader;

public class Main {
  public static void main(String[] args) {
    Loader loader = new Loader();
    CLI cli = new CLI(new Scanner(System.in));

    System.out.print("UtahRECT Q&A Project");

    for (Loader.NumberedQuestion question : loader.getNumberedQuestions()) {
      cli.ask(question.getQuestion(), question.getNumber());
    }
  }
}
