package AbstractVersion;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PolynomialTest {
  private Constant constant;
  private Constant constant2;
  private Constant zero;
  private Line line;
  private Line line2;
  private Line line3;
  private Quadratic quadratic;
  private Quadratic quadratic2;

  @Before
  public void setUp() throws Exception {
    this.constant = new Constant(1.66);     //p(x)=1.66
    this.constant2 = new Constant(3.22);    //p(x)=3.22
    this.zero = new Constant();                 //p(x)=0
    this.line = new Line(2.56,this.constant);   //p(x)=2.56x+1,66
    this.line2 = new Line(0,this.constant);     //p(x)=1,66
    this.line3 = new Line();    //p(x)=x
    this.quadratic = new Quadratic(2.5,this.line);    //2.5x^2+2.56x+1.7
    this.quadratic2 = new Quadratic(1.5,this.line2); //1.5x^2+1.7
  }

  //test getDegree
  @Test
  public void getDegree() {
    assertEquals(0,this.constant.getDegree());
    assertEquals(0,this.constant2.getDegree());
    assertEquals(1,this.line.getDegree());
    assertEquals(0,this.line2.getDegree());
    assertEquals(1,this.line3.getDegree());
    assertEquals(2,this.quadratic.getDegree());
    assertEquals(2,this.quadratic2.getDegree());
  }

  //test getCoefficient
  @Test
  public void getCoefficient() {
    assertEquals(1.66,this.constant.getCoefficient(0),0.01);
    assertEquals(3.22,this.constant2.getCoefficient(0),0.01);
    assertEquals(0,this.zero.getCoefficient(0),0.01);
    assertEquals(2.56,this.line.getCoefficient(1),0.01);
    assertEquals(0,this.line2.getCoefficient(1),0.01);
    assertEquals(0.0,this.line3.getCoefficient(0),0.01);
    assertEquals(2.5,this.quadratic.getCoefficient(2),0.01);
    assertEquals(1.5,this.quadratic2.getCoefficient(2),0.01);
  }

  //test getString
  //Display one decimal place. Do not print terms with a coefficient of 0. Do not print the
  //coefficient if it is 1.
  @Test
  public void getString() {
    assertEquals("1.7",this.constant.getString());
    assertEquals("3.2",this.constant2.getString());
    assertEquals("0.0",this.zero.getString());

    //test line
    assertEquals("2.6x+1.7",this.line.getString());
    assertEquals("1.7",this.line2.getString());
    assertEquals("x",this.line3.getString());
    Line line4 = new Line(-1,new Constant(1.52));
    assertEquals("-x+1.5",line4.getString());

    //test quadratic
    assertEquals("2.5x^2+2.6x+1.7",this.quadratic.getString());
    assertEquals("1.5x^2+1.7",this.quadratic2.getString());
    Quadratic quadratic3 = new Quadratic(-2.5,new Line(-1,new Constant(0)));
    assertEquals("-2.5x^2-x",quadratic3.getString());
  }

  //test LeadingCoefficient
  @Test
  public void getLeadingCoefficient() {
    assertEquals(1.66,this.constant.getLeadingCoefficient(),0.01);
    assertEquals(3.22,this.constant2.getLeadingCoefficient(),0.01);
    assertEquals(0,this.zero.getLeadingCoefficient(),0.01);
    assertEquals(2.56,this.line.getLeadingCoefficient(),0.01);
    assertEquals(1,this.line3.getLeadingCoefficient(),0.01);
    assertEquals(2.5,this.quadratic.getLeadingCoefficient(),0.01);
    assertEquals(1.5,this.quadratic2.getLeadingCoefficient(),0.01);

  }

  //test evluateAt
  @Test
  public void evaluateAt() {
    assertEquals(1.66,this.constant.evaluateAt(100),0.01);
    assertEquals(3.22,this.constant2.evaluateAt(100),0.01);
    assertEquals(0,this.zero.evaluateAt(100),0.01);
    assertEquals(257.66,this.line.evaluateAt(100),0.01);
    assertEquals(1.66,this.line2.evaluateAt(100),0.01);
    assertEquals(100,this.line3.evaluateAt(100),0.01);
    assertEquals(1.66,this.quadratic.evaluateAt(0),0.01);
    assertEquals(3.16,this.quadratic2.evaluateAt(1),0.01);

  }

  @Test
  public void getYIntercept() {
    assertEquals(1.66,this.constant.getYIntercept(),0.01);
    assertEquals(3.22,this.constant2.getYIntercept(),0.01);
    assertEquals(0,this.zero.getYIntercept(),0.01);
    assertEquals(1.66,this.line.getYIntercept(),0.01);
    assertEquals(0,this.line3.getYIntercept(),0.01);
    assertEquals(1.66,this.quadratic.getYIntercept(),0.01);
    assertEquals(1.66,this.quadratic2.getYIntercept(),0.01);

  }

  @Test
  public void isRoot() {
    assertFalse(this.constant.isRoot(0));
    assertFalse(this.constant2.isRoot(0));
    assertTrue(this.zero.isRoot(0));
    assertFalse(this.line.isRoot(0));
    assertTrue(this.line3.isRoot(0));
    assertFalse(this.quadratic.isRoot(0));
    assertFalse(this.quadratic2.isRoot(0));
  }

  @Test
  public void isEqualTo() {
    //test constant isEqualTo
    Constant constant3 = new Constant(1.66);
    assertTrue(this.constant.isEqualTo(constant3));
    assertFalse(this.constant.isEqualTo(this.zero));
    assertFalse(this.constant.isEqualTo(this.constant2));
    //test line isEqualTo
    Line line4 = new Line(2.56,new Constant(1.66));
    assertTrue(line.isEqualTo(line4));
    assertFalse(this.line.isEqualTo(this.line2));
    assertFalse(this.line2.isEqualTo(this.constant));
    //test quadratic isEqualTo
    Quadratic quadratic3 = new Quadratic(2.5,this.line);
    assertTrue(this.quadratic.isEqualTo(quadratic3));
    assertFalse(this.quadratic.isEqualTo(this.quadratic2));
  }

  @Test
  public void plus() {
    //test constant plus
    assertEquals(4.88,this.constant.plus(this.constant2).getCoefficient(0),0.01);
    assertEquals(1.66,this.constant.plus(this.zero).getCoefficient(0),0.01);
    //test line plus
    Line line4 = new Line(2.56,new Constant(3.32));
    assertTrue(this.line.plus(this.line2).isEqualTo(line4));  //2.56x+3.32

    line4 = new Line(3.56,new Constant(1.66));
    assertTrue(this.line.plus(this.line3).isEqualTo(line4));  //3.56x+1.66

    //test quadratic plus
    Quadratic quadratic3 = new Quadratic(4.0,this.line.plus(this.line2));
    assertTrue(quadratic3.isEqualTo(this.quadratic.plus(this.quadratic2)));

  }

  @Test
  public void translate() {
    //test constant translate
    Constant newC = new Constant(2.66);
    assertTrue(newC.isEqualTo(this.constant.translate(1,1)));

    //test line translate  2.56x+1.66 (1,1)
    Line newL = new Line(2.56,new Constant(0.1));
    assertTrue(newL.isEqualTo(this.line.translate(1,1)));

    //test quadratic translate
    Quadratic quadratic3 = new Quadratic(1, new Line(1, new Constant(1)));  //x^2+x+1.0
    Polynomial quadratic4 = quadratic3.translate(1,1);       // x^2-x+2
    Quadratic quadratic5 = new Quadratic(1, new Line(-1, new Constant(2)));
    assertTrue(quadratic4.isEqualTo(quadratic5));

  }

  @Test
  public void multiply() {
    //test constant.multiply   1.66 multiply 3.22
    assertEquals(1.66*3.22,this.constant.multiply(this.constant2).getCoefficient(0),0.01);
    // 1.66 multiply 0
    assertEquals(0,this.constant.multiply(this.zero).getCoefficient(0),0.01);

    //test line.multiply    1.66 * (2.56x + 1.66)
    Quadratic quadratic3 = new Quadratic(0,new Line(2.56*1.66, new Constant(Math.pow(1.66,2))));
    assertTrue((this.line.multiply(this.constant)).isEqualTo(quadratic3));
    // (2.56x + 1.66 ) * x
    quadratic3 = new Quadratic(2.56,new Line(1.66, new Constant()));
    assertTrue((this.line.multiply(this.line3)).isEqualTo(quadratic3));

    //test quadratic.multiply  (2.5x^2+2.56x+1.7) * 0
    quadratic3 = new Quadratic(0,new Line(0, new Constant(Math.pow(0,2))));
    assertTrue(quadratic3.isEqualTo(this.quadratic.multiply(this.zero)));
    //  (2.5x^2+2.56x+1.7) * 1.66
    quadratic3 = new Quadratic(2.5*1.66,new Line(2.56*1.66, new Constant(1.66*1.66)));
    assertTrue(quadratic3.isEqualTo(this.quadratic.multiply(this.constant)));

  }
}