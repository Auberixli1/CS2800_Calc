package testcalc;

import static org.junit.Assert.assertEquals;

import calc.Multiply;
import calc.Operator;
import org.junit.Test;

public class TestMultiply {

  //Test 32 - Tests if calculate correctly multiplies two numbers
  @Test
  public void mulNumbers() {
    Operator mul = Multiply.getInstance();
    assertEquals("2*2=4", 4, mul.calculate(2,2));
  }

}
