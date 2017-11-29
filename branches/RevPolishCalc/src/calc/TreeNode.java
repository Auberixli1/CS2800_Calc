package calc;

public interface TreeNode {
  void accept(Visitor visitor);

  Object getValue();

  TreeNode getLeft();

  TreeNode getRight();
}
