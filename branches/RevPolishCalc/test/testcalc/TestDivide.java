package testcalc;

import static org.junit.Assert.assertEquals;

import calc.Divide;
import calc.Operator;
import org.junit.Test;

public class TestDivide {
  //Test 33 - Tests if calculate correctly divides two numbers.
  @Test
  public void divNumbers() {
    Operator div = Divide.getInstance();
    assertEquals("4/2=2", 2, div.calculate(4,2));
  }
}
