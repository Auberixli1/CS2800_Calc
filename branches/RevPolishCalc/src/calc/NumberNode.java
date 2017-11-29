package calc;

public class NumberNode implements TreeNode {
  private float value;
  private TreeNode left;
  private TreeNode right;

  public NumberNode(float value, TreeNode left, TreeNode right) {
    this.value = value;
    this.left = left;
    this.right = right;
  }

  @Override
  public Object getValue() {
    return value;
  }

  @Override
  public void accept(Visitor visitor) {

  }

  @Override
  public TreeNode getLeft() {
    return left;
  }

  @Override
  public TreeNode getRight() {
    return right;
  }
}
