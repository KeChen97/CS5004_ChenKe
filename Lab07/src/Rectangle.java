/**
 * This class represents a rectangle.  It defines all the operations mandated by
 * the Shape interface
 */
public class Rectangle extends AbstractShape {
  private double width, height;

  /**
   * Constructs a rectangle object with the given location of its lower-left
   * corner and dimensions
   *
   * @param x      x coordinate of the lower-left corner of this rectangle
   * @param y      y coordinate of the lower-left corner of this rectangle
   * @param width  width of this rectangle
   * @param height height of this rectangle
   */
  public Rectangle(double x, double y, double width, double height) {
    super(new Point2D(x, y));
    this.width = width;
    this.height = height;
  }

  /**
   * Computes and returns the area of this rectangle
   * @return the area of the rectangle
   */
  @Override
  public double area() {
    return this.width * this.height;
  }

  /**
   * Computes and returns the perimeter of this rectangle
   * @return the perimeter of the rectangle
   */
  @Override
  public double perimeter() {
    return 2 * (this.width + this.height);
  }

  /**
   * Create and return a rectangle , resized
   * in area by the provided factor
   * @param factor factor of resizing
   * @return the resized rectangle
   */
  @Override
  public Shape resize(double factor) {
    double sqrtFactor = Math.sqrt(factor);
    return new Rectangle(
            this.reference.getX(),
            this.reference.getY(), sqrtFactor *
            this.width,
            sqrtFactor * this.height);
  }

  /**
   * @return display this rectangle and its left bottom point and width and height
   */
  public String toString() {
    return String.format("Rectangle: LL corner (%.3f,%.3f) width %.3f height " +
                    "%.3f",
            this.reference.getX(), this.reference.getY(), this.width, this
                    .height);
  }
}