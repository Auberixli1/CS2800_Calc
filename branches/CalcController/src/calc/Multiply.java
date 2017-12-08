package calc;

/**
 * This class implements the operator interface, so that the calculate method returns the answer to
 * x * y.
 *
 * @author Marcus Messer
 */
public class Multiply implements Operator {

  /**
   * This field is the current instance of the class.
   */
  private static Multiply instance = new Multiply();

  /**
   * This method is an empty constructor, that can only be called from within this class.
   */
  private Multiply() {
  }

  /**
   * This method gets the current instance of the class.
   *
   * @return The current instance.
   */
  public static Multiply getInstance() {
    return instance;
  }

  /**
   * This method calculates x * y.
   *
   * @param x The first (left hand) number.
   * @param y The second (right hand) number.
   * @return The answer of x * y.
   */
  @Override
  public float calculate(float x, float y) {
    return x * y;
  }
}
