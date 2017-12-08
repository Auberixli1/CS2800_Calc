package calc;

/**
 * This interface is to implement a tree for the expression.
 *
 * @author Marcus Messer
 */
public interface TreeNode {

  /**
   * This method will be used to implement the accept from the visitor pattern.
   *
   * @param visitor The visitor that will be visiting the node.
   */
  void accept(Visitor visitor);
}
