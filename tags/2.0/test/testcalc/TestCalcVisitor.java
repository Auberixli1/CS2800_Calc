package testcalc;

import static org.junit.Assert.assertEquals;

import calc.CalcVisitor;
import calc.NumberNode;
import calc.OperatorNode;
import calc.Plus;
import calc.TreeNode;
import org.junit.Before;
import org.junit.Test;

public class TestCalcVisitor {

  private CalcVisitor visitor;

  @Before
  public void setUp() {
    visitor = new CalcVisitor();
  }

  //Test 50 - Tests the visit for Number Nodes
  @Test
  public void visitNumNode() {
    visitor = new CalcVisitor();
    TreeNode node = new NumberNode(2);
    visitor.visit((NumberNode) node);
    assertEquals("visitedNode=NumberNode", 2.0f, visitor.getAnswer(), 0.0f);
  }

  //Test 51 - Tests the visit for the Operator Node
  @Test
  public void visitOpNode() {
    visitor = new CalcVisitor();
    TreeNode node = new OperatorNode(Plus.getInstance(), new NumberNode(0), new NumberNode(1));
    visitor.visit((OperatorNode) node);
    assertEquals("visitedNode=OpNode", 1.0f, visitor.getAnswer(), 0.0f);
  }
}
