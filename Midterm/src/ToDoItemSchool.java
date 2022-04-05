import java.util.List;

/**
 * Concrete class for ToDoItemSchool,which category is SCHOOL
 */
public class ToDoItemSchool extends ToDoItemImpl {

  private int urgency;

  /**
   * Constructs an abstract ToDoItem  and initializes it
   *
   * @param name       A string name of this todoitem
   * @param status     UNSTARTED, PENDING or COMPLETED
   * @param category   SCHOOL, HOME, WORK, VOLUNTEER or OTHER.
   * @param importance an integer from 0 - 9
   * @param comments   a list of String containing all the string comments
   * @param urgency    Negative integer means the item is past due. 0 means it is due today.
   *                   Positive means you have more days to complete it.
   */
  public ToDoItemSchool(String name, Status status, ToDoItemCategory category, int importance,
      List<String> comments, int urgency) {
    super(name, status, ToDoItemCategory.SCHOOL, importance, comments);
    this.urgency = urgency;
  }

  /**
   * returns the number of days before it is due
   *
   * @return an integer. A negative value is allowed and means it is past due.
   */
  public int getUrgency() {
    return this.urgency;
  }

  /**
   * Set a new integer d as the number of days before it is due
   *
   * @param d a integer means the number of days before it is due
   */
  public void setUrgency(int d) {
    this.urgency = d;
  }


  /**
   * return true of the two ToDoItemSchool has same fields
   *
   * @param other another ToDoItemSchool object
   * @return true or false
   */
  @Override
  public boolean equalTo(ToDoItem other) {
    if (other == null) {
      return false;
    }
    if (!(other instanceof ToDoItemSchool)) {
      return false;
    }
    if (name.equals(other.getName()) && this.status == other.getStatus()
        && this.category == other.getCategory()
        && this.importance == other.getImportance() && this.getComments()
        .equals(other.getComments())
        && this.urgency == ((ToDoItemSchool) other).getUrgency()) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * Display this toDoItem and all of its fields
   *
   * @return a string displays this toDoItem and all of its fields
   */
  @Override
  public String toString() {
    String s = "Item:" + name + " Status:" + this.status + " Category:" + this.category
        + " Importance:" + this.importance + " Days left before deadline:" + this.urgency
        + " Comments:" + this.getComments();
    s = s + "\n";
    return s;
  }

  /**
   * Generate hash code for this ToDoItemSchool
   *
   * @return int hashcode for this ToDoItemSchool
   */
  @Override
  public int hashCode() {
    int a = name.hashCode();
    int b = status.hashCode();
    int c = category.hashCode();
    int hash = importance + (a * b + c) * urgency;
    return hash;
  }


}
