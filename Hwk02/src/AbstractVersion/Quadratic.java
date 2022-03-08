package AbstractVersion;

public class Quadratic extends AbstractTerm {
  private Polynomial line;

  /**
   * Constructs a quadratic and initializes it
   *
   * @param coefficient, Polynomial line
   */
  public Quadratic(double coefficient, Polynomial line) {
    super(coefficient, 2);
    this.line = line;
  }

  //no parameter for x^2+x
  public Quadratic() {
    super(1, 2);
    this.line = new Line();
  }

  /**
   * @return 2 if the coefficient of x isn't 0, otherwise 0
   */
  @Override
  public int getDegree() {
    if(coefficient!=0){
      return 2;
    }
    else{
      return this.line.getDegree();
    }
  }

  /**
   * @param power
   * @return Coefficient when power =2or1or0
   * @throws IllegalArgumentException
   */
  @Override
  public double getCoefficient(int power)throws IllegalArgumentException {
    if(power >2 ){
      throw new IllegalArgumentException("Degree won't be bigger than 2");
    }
    if(power==2){
      return coefficient;
    }
    else if(power==1){
      return this.line.getCoefficient(power);
    }
    else {
      return this.line.getLowerLevel().getCoefficient(power);
    }
  }

  /**
   * @return Line part
   */
  @Override
  public Polynomial getLowerLevel() {
    return this.line;
  }

  @Override
  public String getString() {
    String sQuad = "";
    String sLine = "";
    String string = "";

    //Quadratic part
    //if coefficient isn't 0
    if(coefficient!=0){
      // Line part
      if (coefficient == 1) {
        sQuad = "x^2";
      } else {
        sQuad = String.format("%.1f",coefficient) + "x^2";
      }
      // Line part
      if(this.line.getCoefficient(1)>0) {
        string = sQuad + "+" + this.line.getString();
      }
      else if(this.line.getCoefficient(1)<0){
        string = sQuad +  this.line.getString();
      }
      else{
        if(this.line.getCoefficient(0)==0){
          string = sQuad ;
        }
        else{
          string = sQuad +"+" + this.line.getString();
        }
      }
    }
    //if coefficient is 0
    else{
      string = sQuad + this.line.getString();
    }

    return string;
  }

  /**
   * @return double this.coefficient if it is not 0
   */
  @Override
  public double getLeadingCoefficient() {
    if(coefficient!=0){
      return coefficient;
    }
    return this.line.getLeadingCoefficient();
  }

  /**
   * @param number
   * @return the double result evaluated at input number
   */
  @Override
  public double evaluateAt(double number) {
    double result =coefficient * Math.sqrt(number) + this.line.evaluateAt(number);
    return result;
  }

  /**
   * @return a double result when input is 0
   */
  @Override
  public double getYIntercept() {
    double result = this.line.evaluateAt(0);
    return result;
  }

  /**
   * @param number
   * @return true if the polynomial evaluated 0 at this number
   */
  @Override
  public boolean isRoot(double number) {
    double result =coefficient * Math.sqrt(number) + this.line.evaluateAt(number);
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

    if(other.getDegree()==this.getDegree() && (Math.abs(other.getLeadingCoefficient()-this.getLeadingCoefficient())<0.01)
                        && other.getLowerLevel().isEqualTo(this.getLowerLevel())) {
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
    if(coefficient+other.getCoefficient(2)==0){
      Polynomial newLine =  this.line.plus(other.getLowerLevel());
      return newLine;
    }
    Quadratic newQuad = new Quadratic(coefficient+other.getCoefficient(2) ,
        (Line) this.line.plus(other.getLowerLevel()));
    return newQuad;
  }

  /**
   * p(x)= ax^2 + bx +c
   * r(x) = p(x-dx) +dy  = a(x-dx)^2 +b(x-dx) +c+dy  = ax^x-2a(dx)x+a(dx)^2+bx-b(dx)+c+dy
   * @param dx
   * @param dy
   * @return
   */
  @Override
  public Polynomial translate(double dx, double dy) {
    //-2a(dx)+b
    double newLineCoefficient = this.line.getLeadingCoefficient() - 2*coefficient*dx;
    // a(dx)^2-b(dx)+c+dy
    double newConstant = coefficient * Math.pow(dx,2) - this.line.getLeadingCoefficient()*dx + this.line.getCoefficient(0) + dy;
    // System.out.println(newConstant);
    Quadratic newQ = new Quadratic(coefficient,new Line(newLineCoefficient,new Constant(newConstant)));
    return newQ;
  }

  /**
   * input polynomial's degree is zero , in case the result polynomial may be degree bigger than 2
   * @param other
   * @return
   * @throws IllegalArgumentException
   */
  @Override
  public Polynomial multiply(Polynomial other) throws IllegalArgumentException {
    if(other.getDegree()>0){
      throw new IllegalArgumentException();
    }
    double q = coefficient * other.getLeadingCoefficient();
    double l = this.line.getLeadingCoefficient() * other.getLeadingCoefficient();
    double c = this.line.getCoefficient(0) * other.getLeadingCoefficient();
    Quadratic newQuad = new Quadratic(q,new Line(l,new Constant(c)));
    return newQuad;
  }


}
