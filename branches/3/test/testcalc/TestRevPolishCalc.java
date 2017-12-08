package testcalc;

import static org.junit.Assert.assertEquals;

import calc.Calculator;
import calc.InvalidExpressionException;
import calc.RevPolishCalc;
import org.junit.Before;
import org.junit.Test;

public class TestRevPolishCalc {

  private Calculator revPol;

  @Before
  public void setUp() {
    revPol = new RevPolishCalc();
  }

  // Tests evaluating by plus
  @Test
  public void evalPlus()
      throws InvalidExpressionException {
    assertEquals("eval=2", 2.0f, revPol.evaluate("11+"), 0.0f);
  }


  // Tests complex evaluation
  @Test
  public void evalComplex() throws InvalidExpressionException {
    assertEquals("eval=63", 63.0f, revPol.evaluate("567+*2-"), 0.0f);
  }

  // Tests inputting a invalid expression
  @Test(expected = InvalidExpressionException.class)
  public void invalidExpr() throws InvalidExpressionException {
    revPol.evaluate("asdf");
  }
}
