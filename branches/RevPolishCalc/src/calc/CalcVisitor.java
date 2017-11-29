package calc;

public class CalcVisitor implements Visitor {

  private TreeNode curNode;

  @Override
  public void visit(NumberNode num) {
    curNode = num;
  }

  @Override
  public void visit(OperatorNode op) {
    curNode = op;
  }

  public TreeNode getCurNode() {
    return curNode;
  }
}
