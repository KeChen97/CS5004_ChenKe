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
   * Computes and returns the area of this triangle
   * triangle area = 0.5 * |x1 * (y2-y3) + x2 * (y3-y1) + x3 * (y1-y2)|
   * @return
   */
  @Override
  public double area() {
    double area = 0.5 * Math.abs( reference.getX()*(p2.getY()-p3.getY()) + p2.getX()*(p3.getY()-reference.getY()) + p3.getX()*(reference.getY()-p2.getY()));
    return area;
  }

  /**
   * Computes and returns the perimeter of this triangle
   * @return the perimeter of the triangle
   */
  @Override
  public double perimeter() {
    double perimeter = reference.disTo(p2) + reference.disTo(p3) + p2.disTo(p3);
    return perimeter;
  }

  /**
   * Create and return a triangle , resized in area by the provided factor
   * based on Heron's formula states for a triangle, when sides of lengths are factored by f, the area will be factored by f^2
   * therefore if area is resized by factor, the lengths of sides will be resized by sqrt f
   * @param factor factor of resizing
   * @return the resized triangle
   */
  @Override
  public Shape resize(double factor) {
    //factor for resizing sides
   double factorOfSide = Math.sqrt(factor);

   //find the new p2, it is still in line defined by p1 and p2, just different in length
    double newP2x = reference.getX()+factorOfSide * (p2.getX()-reference.getX());
    double newP2y = reference.getY()+factorOfSide * (p2.getY()-reference.getY());

    //find the new p3, it is still in line defined by p1 and p3, just different in length
    double newP3x = reference.getX()+factorOfSide * (p3.getX()-reference.getX());
    double newP3y = reference.getY()+factorOfSide * (p3.getY()-reference.getY());

    return new Triangle(reference.getX(),reference.getY(),newP2x,newP2y,newP3x,newP3y);

  }

  /**
   * @return display this triangle and its 3 points
   */
  @Override
  public String toString(){
    return String.format("Triangle: first point (%.3f,%.3f) second point (%.3f,%.3f) third point (%.3f,%.3f)",
        this.reference.getX(),this.reference.getY(),p2.getX(),p2.getY(),p3.getX(),p3.getY());
  }
}
