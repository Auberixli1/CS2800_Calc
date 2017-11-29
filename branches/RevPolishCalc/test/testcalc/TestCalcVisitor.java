package testcalc;

import calc.CalcVisitor;
import calc.NumberNode;
import calc.OperatorNode;
import calc.Plus;
import calc.TreeNode;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestCalcVisitor {
  //Test 50 - Tests the visit for Number Nodes
  @Test
  public void visitNumNode() {
    CalcVisitor visitor = new CalcVisitor();
    TreeNode node = new NumberNode(2, null, null);
    visitor.visit((NumberNode) node);
    assertEquals("visitedNode=NumberNode", 2.0f, visitor.getCurNode().getValue());
  }

  //Test 51 - Tests the visit for the Operator Node
  @Test
  public void visitOpNode() {
    CalcVisitor visitor = new CalcVisitor();
    TreeNode node = new OperatorNode(Plus.getInstance(), null, null);
    visitor.visit((OperatorNode) node);
    assertEquals("visitedNode=OpNode", Plus.getInstance(), visitor.getCurNode().getValue());
  }
}
