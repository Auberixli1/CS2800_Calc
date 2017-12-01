package calc;

/**
 * This class implements the TreeNode so numbers can be stored.
 *
 * @author Marcus Messer
 */
public class NumberNode implements TreeNode {

  /**
   * This field stores the current payload of this node.
   */
  private float value;
  /**
   * This field stores the node to the left of this node.
   */
  private TreeNode left;
  /**
   * This field stores the node to the right of this node.
   */
  private TreeNode right;

  /**
   * This constructor makes a new node that sets the payload and, the left and right nodes.
   * @param value The current payload of the node.
   * @param left The node to the left of this node.
   * @param right The node to the right of this node.
   */
  public NumberNode(float value, TreeNode left, TreeNode right) {
    this.value = value;
    this.left = left;
    this.right = right;
  }

  public float getValue() {
    return value;
  }

  @Override
  public void accept(Visitor visitor) {
    visitor.visit(this);
  }
}
