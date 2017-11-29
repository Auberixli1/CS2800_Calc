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
    TreeNode node = new OperatorNode(Plus.getInstance(), null, null);
    assertEquals("node=Plus", Plus.getInstance(), node.getValue());
  }

  //Test 44 - Tests the left getter using operator node
  @Test
  public void leftGetterOp() {
    TreeNode node = new OperatorNode(null, new OperatorNode(Subtract.getInstance(),
        null, null), null);
    assertEquals("leftNode=Sub", Subtract.getInstance(), node.getLeft().getValue());
  }

  //Test 45 - Tests the right getter using an operator node
  @Test
  public void rightGetterOp() {
    TreeNode node = new OperatorNode(null, null, new OperatorNode(Divide.getInstance(),
        null, null));
    assertEquals("rightNode=div", Divide.getInstance(), node.getRight().getValue());
  }

  //Test 46 - Tests the left getter using number node
  @Test
  public void leftGetterNum() {
    TreeNode node = new OperatorNode(null, new NumberNode(2, null, null), null);
    assertEquals("leftNode=2", 2.0f, node.getLeft().getValue());
  }

  //Test 47 - Tests the right getter using number node
  @Test
  public void rightGetterNum() {
    TreeNode node = new OperatorNode(null, null, new NumberNode(3, null, null));
    assertEquals("rightNode=3", 3.0f, node.getRight().getValue());
  }

  //Test 53 - Tests the accept method
  @Test
  public void accpetVisit() {
    TreeNode node = new OperatorNode(Plus.getInstance(), null, null);
    CalcVisitor visitor = new CalcVisitor();
    node.accept(visitor);
    assertEquals("node=vistiedNode", node, visitor.getCurNode());
  }
}
