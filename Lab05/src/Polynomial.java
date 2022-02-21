/**
 * This interface includes all methods that all child
 * Polynomial classes should support.
 */
public interface Polynomial {
  /**
   *
   * @return int: Maximum degree of the polynomial
   */
  public int getDegree();

  /**
   *
   * @param power
   * @return the coefficient for the term with that power
   */
  public double getCoefficient(int power);

  /**
   *
   * @return String: representation of the polynomial
   */
  public String getString();

  /**
   *
   * @param power
   * @return the leading coefficient
   */
  public double getLeadingCoefficient(int power);

  /**
   *
   * @param number
   * @return the polynomial at that number
   */
  public double evaluateAt(double number);

  /**
   * The polynomial evaluated at 0
   * @return
   */
  public double getYIntercept();

  /**
   * If the input
   * @param number
   * @return true if the polynomial is 0 at that number
   */
  public boolean isRoot(double number);

  /**
   *
   * @param other
   * @return
   */
  public boolean isEqualTo(Polynomial other);

  /**
   *
   * @param other
   * @return polynomial by adding two polynomials
   */
  public Polynomial plus(Polynomial other) throws IllegalArgumentException;
}
