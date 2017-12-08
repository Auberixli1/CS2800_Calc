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
  public void addInts() {
    assertEquals("2+2=4", 4, plus.calculate(2, 2), 0.0f);
  }

  //Test 35 - Tests with floats
  @Test
  public void addFloats() {
    assertEquals("0.5 + 0.75 = 1.25", 1.25f, plus.calculate(0.5f, 0.75f), 0.0f);
  }
}
