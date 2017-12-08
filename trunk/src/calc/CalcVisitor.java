package calc;

/**
 * This class implements the visitor, so it can span a tree to evaluate an expression.
 * This code was adapted from code supplied by Dave Cohen
 *
 * @author Marcus Messer
 */
public class CalcVisitor implements Visitor {

  /**
   * This field is the answer to the expression
   */
  private float answer;

  /**
   * This is the visit for when the visitor visits a Number Node.
   *
   * @param num The currently visited node.
   */
  @Override
  public void visit(NumberNode num) {
    answer = num.getValue();
  }

  /**
   * This is the visit method for when the visitor visits an operator node and calculates the
   * answer.
   *
   * @param op The currently visited node.
   */
  @Override
  public void visit(OperatorNode op) {
    op.getLeft().accept(this);
    float temp = answer;

    op.getRight().accept(this);

    answer = op.getValue().calculate(answer, temp);
  }

  public float getAnswer() {
    return answer;
  }
}
