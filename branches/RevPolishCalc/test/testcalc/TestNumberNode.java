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
    assertEquals("set=get", 1.0f, numberNode.getValue());
  }

  //Test 41 - Tests getting the left node with a number node
  @Test
  public void leftGetterNum() {
    TreeNode node = new NumberNode(1, new NumberNode(2, null, null), null);
    assertEquals("leftNodeValue=2", 2.0f, node.getLeft().getValue());
  }

  //Test 42 - Tests getting the right node with a number node
  @Test
  public void rightGetterNum() {
    TreeNode node = new NumberNode(1, null, new NumberNode(3, null, null));
    assertEquals("rightNodeValue=3", 3.0f, node.getRight().getValue());
  }

  // Test 48 - Tests getting left node using operator node
  @Test
  public void leftGetterOp() {
    TreeNode node = new NumberNode(0, new OperatorNode(Plus.getInstance(), null, null), null);
    assertEquals("leftNode=Plus", Plus.getInstance(), node.getLeft().getValue());
  }

  // Test 49 - Tests getting the right node using the operator node
  @Test
  public void rightGetterOp() {
    TreeNode node = new NumberNode(0, null, new OperatorNode(Subtract.getInstance(), null, null));
    assertEquals("rightNode=Sub", Subtract.getInstance(), node.getRight().getValue());
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
