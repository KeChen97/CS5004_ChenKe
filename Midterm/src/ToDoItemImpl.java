import java.util.List;

/**
 * This is the concrete class for ToDoItem, containing all the operations
 */
public abstract class ToDoItemImpl extends ToDoItemAbstract {
  protected Status status;
  protected ToDoItemCategory category;
  protected int importance;
  protected List<String> comments;

  /**
   * Constructs an abstract ToDoItem  and initializes it
   *
   * @param name       A string name of this todoitem
   * @param status     UNSTARTED, PENDING or COMPLETED
   * @param category   SCHOOL, HOME, WORK, VOLUNTEER or OTHER.
   * @param importance an integer from 0 - 9
   * @param comments   a list of String containing all the string comments
   */
  public ToDoItemImpl(String name, Status status,
                      ToDoItemCategory category, int importance, List<String> comments) {
    super(name);
    this.status = status;
    this.category = category;
    this.importance = importance;
    this.comments = comments;
  }


  @Override
  public String getName() {
    return name;
  }

  @Override
  public Enum getCategory() {
    return this.category;
  }

  @Override
  public int getImportance() {
    return this.importance;
  }

  @Override
  public void setImportance(int importance) {
    this.importance = importance;
  }

  @Override
  public Enum getStatus() {
    return this.status;
  }

  @Override
  public void setStatus(Status value) {
    this.status = value;
  }

  @Override
  public void addComment(String C) {
    this.comments.add(C);
  }

  @Override
  public String getComments() {
    return this.comments.toString();
  }

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

}
