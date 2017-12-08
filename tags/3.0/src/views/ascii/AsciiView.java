package views.ascii;

import java.util.Scanner;
import java.util.function.Consumer;
import views.OperationType;
import views.View;

/**
 * This class implements the view interface to communicate to the controller.
 *
 * @author Marcus Messer
 */
public class AsciiView implements View, Runnable {


  /**
   * This field is the expression that user enters to calculate.
   */
  private String expression;
  /**
   * This field is the answer that is returned from the calculator.
   */
  private String answer;

  /**
   * This field stores the operation type.
   */
  private OperationType opType;

  /**
   * This field is the instance of this singleton class.
   */
  private volatile static AsciiView instance = null;

  /**
   * This empty constructor is so this class cannot be instantiated more than once.
   */
  private AsciiView() {

  }

  /**
   * This method gets the instance of this singleton class, if the instance is null, it creates one.
   *
   * @return The instance of the class.
   */
  public static synchronized AsciiView getInstance() {
    if (instance == null) {
      instance = new AsciiView();
    }
    return instance;
  }

  /**
   * This method runs the calculator.
   */
  private void runCalc() {
    String input = "";
    while (!input.equals("q")) {
      printMenu();

      input = getInput();

      switch (input) {
        case "1":
          opType = OperationType.INFIX;
          break;
        case "2":
          opType = OperationType.POSTFIX;
          break;
        default:
          System.out.println("Please select a valid choice.");
          break;
      }

      System.out.println("Enter Expression:");
      expression = getInput();

      while (answer.equals("")) {
        System.out.println("Calculating");
      }
      System.out.println("Answer: ");
    }
  }

  /**
   * This method prints the menu for the user to select the type of expression they are going
   * to enter.
   */
  private void printMenu() {
    System.out.println("Please select a type:");
    System.out.println("1: Infix");
    System.out.println("2: Reverse Polish");
    System.out.println("q: Quit");
  }

  /**
   * This method gets the expression that the user enters.
   *
   * @return The expression to be calculated.
   */
  @Override
  public String getExpression() {
    return expression;
  }


  /**
   * This method sets the answer that is going to be printed to the user.
   *
   * @param answer The answer of the expression.
   */
  @Override
  public void setAnswer(String answer) {
    this.answer = answer;
  }

  /**
   * This method adds a runnable observer.
   *
   * @param runnable The instance of the calculator.
   */
  public void addCalcObserver(Runnable runnable) {
    runnable.run();
  }

  /**
   * This method adds a observer to the type of the expression.
   *
   * @param consumer A getter for the type of value.
   */
  public void addTypeObserver(Consumer<OperationType> consumer) {
    consumer.accept(opType);
  }

  /**
   * This method gets the users input.
   *
   * @return A string of the users input.
   */
  private String getInput() {
    Scanner in = new Scanner(System.in);
    return in.nextLine();
  }

  /**
   * This method is implemented from the Runnable interface.
   */
  @Override
  public void run() {
    runCalc();
  }
}
