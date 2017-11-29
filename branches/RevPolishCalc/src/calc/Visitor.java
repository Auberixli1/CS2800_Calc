package calc;

public interface Visitor {
  void visit(NumberNode num);

  void visit(OperatorNode op);
}
