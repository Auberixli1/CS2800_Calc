package calc;

/**
 * This interface is for the operators of the calculate, so they all implement the calculate method.
 *
 * @author Marcus Messer
 */
public interface Operator {

  /**
   * This method calculates the answer between two integers dependant on the operator.
   *
   * @param x The first (left hand) number.
   * @param y The second (right hand) number.
   * @return The answer of the calculation.
   */
  float calculate(float x, float y);
}
