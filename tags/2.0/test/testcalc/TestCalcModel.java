package testcalc;

import static org.junit.Assert.assertEquals;

import calc.CalcModel;
import org.junit.Test;


public class TestCalcModel {

  private CalcModel calcModel = new CalcModel();

  // Tests the infix calculator
  @Test
  public void infixCalc() {
    assertEquals("1+2+3=6", 6.0f, calcModel.evaluate("1+2+3", true), 0.0f);
  }

  // Tests the postfix calculator
  @Test
  public void postFixCalc() {
    assertEquals("32+=5", 5.0f, calcModel.evaluate("32+", false), 0.0f);
  }
}
