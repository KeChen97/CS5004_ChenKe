package AbstractVersion;

public class Line extends AbstractTerm{
  private Constant constant;

  /**
   * Constructs a line and initializes it
   *
   * @param
   */
  public Line(double coefficient, Constant constant) {
    super(coefficient, 1);
    this.constant = constant;

  }

  // no parameter for term whose coefficient is 1 and constant is 0
  public Line() {
    super(1, 1);
    this.constant = new Constant();
  }

  /**
   * @return 1 if the coefficient of x isn't 0, otherwise 0
   */
  @Override
  public int getDegree() {
    if (coefficient != 0) {
      return 1;
    } else {
      return this.constant.getDegree();
    }
  }

  /**
   * @param power
   * @return this.coefficient if input power is 1, return constant if input power is 0
   * @throws IllegalArgumentException if degree bigger than 2
   */
  @Override
  public double getCoefficient(int power)throws IllegalArgumentException {
    if(power >2 ){
      throw new IllegalArgumentException("Degree won't be bigger than 2");
    }
    else if(power==1){
      return this.coefficient;
    }
    else if(power==2) {
      return 0;
    }
    else{
      return this.constant.getCoefficient(power);
    }
  }

  /**
   * @return constant part
   */
  @Override
  public Polynomial getLowerLevel() {
    return this.constant;
  }

  /**
   * @return Display this line
   */
  @Override
  public String getString() {
    String sl = "";
    String string = "";
    if(coefficient!=0){
    // Line part
    if (coefficient == 1) {
      sl = "x";
    }
    else if (coefficient == -1) {
        sl = "-x";
      }
    else {
      sl = String.format("%.1f",coefficient) + "x";
    }
    // Constant part
      //constant is not 0
    if (this.constant.getCoefficient(0) != 0) {

      if (this.constant.getCoefficient(0) > 0) {
        string = sl + "+" + this.constant.getString();
      }
      else if(this.constant.getCoefficient(0) <0){
        string = sl +  this.constant.getString();
      }
      else {
        string = sl+string;
      }
    }
    //constant is zero
    else{
      string = sl+string;
    }
  }
   //if coefficient is 0
    else{
    string = this.constant.getString();
  }
    return string;
  }

  /**
   * @return double this.coefficient if it is not 0
   */
  @Override
  public double getLeadingCoefficient() {
    if(this.coefficient!=0) {
      return this.coefficient;
    }
    else{
      return this.constant.getCoefficient(0);
    }
  }

  /**
   * @param number
   * @return the double result evaluated at input number
   */
  @Override
  public double evaluateAt(double number) {
    double result = number*this.coefficient + this.constant.evaluateAt(number);
    return result;
  }

  /**
   * @return a double result when input is 0
   */
  @Override
  public double getYIntercept() {
    double result = 0*coefficient + this.constant.getYIntercept();
    return result;
  }

  /**
   * @param number
   * @return true if the polynomial evaluated 0 at this number
   */
  @Override
  public boolean isRoot(double number) {
    double result = number*coefficient + this.constant.evaluateAt(number);
    if(result==0){
      return true;
    }
    return false;
  }

  /**
   * compare the degree and every coefficient
   * @param other
   * @return
   */
  @Override
  public boolean isEqualTo(Polynomial other) {
    if(other.getDegree() == this.getDegree() && (Math.abs(other.getLeadingCoefficient()-this.getLeadingCoefficient())<0.01)
        && other.getLowerLevel().isEqualTo(this.constant)){
      return true;
    }
    else {
      return false;
    }
  }

  /**
   * add coefficient for every term
   * @param other
   * @return
   * @throws IllegalArgumentException
   */
  @Override
  public Polynomial plus(Polynomial other) throws IllegalArgumentException {
    if(other.getDegree()>2){
      throw new IllegalArgumentException();
    }
    if(coefficient+other.getCoefficient(1)==0){
      Constant newConstant = this.constant.plus(other.getLowerLevel());
      return newConstant;
    }
    Line newLine = new Line(coefficient+other.getCoefficient(1) , this.constant.plus(other.getLowerLevel()));
    return newLine;
  }


  /**
   * A method translate with double parameters dx and dy that returns a new polynomial r
   * such that r(x) = p(x – dx) + dy
   * @param dx
   * @param dy
   * @return
   */
  @Override
  public Polynomial translate(double dx, double dy) {
    double newC = this.constant.getLeadingCoefficient() -coefficient*dx + dy ;
   // System.out.println(newC);
    Line newLine = new Line(coefficient,new Constant(newC));
    return newLine;
  }

  /**
   * takes another polynomial of degree 0 or 1 and returns the polynomial obtained by multiplying the two
   * @param other
   * @return
   * @throws IllegalArgumentException if degree >=2
   */
  @Override
  public Polynomial multiply(Polynomial other) throws IllegalArgumentException {
    if(other.getDegree()>1){
      throw new IllegalArgumentException();
    }

    Quadratic result = new Quadratic();

    //if both degrees are 1
    if(this.getDegree()==1 && other.getDegree()==1) {
      double coefficient1 = coefficient * other.getCoefficient(1);
      double coefficient2 = this.constant.getLeadingCoefficient() * other.getCoefficient(1)
          + other.getCoefficient(0) * coefficient;
      double coefficient3 = this.constant.getLeadingCoefficient() * other.getCoefficient(0);
      result = new Quadratic(coefficient1, new Line(coefficient2, new Constant(coefficient3)));
    }

    //if this.degree is 1, other degree is 0
    if(this.getDegree()==1 && other.getDegree()==0) {
      double coefficient1 = 0;
      double coefficient2 = coefficient * other.getCoefficient(0);
      double coefficient3 = this.constant.getLeadingCoefficient() * other.getCoefficient(0);
      result = new Quadratic(coefficient1, new Line(coefficient2, new Constant(coefficient3)));
    }

//    //if this.degree is 0, other degree is 1
//    if(this.getDegree()==0 && other.getDegree()==1) {
//      double coefficient1 = 0;
//      double coefficient2 = other.getCoefficient(1) * this.getCoefficient(0);
//      double coefficient3 = this.constant.getLeadingCoefficient() * other.getCoefficient(0);
//      result = new Quadratic(coefficient1, new Line(coefficient2, new Constant(coefficient3)));
//    }
//
//    //if both degree are 0
//    if(this.getDegree()==0 && other.getDegree()==0) {
//      double coefficient1 = 0;
//      double coefficient2 = 0;
//      double coefficient3 = this.constant.getLeadingCoefficient() * other.getCoefficient(0);
//      result = new Quadratic(coefficient1, new Line(coefficient2, new Constant(coefficient3)));
//    }
    return result;
  }
}
