package AbstractVersion;

public abstract class AbstractTerm implements Polynomial {
  protected double coefficient;
  protected int degree;

  public AbstractTerm(double coefficient, int degree) {
    this.coefficient = coefficient;
    this.degree = degree;
  }


}