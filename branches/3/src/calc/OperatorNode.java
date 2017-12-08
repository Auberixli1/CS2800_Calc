package calc;

/**
 * This class will implement to the TreeNode for operators.
 *
 * @author Marcus Messer
 */
public class OperatorNode implements TreeNode {

  /**
   * This field will be the payload of this node.
   */
  private Operator value;
  /**
   * This field will be the node to the left of this node.
   */
  private TreeNode left;
  /**
   * This field will be the node to the right of this node.
   */
  private TreeNode right;

  /**
   * This constructor makes a new node that, sets the payload, the left and right nodes.
   *
   * @param value The value of what the payload should be in the node.
   * @param left The node to the left of this node.
   * @param right The node to the right of this node.
   */
  public OperatorNode(Operator value, TreeNode left, TreeNode right) {
    this.value = value;
    this.left = left;
    this.right = right;
  }

  /**
   * This method sets the visitor to visit this class.
   *
   * @param visitor The visitor that will be visiting the node.
   */
  @Override
  public void accept(Visitor visitor) {
    visitor.visit(this);
  }

  public Operator getValue() {
    return value;
  }

  public TreeNode getLeft() {
    return left;
  }


  public TreeNode getRight() {
    return right;
  }
}
