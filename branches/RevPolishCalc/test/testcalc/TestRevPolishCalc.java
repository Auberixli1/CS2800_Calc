package testcalc;

import static org.junit.Assert.assertEquals;

import calc.BadEntryTypeException;
import calc.Calculator;
import calc.EmptyStackException;
import calc.Plus;
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
  public void evaluateReturn() throws BadEntryTypeException, EmptyStackException {
    assertEquals("evaluate=0", 0.0f,  revPol.evaluate("0"), 0.0f);
  }

  // Test 54 Tests if evaluate returns 1 when 01 is entered
}
