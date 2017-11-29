package calc;

public class Subtract implements Operator {

  private static Subtract ourInstance = new Subtract();

  public static Subtract getInstance() {
    return ourInstance;
  }

  private Subtract() {
  }

  @Override
  public int calculate(int x, int y) {
    return x - y;
  }
}
