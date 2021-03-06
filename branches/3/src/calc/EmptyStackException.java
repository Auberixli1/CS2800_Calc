package calc;

/**
 * This is the exception that is thrown when the stack contains 0 elements.
 *
 * @author Marcus Messer
 */

public class EmptyStackException extends Exception {

  /**
   * Version ID of this exception, for use in the JVM when serialised.
   */
  private static final long serialVersionUID = 1L;

  /**
   * This constructor sends a message to the <code>Exception</code> class to throw the exception.
   */
  public EmptyStackException() {
    super("EmptyStackException: No elements inside the stack");
  }

}
