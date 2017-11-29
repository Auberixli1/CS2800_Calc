package calc;

public class Divide implements Operator {

  private static Divide instance = new Divide();

  public static Divide getInstance() {
    return instance;
  }

  private Divide() {
  }

  @Override
  public int calculate(int x, int y) {
    return x / y;
  }
}
