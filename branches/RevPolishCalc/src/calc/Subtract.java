package calc;

/**
 * This class implements the operator interface, so that the calculate method returns the
 * subtraction between two numbers.
 *
 * @author Marcus Messer
 */
public class Subtract implements Operator {

  /**
   * This field is the current instance of the class.
   */
  private static Subtract instance = new Subtract();

  /**
   * This class gets the current instance of the class.
   * @return The current instance.
   */
  public static Subtract getInstance() {
    return instance;
  }

  /**
   * This method is an empty constructor that can only be called from inside the class.
   */
  private Subtract() {
  }

  /**
   * This method calculates x - y.
   * @param x The first (left hand) number.
   * @param y The second (right hand) number.
   * @return The answer of x - y.
   */
  @Override
  public float calculate(float x, float y) {
    return x - y;
  }
}
