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
  public void evaluateReturn() {
    assertEquals("evaluate=0", 0.0f,  revPol.evaluate("0"), 0.0f);
  }

  // Test 54 - Tests if make tree returns 1 for the root node when 01 entered.
  @Test
  public void evaluateTwoPush() {
    assertEquals("evalute=1", 1.0f, revPol.evaluate("01"), 0.0f);
  }

  // Test 55 - Tests evaluating by plus
  @Test
  public void evalPlus() {
    assertEquals("eval=2", 2.0f, revPol.evaluate("11+"),0.0f);
  }
}
