/**
 * This class represents a fraction with a numerator, and a denomirator
 */
public class Fraction {

  private int numerator;
  private int denominator;

  /**
   * Constructs a Fraction object and initializes it to the given nominator and denominator
   *
   * @param numerator
   * @param denominator
   */
  public Fraction(int numerator, int denominator) {
    this.numerator = numerator;
    this.denominator = reasonableDenominator(denominator);
  }

  /**
   * The denominator should always be positive.
   *
   * @param denominator
   * @return correct denominator
   */
  public int reasonableDenominator(int denominator) {
    if (denominator == 0) {
      throw new IllegalArgumentException("Denominartor can't be zero");
    } else if (denominator < 0) {
      this.numerator = -numerator;
      return -denominator;
    } else {
      return denominator;
    }
  }

  /**
   * set numerator for this fraction
   *
   * @param numerator
   * @return numerator
   */
  public void setNumerator(int numerator) {
    this.numerator = numerator;
  }

  /**
   * set denominator for this fraction
   *
   * @param denominator
   * @return denominator
   */
  public void setDenominator(int denominator) {
    this.denominator = reasonableDenominator(denominator);
  }

  /**
   * get the value of numerator
   *
   * @return numerator
   */
  public int getNumerator() {
    return numerator;
  }

  /**
   * get the value of denominator
   *
   * @return denominator
   */
  public int getDenominator() {
    return denominator;
  }

  /**
   * @return the scientific value (decimal) of the fraction
   */
  public double toDouble() {
    double value = (double) this.numerator / (double) this.denominator;
    return value;
  }

  /**
   * @param other
   * @return if the other fraction is same with this fraction
   */
  public boolean equals(Object other) {
    Fraction otherFraction = (Fraction) other;
    if (this.numerator == ((Fraction) other).getNumerator() &&
        this.denominator == ((Fraction) other).getDenominator()) {
      return true;
    }
    return false;
  }

  /**
   * @return the reciprocal of this fraction
   */
  public Fraction reciprocal() {
    if (this.numerator == 0) {
      Fraction sameFraction = new Fraction(this.numerator, this.denominator);
      return sameFraction;
    }
    Fraction reciprocal = new Fraction(this.denominator, this.numerator);
    return reciprocal;
  }

  /**
   * adds this fraction to the one passed to it
   *
   * @param other
   * @return the result as a fraction object
   */
  public Fraction add(Fraction other) {
    int newNumerator =
        this.numerator * other.getDenominator() + other.getNumerator() * this.denominator;
    int newDenominator = this.denominator * other.getDenominator();
    Fraction sum = new Fraction(newNumerator, newDenominator);
    return sum;
  }

  /**
   * compares two fractions
   *
   * @param other
   * @return a negative number if this<other, a positive number if this>other and 0 otherwise
   */
  public int compareTo(Fraction other) {
    if (this.numerator * other.getDenominator() < other.getNumerator() * this.denominator) {
      return -1;
    } else if (this.numerator * other.getDenominator() > other.getNumerator() * this.denominator) {
      return 1;
    } else {
      return 0;
    }
  }

  /**
   * depicting the fraction’s value
   *
   * @return a string
   */
  @Override
  public String toString() {
    return "Fraction: " +
        +numerator + "/" +
        denominator;
  }

  public static void main(String[] args) {
    Fraction frc = new Fraction(1, -2);
    System.out.println(frc.toString());
    Fraction frcc = new Fraction(-1, 1);
    System.out.println(frcc.toString());
    System.out.println(frc.add(frcc).toString());

  }
}
