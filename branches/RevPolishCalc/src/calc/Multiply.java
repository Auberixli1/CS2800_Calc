package calc;

public class Multiply implements Operator {

  private static Multiply instance = new Multiply();

  public static Multiply getInstance() {
    return instance;
  }

  private Multiply() {
  }

  @Override
  public int calculate(int x, int y) {
    return x * y;
  }
}
