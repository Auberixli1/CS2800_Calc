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
   * This constructor makes a new node that sets the payload and, the left and right nodes.
   * @param value The current payload of the node.
   */
  public NumberNode(float value) {
    this.value = value;
  }

  public float getValue() {
    return value;
  }

  @Override
  public void accept(Visitor visitor) {
    visitor.visit(this);
  }
}
