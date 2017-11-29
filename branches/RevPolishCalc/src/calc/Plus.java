package calc;

/**
 * This class implements the operator interface to create a addition class. As there will only be on
 * plus operator, this class implements the singleton design pattern.
 *
 * @author Marcus Messer
 */
public class Plus implements Operator {

  /**
   * This field is the current instance of the singleton.
   */
  private static Plus instance = new Plus();

  /**
   * This method gets the instance of this class.
   * @return The current instance.
   */
  public static Plus getInstance() {
    return instance;
  }

  /**
   * This method is an empty constructor that can only be called from within this class.
   */
  private Plus() {
  }

  /**
   * This method implements calculate to add two numbers together.
   *
   * @param x The first (left hand) number.
   * @param y The second (right hand) number.
   * @return The sum of x and y.
   */
  @Override
  public int calculate(int x, int y) {
    return x + y;
  }

}
