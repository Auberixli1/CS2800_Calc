package calc;

public class OperatorNode implements TreeNode {
  private Operator value;
  private TreeNode left;
  private TreeNode right;

  public OperatorNode(Operator value, TreeNode left, TreeNode right) {
    this.value = value;
    this.left = left;
    this.right = right;
  }

  @Override
  public void accept(Visitor visitor) {
    visitor.visit(this);
  }

  @Override
  public Object getValue() {
    return value;
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
