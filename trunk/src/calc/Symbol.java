package calc;

/**
 * This is the list of possible symbols.
 *
 * @author Marcus Messer
 */
public enum Symbol {
  /**
   * The enumeration for '('.
   */
  LEFT_BRACKET(0, '('),

  /**
   * The enumeration for ')'.
   */
  RIGHT_BRACKET(0, ')'),
  /**
   * The enumeration for '*'.
   */
  TIMES(2, '*'),
  /**
   * The enumeration for '/'.
   */
  DIVIDE(2, '/'),
  /**
   * The enumeration for '+'.
   */
  PLUS(1, '+'),
  /**
   * The enumeration for '-'.
   */
  MINUS(1, '-'),
  /**
   * The enumeration for and INVALID symbol.
   */
  INVALID(-1, '!');

  /**
   * This field is for the precedence of the symbol. -1 for invalid, 0 for the brackets as they are
   * handled different. 2 for both multiple and divide and 1 for add and subtract
   */
  private final int precedence;

  /**
   * The symbol as a char that can be passed into a string.
   */
  private char symbol;

  /**
   * This constructor associates precedence and the char symbol to the enum item.
   * @param precedence The precedence of the symbol.
   * @param symbol The symbol represented as a char.
   */
  Symbol(int precedence, char symbol) {
    this.precedence = precedence;
    this.symbol = symbol;
  }

  /**
   * Gets the precedence of the symbol.
   * @return The precedence as an integer.
   */
  public int getPrecedence() {
    return precedence;
  }

  /**
   * Gets the symbol as a char.
   * @return A char of the symbol it is associated to.
   */
  public char getSymbol() {
    return symbol;
  }
}
