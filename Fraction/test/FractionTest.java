import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class FractionTest {
  private Fraction a;
  private Fraction b;
  private Fraction c;
  private Fraction d;
  private Fraction e;

  @Before
  public void setUp() throws Exception {
    this.a = new Fraction(1,2);
    this.b = new Fraction(-1,2);
    this.c = new Fraction(1,-2);
    this.d = new Fraction(-1,-2);
  }

  @Test
  public void testSetNumerator() {
    this.a.setNumerator(2);
    assertEquals(2,this.a.getNumerator());
    this.a.setNumerator(-2);
    assertEquals(-2,this.a.getNumerator());
  }

  @Test
  public void testSetDenominator() {
    this.a.setDenominator(3);
    assertEquals(3,this.a.getDenominator());
    this.a.setDenominator(-3);
    assertEquals(3,this.a.getDenominator());
  }

  @Test  (expected = IllegalArgumentException.class)
  public void testReasonableDenominator(){
    this.a.setDenominator(0);
  }


  @Test
  public void testGetNumerator() {
    assertEquals(1,this.a.getNumerator());
    assertEquals(-1,this.b.getNumerator());
    assertEquals(-1,this.c.getNumerator());
    assertEquals(1,this.d.getNumerator());
  }

  @Test
  public void testGetDenominator() {
    assertEquals(2,this.a.getDenominator());
    assertEquals(2,this.b.getDenominator());
    assertEquals(2,this.c.getDenominator());
    assertEquals(2,this.d.getDenominator());
  }

  @Test
  public void testSimplify(){
    this.e = new Fraction(-4,8);
    this.e = e.simplify();
    assertEquals(-1,this.e.getNumerator());
    assertEquals(2,this.e.getDenominator());
  }


  @Test
  public void testToDouble() {
    assertEquals(0.5,this.a.toDouble(),0.01);
  }

  @Test
  public void testEquals() {
    assertFalse(this.a.equals(this.b));
  }

  @Test
  public void testReciprocal() {
    this.e = new Fraction(2,1);
    assertEquals(this.e,this.a.reciprocal());
    this.e = new Fraction(-2,1);
    assertEquals(this.e,this.b.reciprocal());
  }

  @Test (expected = IllegalArgumentException.class)
  public void testZeroReciprocal(){
    this.e = new Fraction(0,2);
    this.e.reciprocal();
  }

  @Test
  public void testAdd() {
    this.e = new Fraction(0,4);
    assertEquals(this.e,this.a.add(this.b));
    this.e = new Fraction(-4,4);
    assertEquals(this.e,this.b.add(this.c));
  }

  @Test
  public void testCompareTo() {
    assertEquals(1,this.a.compareTo(this.b));
    assertEquals(0,this.c.compareTo(this.b));
    assertEquals(-1,this.c.compareTo(this.d));
  }

  @Test
  public void testToString() {
    String string = "Fraction: -1/2";
    assertEquals(string,this.b.toString());
    this.e = new Fraction(-4,8);
    assertEquals(string,this.e.toString());
  }
}