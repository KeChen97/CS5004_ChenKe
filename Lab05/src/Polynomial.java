/**
 * This interface includes all methods that all child Polynomial classes should support.
 */
public interface Polynomial {

  /**
   * @return int: Maximum degree of the polynomial
   */
  public int getDegree();

  /**
   * @param power
   * @return double: the coefficient for the term with that power
   */
  public double getCoefficient(int power);

  /**
   * @return String: representation of the polynomial
   */
  public String getString();

  /**
   * @return double: the leading coefficient (the coefficient for the term with biggest degree)
   */
  public double getLeadingCoefficient();

  /**
   * The result where the polynomial evaluate at when input a number
   *
   * @param number
   * @return double: the polynomial at that number
   */
  public double evaluateAt(double number);

  /**
   * The polynomial evaluated at 0
   *
   * @return double: the value when x=0
   */
  public double getYIntercept();

  /**
   * @param number
   * @return true if the polynomial is 0 at that number
   */
  public boolean isRoot(double number);

  /**
   * @param other
   * @return true if they are the same Polynomial (same degree and same coefficient for every term)
   */
  public boolean isEqualTo(Polynomial other);

  /**
   * @param other
   * @return a new polynomial by adding two polynomials together
   */
  public Polynomial plus(Polynomial other) throws IllegalArgumentException;
}
