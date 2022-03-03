/**
 * Created by ashesh on 1/26/2017.
 */
public abstract class AbstractShape implements Shape {
  protected Point2D reference;

  public AbstractShape(Point2D reference) {
    this.reference = reference;
  }

  @Override
  public double distanceFromOrigin() {
    return reference.distToOrigin();
  }


  /**
   * compare the perimeter of two shape
   * @param s
   * @return -1 if this perimeter is smaller, otherwise 1
   */
  @Override
  public int compareTo(Shape s) {
    double perimeterThis = this.perimeter();
    double perimeterOther = s.perimeter();

    if (perimeterThis < perimeterOther) {
      return -1;
    } else if (perimeterOther < perimeterThis) {
      return 1;
    } else {
      return 0;
    }
  }


}