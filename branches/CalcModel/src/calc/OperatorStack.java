package calc;

/**
 * This class is a facade of the Stack class for the use of symbols.
 *
 * @author Marcus Messer
 */
public class OperatorStack {

  /**
   * This field is the stack used to hold the operators.
   */
  private Stack opStack;

  /**
   * This constructor instantiates a new stack.
   */
  public OperatorStack() {
    opStack = new Stack();
  }

  /**
   * This method pushes a symbol onto the stack.
   * @param symbol The symbol to pushed on to the stack.
   */
  public void push(Symbol symbol) {
    opStack.push(new Entry(symbol));
  }

  /**
   * This method pops the top symbol off the stack.
   * @return A symbol.
   * @throws EmptyStackException Is thrown if the stack is empty.
   * @throws BadEntryTypeException Is thrown if a bad entry type is entered.
   */
  public Symbol pop() throws EmptyStackException, BadEntryTypeException {
    Entry temp = opStack.pop();
    return temp.getSymbol();
  }

  /**
   * This method peeks at the top of the stack without popping it.
   * @return A symbol.
   * @throws EmptyStackException Is thrown if the stack is empty.
   * @throws BadEntryTypeException Is thrown of a bad entry type is entered.
   */
  public Symbol peek() throws EmptyStackException, BadEntryTypeException {
    return opStack.top().getSymbol();
  }

  /**
   * This method checks if th stack is empty.
   * @return True if the stack is empty and false if the stack has at least one item.
   */
  public Boolean isEmpty() {
    return opStack.size() == 0;
  }

}
