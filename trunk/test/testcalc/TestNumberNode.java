package testcalc;

import static org.junit.Assert.assertEquals;

import calc.NumberNode;
import org.junit.Test;

public class TestNumberNode {

  //Test 40 - Tests setter and getter for value
  @Test
  public void valueGetter() {
    NumberNode numberNode = new NumberNode(1);
    assertEquals("set=get", 1.0f, numberNode.getValue(), 0.0f);
  }

}
