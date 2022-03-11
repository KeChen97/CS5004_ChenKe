import java.util.List;

/**
 * Concrete class for ToDoItemHome,which category is HOME
 */
public class ToDoItemHome extends ToDoItemImpl {

  /**
   * Constructs an abstract ToDoItem  and initializes it
   *
   * @param name       A string name of this todoitem
   * @param status     UNSTARTED, PENDING or COMPLETED
   * @param category   HOME
   * @param importance an integer from 0 - 9
   * @param comments   a list of String containing all the string comments
   */
  public ToDoItemHome(String name, Status status, ToDoItemCategory category, int importance,
      List<String> comments) {
    super(name, status, ToDoItemCategory.HOME, importance, comments);
  }

  /**
   * home items always sort by importance regardless of which type of sorting is requested at the
   * ToDoList level. if (this<other) return a negative number if (this==other) return 0 if
   * (this>other) return a positive number
   *
   * @param other another item to be compared with this
   * @return the result of the comparison
   */
  @Override
  public int compareTo(ToDoItem other) {
    if (this.importance < other.getImportance()) {
      return -1;
    } else if (this.importance > other.getImportance()) {
      return 1;
    } else {
      return 0;
    }
  }

  /**
   * return true of the two ToDoItemHome has same fields
   *
   * @param other another ToDoItemHome object
   * @return true or false
   */
  @Override
  public boolean equalTo(ToDoItem other) {
    if (!(other instanceof ToDoItemSchool)) {
      return false;
    }
    if (name.equals(other.getName()) && this.status == other.getStatus()
        && this.category == other.getCategory()
        && this.importance == other.getImportance() && this.comments.equals(other.getComments())) {
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
    String s = "Item:" + name + " Status: " + this.status + " Category:" + this.category
        + " Importance:" + this.importance + " Comments: " + this.comments.toString();
    s = s + "\n";
    return s;
  }

  /**
   * Generate hash code for this ToDoItemHome
   *
   * @return int hashcode for this ToDoItemHome
   */
  @Override
  public int hashCode() {
    int a = name.hashCode();
    int b = status.hashCode();
    int c = category.hashCode();
    int hash = importance * (a * b + c);
    return hash;
  }

}
