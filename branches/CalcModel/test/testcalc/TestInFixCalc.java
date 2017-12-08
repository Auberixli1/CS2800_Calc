package testcalc;

import static org.junit.Assert.assertEquals;

import calc.BadEntryTypeException;
import calc.EmptyStackException;
import calc.InFixCalc;
import org.junit.Before;
import org.junit.Test;

public class TestInFixCalc {

  private InFixCalc inFixCalc;

  @Before
  public void setUp() {
    inFixCalc = new InFixCalc();
  }

  // Tests a simple expression
  @Test
  public void simpleExpr() throws EmptyStackException, BadEntryTypeException {
    assertEquals("1+1", 2.0f, inFixCalc.evaluate("1+1"), 0.0f);

  }

  // Test a complex expression
  @Test
  public void complexExpr() throws EmptyStackException, BadEntryTypeException {
    assertEquals("(1+2) * 5 - (4 / 2) = 13", 13.0f,
        inFixCalc.evaluate("(1+2)*5-(4/2)"), 0.0f);
  }
}
