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

  @Before
  public void setUp() {
    asciiView = AsciiView.getInstance();
  }
}
