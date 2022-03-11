import java.util.List;

/**
 * This is the abstract class for ToDOItem
 * a ToDoItem has a name, category(school/home), status, toDoCategory, importance and comments
 */
public abstract class ToDoItemAbstract implements ToDoItem{
  protected String name;

  public ToDoItemAbstract(String name) {
    this.name = name;
  }

}
