package calc;

import java.util.Stack;
import java.util.regex.Pattern;

/**
 * This class implements the calculator for the purpose of evaluating the calculation if it is
 * written in reverse polish.
 */
public class RevPolishCalc implements Calculator {

  /**
   * The method that calculates the answer to the evaluate method.
   *
   * @param expr The string expression inputted by the user.
   * @return The answer to the expression.
   */
  @Override
  public float evaluate(String expr) throws InvalidExpressionException {

    if (Pattern.matches("[a-zA-z]+", expr)) {
      throw new InvalidExpressionException();
    }
    TreeNode root = makeTree(expr);

    root.accept(new CalcVisitor());

    CalcVisitor visitor = new CalcVisitor();
    visitor.visit((OperatorNode) root);
    return visitor.getAnswer();
  }

  /**
   * This method makes a tree from the users input.
   * @param expr the users input.
   * @return The root node to the tree.
   */
  private TreeNode makeTree(String expr) {
    TreeNode root;
    Stack<TreeNode> stack = new Stack<>();
    for (int i = 0; i < expr.length(); i++) {
      if (Character.isDigit(expr.charAt(i))) {
        stack.push(new NumberNode(Float.parseFloat(String.valueOf(expr.charAt(i)))));
      } else {
        stack.push(new OperatorNode(getOp(expr.charAt(i)), stack.pop(), stack.pop()));
      }
    }

    root = stack.pop();
    return root;
  }

  /**
   * This method gets the operator represented by the char.
   * @param c The inputted Symbol.
   * @return The Symbol instance.
   */
  private Operator getOp(char c) {
    switch (c) {
      case '+':
        return Plus.getInstance();
      case '-':
        return Subtract.getInstance();
      case '*':
        return Multiply.getInstance();
      case '/':
        return Divide.getInstance();
      default:
        break;
    }
    return null;
  }

}
