package calc;

import java.util.Stack;

/**
 * This class implements the calculator for the purpose of evaluating the calculation if it is
 * written in reverse polish.
 */
public class RevPolishCalc implements Calculator {

  /**
   * The method that calculates the answer to the evaluate method.
   * @param expr The string expression inputted by the user.
   * @return The answer to the expression.
   */
  @Override
  public float evaluate(String expr) {
    TreeNode root = makeTree(expr);
    if (root.getClass() == NumberNode.class) {
      NumberNode rootNum = (NumberNode) root;
      return rootNum.getValue();
    } else {
      OperatorNode rootOp = (OperatorNode) root;
      NumberNode left = (NumberNode) rootOp.getLeft();
      NumberNode right = (NumberNode) rootOp.getRight();

      return rootOp.getValue().calculate(left.getValue(), right.getValue());
    }
  }

  private TreeNode makeTree(String expr) {
    TreeNode root;
    Stack<TreeNode> stack = new Stack<>();
    for (int i = 0; i < expr.length(); i++) {
      if (Character.isDigit(expr.charAt(i))) {
        stack.push(new NumberNode(Float.parseFloat(String.valueOf(expr.charAt(i)))));
      } else {
        stack.push(new OperatorNode(Plus.getInstance(), stack.pop(), stack.pop()));
      }
    }

    root = stack.pop();
    return root;
  }

}
