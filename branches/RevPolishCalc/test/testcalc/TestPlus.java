package testcalc;

import static org.junit.Assert.assertEquals;

import calc.Operator;
import calc.Plus;
import org.junit.Before;
import org.junit.Test;

public class TestPlus {
  private Operator plus;

  @Before
  public void setUp() {
    plus = Plus.getInstance();
  }

  // Test 29 - Tests if the add class adds two numbers together
  @Test
  public void addNumbers() {
    assertEquals("2+2=4",4, plus.calculate(2, 2));
  }
}
