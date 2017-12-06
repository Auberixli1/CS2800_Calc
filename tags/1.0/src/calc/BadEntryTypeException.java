package calc;

/**
 * This is the exception that is thrown when the user entered a invalid type.
 *
 * @author Marcus Messer
 */

public class BadEntryTypeException extends Exception {
  /**
   * Version ID of this exception, for use in the JVM when serialised.
   */
  private static final long serialVersionUID = 1L;

  /**
   * The constructor for this exception, which throws a custom message to the user.
   *
   * @param expected the expected type for the method that throws the exception.
   * @param actual   the actual type of the Entry.
   */
  public BadEntryTypeException(EntryType expected, EntryType actual) {
    super("BadEntryTypeException: expected: " + expected + ", actual: " + actual);
  }
}
