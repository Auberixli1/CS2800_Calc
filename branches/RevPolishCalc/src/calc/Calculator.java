package calc;

/**
 * This interface is so that both the reverse polish calculator and the infix calcululator have an
 * evaluate method.
 *
 * @author Marcus Messer
 */
public interface Calculator {

  /**
   * This method evaluates the expression to be calculated.
   *
   * @param expr The string expression inputted by the user.
   * @return The answer to the expression.
   */
  float evaluate(String expr);

}
