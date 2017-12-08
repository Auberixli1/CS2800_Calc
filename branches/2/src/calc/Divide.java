package calc;

/**
 * This class implements the operator interface, so the calculate function can return the answer of
 * x / y.
 *
 * @author Marcus Messer
 */
public class Divide implements Operator {

  /**
   * This field is the current instance of the class.
   */
  private static Divide instance = new Divide();

  /**
   * The method is an empty constructor, that can only be called from within this class.
   */
  private Divide() {
  }

  /**
   * This method gets the current instance of the class.
   *
   * @return The current instance.
   */
  public static Divide getInstance() {
    return instance;
  }

  /**
   * This method calculates x /y.
   *
   * @param x The first (left hand) number.
   * @param y The second (right hand) number.
   * @return The answer of x / y.
   */
  @Override
  public float calculate(float x, float y) {
    return x / y;
  }
}
