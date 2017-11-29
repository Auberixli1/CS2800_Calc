package testcalc;

import static org.junit.Assert.assertEquals;

import calc.Calculator;
import calc.RevPolishCalc;
import org.junit.Before;
import org.junit.Test;

public class TestRevPolishCalc {
  private Calculator revPol;

  @Before
  public void setUp() {
    revPol = new RevPolishCalc();
  }

  //Test 54 - Tests if evaluate returns 0.
  @Test
  public void evaluateReturn() {
    assertEquals("evaluate=1", 0.0f,  revPol.evaluate("1"), 0.0f);
  }

}
