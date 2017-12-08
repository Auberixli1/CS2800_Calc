package testcalc;

import static org.junit.Assert.assertEquals;

import calc.BadEntryTypeException;
import calc.Calculator;
import calc.EmptyStackException;
import calc.Operator;
import calc.RevPolishCalc;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
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
  public void evalPlus() throws EmptyStackException, BadEntryTypeException {
    assertEquals("eval=2", 2.0f, revPol.evaluate("11+"),0.0f);
  }


  // Tests complex evaluation
  @Test
  public void evalComplex() throws EmptyStackException, BadEntryTypeException {
    assertEquals("eval=63", 63.0f, revPol.evaluate("567+*2-"), 0.0f);
  }
}
