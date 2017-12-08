package calc;

import java.util.Stack;

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
  public float evaluate(String expr) {
    TreeNode root = makeTree(expr);

    root.accept(new CalcVisitor());

    CalcVisitor visitor = new CalcVisitor();
    visitor.visit((OperatorNode) root);
    return visitor.getAnswer();
  }

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
