package tests.testviews.testascii;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import views.ascii.AsciiView;

public class TestAsciiView {
  private AsciiView asciiView;
  private ByteArrayOutputStream outContent = new ByteArrayOutputStream();
  private ByteArrayInputStream input;

  @Before
  public void setUp() {
    asciiView = AsciiView.getInstance();

    System.setOut(new PrintStream(outContent));
  }

  // Tests if the menu prints correctly
  @Test
  public void printMenu() {
    asciiView.printMenu();
    assertEquals("menu", "Please select a type:\n1: Infix\n2: Reverse Polish\n",
        outContent.toString());
  }

  // Tests getting the user input
  @Test
  public void getInput() {
    input = new ByteArrayInputStream("1".getBytes());
    System.setIn(input);

    assertEquals("input", "1", asciiView.getInput());
  }

  @After
  public void cleanUp() {
    System.setOut(null);
    System.setIn(null);
  }

}
