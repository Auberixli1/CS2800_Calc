package testcalc;

import static org.junit.Assert.assertEquals;

import calc.Operator;
import calc.Subtract;
import org.junit.Before;
import org.junit.Test;

public class TestSubtract {

  private Operator sub;

  @Before
  public void setUp() {
    sub = Subtract.getInstance();
  }

  //Test 30 - tests if subtract class subtracts two numbers
  @Test
  public void subIntsPosAns() {
    assertEquals("4-2=2", 2, sub.calculate(4, 2), 0.0f);
  }

  //Test 31 - Tests if subtract can handle returning a negative answer
  @Test
  public void subIntsNegAns() {
    assertEquals("2-4=-2", -2, sub.calculate(2, 4), 0.0f);
  }

  //Test 36 - Tests with floats for positive answer.
  @Test
  public void subFloatPosAns() {
    assertEquals("0.75 - 0.5 = 0.25", 0.25f, sub.calculate(0.75f, 0.5f), 0.0f);
  }

  //Test 37 - Tests with floats for negative answer.
  @Test
  public void setFloatNegAns() {
    assertEquals("0.5 - 0.75 = -0.25", -0.25f, sub.calculate(0.5f, 0.75f), 0.0f);
  }

}
