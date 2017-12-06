package tests.testviews.testascii;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import views.ascii.AsciiView;

public class TestAsciiView {
  private AsciiView asciiView = AsciiView.getInstance();

  @Before
  public void setUp() {

  }

  // Tests if the view gets an expression
  @Test
  public void getEpxr() {
    assertEquals("Expr = 1+2", "1+2", asciiView.getExpression());
  }

  // Tests if the views sets and gets an answer
  @Test
  public void setGetAns() {
    asciiView.setAnswer("1");
    assertEquals("ans=1", "1", asciiView.getAnswer());
  }

}
