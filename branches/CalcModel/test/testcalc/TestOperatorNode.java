package testcalc;

import static org.junit.Assert.assertEquals;

import calc.CalcVisitor;
import calc.Divide;
import calc.NumberNode;
import calc.Operator;
import calc.OperatorNode;
import calc.Plus;
import calc.Subtract;
import calc.TreeNode;
import calc.Visitor;
import org.junit.Test;

public class TestOperatorNode {

  //Test 43 - Tests the value getter
  @Test
  public void valueGetter() {
    OperatorNode node = new OperatorNode(Plus.getInstance(), null, null);
    assertEquals("node=Plus", Plus.getInstance(), node.getValue());
  }

  //Test 44 - Tests the left getter using operator node
  @Test
  public void leftGetterOp() {
    OperatorNode node = new OperatorNode(null, new OperatorNode(Subtract.getInstance(),
        null, null), null);

    OperatorNode leftNode = (OperatorNode) node.getLeft();
    assertEquals("leftNode=Sub", Subtract.getInstance(), leftNode.getValue());
  }

  //Test 45 - Tests the right getter using an operator node
  @Test
  public void rightGetterOp() {
    OperatorNode node = new OperatorNode(null, null, new OperatorNode(Divide.getInstance(),
        null, null));
    OperatorNode rightNode = (OperatorNode) node.getRight();
    assertEquals("rightNode=div", Divide.getInstance(), rightNode.getValue());
  }

  //Test 46 - Tests the left getter using number node
  @Test
  public void leftGetterNum() {
    OperatorNode node = new OperatorNode(null, new NumberNode(2), null);
    NumberNode leftNode = (NumberNode) node.getLeft();
    assertEquals("leftNode=2", 2.0f, leftNode.getValue(), 0.0f);
  }

  //Test 47 - Tests the right getter using number node
  @Test
  public void rightGetterNum() {
    OperatorNode node = new OperatorNode(null, null, new NumberNode(3));
    NumberNode rightNode = (NumberNode) node.getRight();
    assertEquals("rightNode=3", 3.0f, rightNode.getValue(), 0.0f);
  }

}
