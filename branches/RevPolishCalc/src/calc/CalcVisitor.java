package calc;

/**
 * This class implements the visitor, so it can span a tree to evaluate an expression.
 *
 * @author Marcus Messer
 */
public class CalcVisitor implements Visitor {

  /**
   * This field is the current node that the visitor is visiting.
   */
  private TreeNode curNode;

  /**
   * This is the visit for when the visitor visits a Number Node.
   * @param num The currently visited node.
   */
  @Override
  public void visit(NumberNode num) {
    curNode = num;
  }

  /**
   * This is the visit method for when the visitor visits an operator node.
   * @param op The currently visited node.
   */
  @Override
  public void visit(OperatorNode op) {
    curNode = op;
  }

  /**
   * This method gets the current node.
   * @return The current node.
   */
  public TreeNode getCurNode() {
    return curNode;
  }
}
