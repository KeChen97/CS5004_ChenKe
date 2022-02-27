package AbstractVersion;

public class Constant extends AbstractTerm {

  /**
   * Constructs a constant and initializes it
   *
   * @param
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
   * @return degree of this constant
   */
  @Override
  public int getDegree() {
    return 0;
  }

  /**
   * @param power
   * @return this constant if input power is 0
   * @throws IllegalArgumentException
   */
  @Override
  public double getCoefficient(int power) throws IllegalArgumentException {
    if (power == 0) {
      return coefficient;
    }
    return 0;
  }

  //Lower level of a constant is empty = 0
  @Override
  public Polynomial getLowerLevel() {
    return new Constant();
  }

  /**
   * Display one decimal place.
   * @return string
   */
  @Override
  public String getString() {
    String s =  String.format("%.1f",coefficient);
    return s;
  }

  /**
   * @return leading coefficient
   */
  @Override
  public double getLeadingCoefficient() {
    return coefficient;
  }

  /**
   * @param number
   * @return the polynomial at input number
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
   *
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
   *
   * @param other
   * @return true if the constant is the same
   */
  @Override
  public boolean isEqualTo(Polynomial other) {
    if(other.getDegree() == this.getDegree() &&
        (Math.abs(other.getLeadingCoefficient()-this.getLeadingCoefficient())<0.01) ){
      return true;
    }
    else {
      return false;
    }
  }

  /**
   * @param other
   * @return
   * @throws IllegalArgumentException
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
   * @param dx
   * @param dy
   * @return A new constant polynomial with increment dy
   */
  @Override
  public Polynomial translate(double dx, double dy) {
    Constant newConstant = new Constant( coefficient+dy);
    return newConstant;
  }

  /**
   * takes another polynomial of degree 0 or 1 and returns the polynomial obtained by multiplying the two
   * @param other
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

