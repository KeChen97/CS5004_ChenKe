package AbstractVersion;

public class Constant extends AbstractTerm {

  /**
   * Constructs a constant and initializes it
   *
   * @param coefficient,double
   */
  public Constant(double coefficient) {
    super(coefficient, 0);
  }

  /**
   * Constructs a constant object and initializes it with 0
   */
  public Constant() {
    super(0, 0);
  }

  /**
   * degree of this constant is 0
   * @return 0
   */
  @Override
  public int getDegree() {
    return 0;
  }

  /**
   * get coefficient
   * @param power
   * @return this constant if input power is 0
   */
  @Override
  public double getCoefficient(int power)  {
    if (power == 0) {
      return coefficient;
    }
    return 0;
  }

  /**
   * Lower level of a constant is empty = 0
   * @return
   */
  @Override
  public Polynomial getLowerLevel() {
    return new Constant();
  }

  /**
   * Display one decimal place.
   * @return string
   */
  @Override
  public String toString() {
    String s =  String.format("%.1f",coefficient);
    return s;
  }

  /**
   * get leading coefficient
   * @return
   */
  @Override
  public double getLeadingCoefficient() {
    return coefficient;
  }

  /**
   * the constant polynomial's result evaluated at input number is just this constant
   * @param number
   * @return
   */
  @Override
  public double evaluateAt(double number) {
    return coefficient;
  }

  /**
   * Result will be the constant
   * @return
   */
  @Override
  public double getYIntercept() {
    return coefficient;
  }

  /**
   * A constant polynomial will only have root when the constant is 0
   * @param number
   * @return true if the constant is 0, otherwise false.
   */
  @Override
  public boolean isRoot(double number) {
    if(coefficient==0){
      return true;
    }
    return false;
  }

  /**
   * if the two polynomial is equal, return true.
   * @param other another Polynomial object
   * @return true if the constant is the same
   */
  @Override
  public boolean isEqualTo(Polynomial other) {
    if (! (other instanceof Polynomial)){
      return false;
    }

    if(other.getDegree() == this.getDegree() &&
        (Math.abs(other.getLeadingCoefficient()-this.getLeadingCoefficient())<0.01) ){
      return true;
    }
    else {
      return false;
    }
  }

  /**
   * Add two polynomials
   * @param other another Polynomial object
   * @return a new polynomial by adding two polynomials together
   * @throws IllegalArgumentException if degree>2
   */
  @Override
  public Constant plus(Polynomial other) throws IllegalArgumentException {
    if(other.getDegree()>=3){
      throw new IllegalArgumentException();
    }
    Constant newConstant = new Constant(other.getCoefficient(0) + coefficient);
    return newConstant;
  }



  /**
   * return a new constant polynomial with increment dy
   * @param dx
   * @param dy
   * @return a new constant polynomial
   */
  @Override
  public Polynomial translate(double dx, double dy) {
    Constant newConstant = new Constant( coefficient+dy);
    return newConstant;
  }

  /**
   * takes another polynomial of degree 0 or 1 and returns the polynomial obtained by multiplying the two
   * @param other another Polynomial object
   * @return
   * @throws IllegalArgumentException if degree >=2
   */
  @Override
  public Polynomial multiply(Polynomial other) throws IllegalArgumentException {
    if(other.getDegree()>2){
      throw new IllegalArgumentException();
    }
    Constant newConstant = new Constant(other.getCoefficient(0) * coefficient);
    return newConstant;
  }


}

