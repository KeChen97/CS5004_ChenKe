package AbstractVersion;
  /**
   * This interface includes all methods that all child
   * LinkedListVersion.Polynomial classes should support.
   */
  public interface Polynomial {
    /**
     *
     * @return int: Maximum degree of the polynomial
     */
    public int getDegree();

    /**
     *
     * @param power an int number
     * @return the coefficient for the term with that power
     */
    public double getCoefficient(int power);

    /**
     * @return return constant part for a line, return line for a quadratic
     */
    public Polynomial getLowerLevel();


    /**
     * representation of the polynomial
     * @return String
     */
    public String toString();

    /**
     * get the leading coefficient
     * @return double number
     */
    public double getLeadingCoefficient();

    /**
     * return the result the polynomial at that number
     * @param number
     * @return
     */
    public double evaluateAt(double number);

    /**
     * The polynomial evaluated at 0
     * @return
     */
    public double getYIntercept();

    /**
     * If the input is 0 at that number, return true.
     * @param number
     * @return
     */
    public boolean isRoot(double number);

    /**
     * if the two polynomial is equal, return true.
     * @param other  another Polynomial object
     * @return
     */
    public boolean isEqualTo(Polynomial other);

    /**
     * Add two polynomials
     * @param other  another Polynomial object
     * @return polynomial by adding two polynomials
     */
    public Polynomial plus(Polynomial other) throws IllegalArgumentException;

    /**
     * A method translate with double parameters dx and dy that returns a new polynomial r
     * such that r(x) = p(x – dx) + dy
     * @param dx
     * @param dy
     * @return
     */
    public Polynomial translate (double dx, double dy);

    /**
     * A method multiply that takes another polynomial of degree 0 or 1 and returns the
     * polynomial obtained by multiplying the two polynomials
     * @param other
     * @return
     * @throws IllegalArgumentException
     */
    public Polynomial multiply(Polynomial other) throws IllegalArgumentException;


  }


