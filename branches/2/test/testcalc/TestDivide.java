package testcalc;

import static org.junit.Assert.assertEquals;

import calc.Divide;
import calc.Operator;
import org.junit.Before;
import org.junit.Test;

public class TestDivide {

  private Operator div;

  @Before
  public void setUp() {
    div = Divide.getInstance();
  }

  //Test 33 - Tests if calculate correctly divides two numbers.
  @Test
  public void divInts() {
    assertEquals("4/2=2", 2, div.calculate(4, 2), 0.0f);
  }

  //Test 34 - Tests improper fraction
  @Test
  public void divIntsImproperFraction() {
    assertEquals("2/4", 0.5, div.calculate(2, 4), 0.0f);
  }

  //Test 39 - Tests calculate with floats
  @Test
  public void divFloats() {
    assertEquals("0.5 / 0.5 = 1", 1.0f, div.calculate(0.5f, 0.5f), 0.0f);
  }
}
