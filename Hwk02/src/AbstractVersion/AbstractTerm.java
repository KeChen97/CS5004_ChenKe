package AbstractVersion;

/**
 * This is the abstract class for term in polynomial
 */
public abstract class AbstractTerm implements Polynomial {
  protected double coefficient;
  protected int degree;

  /**
   * Constructor for AbstractTerm
   * @param coefficient
   * @param degree
   */
  public AbstractTerm(double coefficient, int degree) {
    this.coefficient = coefficient;
    this.degree = degree;
  }
}
