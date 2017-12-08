package calc;

/**
 * This exception is thrown when the user inputs a invalid expression.
 */
public class InvalidExpressionException  extends Exception {

  /**
   * Version ID of this exception, for use in the JVM when serialised.
   */
  private static final long serialVersionUID = 1L;

  /**
   * This constructor sends a message to the <code>Exception</code> class to throw the exception.
   */
  public InvalidExpressionException() {
    super("Invalid Expression Exception: Input invalid.");
  }

}
