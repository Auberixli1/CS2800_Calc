package calc;

import java.util.regex.Pattern;

/**
 * This class implements the calculator interface. It converts an expression in infix to post fix,
 * then evaluated by the postfix calculator.
 *
 * @author Marcus Messer
 */
public class InFixCalc implements Calculator {

  /**
   * This field is for storing the operators for use within shunting yard.
   */
  private OperatorStack operatorStack;

  /**
   * This field is the post fix calculator.
   */
  private RevPolishCalc postFixCalc;

  /**
   * This field builds the post fix expression.
   */
  private StringBuilder postfix;

  /**
   * This constructor instantiates the operator stack and postfix calculator.
   */
  public InFixCalc() {
    operatorStack = new OperatorStack();
    postFixCalc = new RevPolishCalc();
  }

  /**
   * This method converts the expression from the user to post fix and passes it to the postfix
   * calculator.
   *
   * @param expr The string expression inputted by the user.
   * @return The answer to the expression.
   */
  @Override
  public float evaluate(String expr) throws InvalidExpressionException {
    if (Pattern.matches("[a-zA-z]+", expr)) {
      throw new InvalidExpressionException();
    }

    postfix = new StringBuilder();

    for (char c : expr.toCharArray()) {
      if (Character.isDigit(c)) {
        postfix.append(c);
      } else {

        switch (c) {
          case '(':
            operatorStack.push(Symbol.LEFT_BRACKET);
            break;
          case ')':
            Symbol temp = null;
            try {
              temp = operatorStack.peek();
              while (temp != Symbol.LEFT_BRACKET) {
                postfix.append(operatorStack.pop().getSymbol());
                temp = operatorStack.peek();
              }
              operatorStack.pop();
            } catch (EmptyStackException | BadEntryTypeException e) {
              e.printStackTrace();
            }
            break;
          case '/':
            shuntingYard(Symbol.DIVIDE);
            break;
          case '*':
            shuntingYard(Symbol.TIMES);
            break;
          case '+':
            shuntingYard(Symbol.PLUS);
            break;
          case '-':
            shuntingYard(Symbol.MINUS);
            break;
          default:
            operatorStack.push(Symbol.INVALID);
            break;
        }
      }
    }

    while (!operatorStack.isEmpty()) {
      try {
        postfix.append(operatorStack.pop().getSymbol());
      } catch (EmptyStackException | BadEntryTypeException e) {
        e.printStackTrace();
      }
    }

    return postFixCalc.evaluate(postfix.toString());
  }

  /**
   * This method does the symbol comparison of the shunting yard algorithm.
   *
   * @param symbol The current symbol token.
   */
  private void shuntingYard(Symbol symbol) {
    if (operatorStack.isEmpty()) {
      operatorStack.push(symbol);
      return;
    }
    try {
      if (operatorStack.peek().getPrecedence() > symbol.getPrecedence()) {
        postfix.append(operatorStack.pop().getSymbol());
      }
    } catch (EmptyStackException | BadEntryTypeException e) {
      e.printStackTrace();
    }
    operatorStack.push(symbol);
  }
}
