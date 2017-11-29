package testcalc;

import static org.junit.Assert.assertEquals;

import calc.Operator;
import calc.Subtract;
import org.junit.Test;

public class TestSubtract {
  //Test 30 - tests if subtract class subtracts two numbers
  @Test
  public void subNumbersPosAns() {
    Operator sub = Subtract.getInstance();
    assertEquals("4-2=2", 2, sub.calculate(4,2));
  }

  //Test 32 - Tests if subtract can handle returning a negative answer
  @Test
  public void subNumbersNegAns() {
    Operator sub = Subtract.getInstance();
    assertEquals("2-4=-2", -2, sub.calculate(2, 4));
  }

}
