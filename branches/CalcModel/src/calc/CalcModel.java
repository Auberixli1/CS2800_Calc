package calc;

/**
 * This class is the model of the entire calculator. It communicates with the controller.
 *
 * @author Marcus Messer
 */
public class CalcModel {

  /**
   * This field is for the post fix calculator.
   */
  private RevPolishCalc postFixCalc;

  /**
   * This field is for the infix calculator.
   */
  private InFixCalc inFixCalc;

  /**
   * This constructor instantiates the types of calculator.
   */
  public CalcModel() {
    postFixCalc = new RevPolishCalc();
    inFixCalc = new InFixCalc();
  }

  /**
   * This method checks if the expression is infix or not and evaluates it accordingly.
   * @param expression The expression the user entered.
   * @param isInfix If the expression is infix or not.
   * @return The answer.
   */
  public float evaluate(String expression, boolean isInfix) {
    if (isInfix) {
      try {
        return inFixCalc.evaluate(expression);
      } catch (InvalidExpressionException e) {
        e.printStackTrace();
      }
    } else {
      try {
        return postFixCalc.evaluate(expression);
      } catch (InvalidExpressionException e) {
        e.printStackTrace();
      }
    }
    return -1;
  }
}
