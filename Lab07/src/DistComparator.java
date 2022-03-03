public abstract class DistComparator implements Comparable<Shape> {

   /**
    * compare two shape based on the distance from origin
    * @param s1
    * @param s2
    * @return
    */

   public static int compare(Shape s1, Shape s2){
      double dist1 = s1.distanceFromOrigin();
      double dist2 = s2.distanceFromOrigin();
      if (dist1 < dist2) {
         return -1;
      } else if (dist2 < dist1) {
         return 1;
      } else {
         return 0;
      }
   }
}
