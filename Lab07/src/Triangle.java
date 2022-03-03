public class Triangle extends AbstractShape {
  private Point2D p2;
  private Point2D p3;

  /**
   * Construct a triangle object using the given 3 points
   * @param x1 x coordinate of the first point of this circle
   * @param y1 y coordinate of the first point of this circle
   * @param x2 x coordinate of the second point of this circle
   * @param y2 y coordinate of the second point of this circle
   * @param x3 x coordinate of the third point of this circle
   * @param y3 y coordinate of the third point of this circle
   * @throws IllegalArgumentException if two of the points are same
   */
  public Triangle(double x1, double y1,double x2, double y2,double x3, double y3) throws IllegalArgumentException{
    super(new Point2D(x1,y1));
    p2 = new Point2D(x2,y2);
    p3 = new Point2D(x3,y3);
    if(reference.isEqual(p2) || reference.isEqual(p3) || p3.isEqual(p2)) {
      throw new IllegalArgumentException();
    }
  }

  /**
   * area = 0.5 * |x1 * (y2-y3) + x2 * (y3-y1) + x3 * (y1-y2)|
   * @return
   */
  @Override
  public double area() {
    double area = 0.5 * Math.abs( reference.getX()*(p2.getY()-p3.getY()) + p2.getX()*(p3.getY()-reference.getY()) + p3.getX()*(reference.getY()-p2.getY()));
    return area;
  }

  @Override
  public double perimeter() {
    double perimeter = reference.disTo(p2) + reference.disTo(p3) + p2.disTo(p3);
    return perimeter;
  }

  @Override
  public Shape resize(double factor) {
    return null;
  }

  @Override
  public String toString(){
    return String.format("Triangle: first point (%.3f,%.3f) second point (%.3f,%.3f) third point (%.3f,%.3f)",
        this.reference.getX(),this.reference.getY(),p2.getX(),p2.getY(),p3.getX(),p3.getY());
  }
}
