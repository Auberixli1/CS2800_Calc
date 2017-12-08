package views;

import java.util.function.Consumer;

/**
 *  This interface is so the view can communicate with the controller.
 *
 *  @author Marcus Messer
 */

public interface View {

  /**
   * This method gets the expression from what the user has entered.
   * @return returns a string of the entered expression
   */
  String getExpression();

  /**
   * Sets the answer of the calculation for the view.
   * @param ans the answer to the expression.
   */
  void setAnswer(String ans);

  /**
   * Adds an observer to the calculator to check which one is running.
   * @param runnable The instance of the calculator.
   */
  void addCalcObserver(Runnable runnable);

  /**
   * This method adds an observer to the views to check the type of expression, either Reverse
   * Polish or In Fix.
   * @param consumer A getter for the type of value.
   */
  void addTypeObserver(Consumer<OperationType> consumer);
}
