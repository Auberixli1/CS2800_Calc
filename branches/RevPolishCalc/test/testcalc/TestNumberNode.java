package testcalc;

import static org.junit.Assert.assertEquals;

import calc.CalcVisitor;
import calc.NumberNode;
import calc.OperatorNode;
import calc.Plus;
import calc.Subtract;
import calc.TreeNode;
import calc.Visitor;
import org.junit.Test;

public class TestNumberNode {
  //Test 40 - Tests setter and getter for value
  @Test
  public void valueGetter() {
    NumberNode numberNode = new NumberNode(1, null, null);
    assertEquals("set=get", 1.0f, numberNode.getValue(), 0.0f);
  }

  // Test 52 - Tests the accept method
  @Test
  public void acceptVisitor() {
    TreeNode node = new NumberNode(0, null, null);
    CalcVisitor visit = new CalcVisitor();
    node.accept(visit);
    assertEquals("acceptVisitor=node", node, visit.getCurNode());
  }
}
