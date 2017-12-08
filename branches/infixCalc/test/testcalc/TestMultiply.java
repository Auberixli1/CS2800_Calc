package testcalc;

import static org.junit.Assert.assertEquals;

import calc.Multiply;
import calc.Operator;
import org.junit.Before;
import org.junit.Test;

public class TestMultiply {
  private Operator mul;

  @Before
  public void setUp() {
    mul = Multiply.getInstance();
  }

  //Test 32 - Tests if calculate correctly multiplies two numbers
  @Test
  public void mulInts() {
    assertEquals("2*2=4", 4, mul.calculate(2,2), 0.0f);
  }

  //Test 38 - Tests with floats
  @Test
  public void mulFloats() {
    assertEquals("0.5 * 0.5 = 0.25", 0.25f, mul.calculate(0.5f, 0.5f), 0.0f);
  }

}
