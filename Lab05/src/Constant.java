/**
 * This class includes all methods for a constant
 */
public class Constant implements Polynomial{
  private double term;

  /**
   * Constructs a constant object and initializes it
   * @param term
   */
  public Constant(double term) {
    this.term = term;
  }

  /**
   * @return int: degree of this constant
   */
  public int getDegree() {
    return 0;
  }

  /**
   * @param  power
   * @return this constant if input power is 0
   * @throws IllegalArgumentException if input is not zero because this is a constant
   */
  @Override
  public double getCoefficient(int power) throws IllegalArgumentException{
    if(power!=0){
      throw new IllegalArgumentException("Constant's coefficient is 0.");
    }
    return this.term;
  }

  /**
   * display a constant
   * @return string
   */
  @Override
  public String getString() {
    String s = String.format("%.1f",this.term);
    String string= "p(x)=" + s;
    return string;
  }

  /**
   * @return leading coefficient, return this constant if input power is 0
   */
  @Override
  public double getLeadingCoefficient() {
    return this.term;
  }

  /**
   * @param number 
   * @return the polynomial at input number
   */
  @Override
  public double evaluateAt(double number) {
    return this.term;
  }

  /**
   * Result will be the constant 
   * @return
   */
  @Override
  public double getYIntercept() {
      return this.term;
  }

  /**
   * A constant polynomial will only have root when the constant is 0
   * @param number 
   * @return true if the constant os 0, otherwise false.
   */
  @Override
  public boolean isRoot(double number) {
    if(this.term==0){
      return true;
    }
    return false;
  }

  /**
   * 
   * @param other 
   * @return true if the constant is the same
   */
  @Override
  public boolean isEqualTo(Polynomial other) {
    if(other.getDegree() == 0 && other.getCoefficient(0) == this.term){
      return true;
    }
    return false;
  }

  /**
   * @param other 
   * @return a new polynomial by adding two polynomials together
   * @throws IllegalArgumentException
   */
  @Override
  public Polynomial plus(Polynomial other) throws IllegalArgumentException {
    if(other.getDegree()>=3){
      throw new IllegalArgumentException();
    }
    double newConstant = other.getCoefficient(0) + this.term;
    Polynomial p = new Constant(newConstant);
    return p;
  }

}


