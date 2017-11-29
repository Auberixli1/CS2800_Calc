package calc;

/**
 * This interface is to implement a tree for the expression.
 *
 * @author Marcus Messer
 */
public interface TreeNode {

  /**
   * This method will be used to implement the accept from the visitor pattern.
   * @param visitor The visitor that will be visiting the node.
   */
  void accept(Visitor visitor);

  // Not sure if I need this method in the interface, pretty sure I do, just don't like Object.
  /**
   * This method will be implemented to returns the current payload of the tree.
   * @return Either a number or an operator instance.
   */
  Object getValue();

  /**
   * This method will be implemented to return the node to the left of this node.
   * @return The TreeNode to the left of this node.
   */
  TreeNode getLeft();

  /**
   * This method will be implemented to return the node to the right of this node.
   * @return The TreeNode to the right of this node.
   */
  TreeNode getRight();
}
