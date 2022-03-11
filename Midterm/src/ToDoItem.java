/**
 * This interface contains all operations that all items
 * should support.
 */
public interface ToDoItem extends Comparable<ToDoItem> {

  /**
   * returns a String name, cannot be changed once constructed
   * @return a String name
   */
  String getName();


  /**
   * returns the enum category (currently SCHOOL or HOME) of the item,
   * @return enum category (currently SCHOOL or HOME. WORK, VOLUNTEER, OTHER in the future)
   */
  Enum getCategory();

  /**
   * returns integer in range 0 – 9, where 9 is most important
   * @return int from 0 to 9
   */
  int getImportance();

  /**
   * sets the importance of the item to int, returns void
   * @param importance an integer from 0 - 9
   */
  void setImportance(int importance);

  /**
   * returns an enum representing the status of the item
   * @return an enum UNSTARTED, PENDING or COMPLETED
   */
  Enum getStatus();

  /**
   * sets the status of the item
   * @param value enum value from: UNSTARTED, PENDING or COMPLETED
   */
  void setStatus(Status value);

  /**
   * adds a comment to the end of the comments field, returns void
   * @param C the string need to be added
   */
  void addComment(String C);

  /**
   * returns a String containing all the comments, oldest first
   * @return a string containing all the comments
   */
  String getComments();

  /**
   * Compare this item with the one passed to it based on importance
   * if (this<other) return a negative number
   * if (this==other) return 0
   * if (this>other) return a positive number
   * @param other another item to be compared with this
   * @return the result of the comparison
   */
  public int compareTo(ToDoItem other);

  /**
   * return true of the two ToDoItem has same fields
   * @param other another ToDoItem object
   * @return true or false
   */
  public boolean equalTo(ToDoItem other);


}
