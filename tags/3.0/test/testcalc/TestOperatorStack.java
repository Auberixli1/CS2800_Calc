package testcalc;

import static org.junit.Assert.assertEquals;

import calc.BadEntryTypeException;
import calc.EmptyStackException;
import calc.OperatorStack;
import calc.Symbol;
import org.junit.Before;
import org.junit.Test;

public class TestOperatorStack {

  private OperatorStack operatorStack;

  @Before
  public void setUp() {
    operatorStack = new OperatorStack();
  }

  // Tests pushing onto the stack and if it empty
  @Test
  public void push() {
    operatorStack.push(Symbol.DIVIDE);
    assertEquals("not empty", false, operatorStack.isEmpty());
  }

  // Tests popping the stack.
  @Test
  public void pop() throws BadEntryTypeException, EmptyStackException {
    operatorStack.push(Symbol.MINUS);
    assertEquals("symbol=-", Symbol.MINUS, operatorStack.pop());
  }

}
