import java.util.LinkedList;
import java.util.List;

public class ToDoListImpl implements ToDoList {

   List<ToDoItem> list;

  /**
   * Constructs a ToDOList  and initializes it to give a list of ToDoItems
   *
   * @param list the list of ToDoItems
   */
  public ToDoListImpl(List<ToDoItem> list) {
    this.list = (List<ToDoItem>) list;
  }

  public ToDoListImpl() {
    this.list =  new LinkedList<ToDoItem>();
  }

  @Override
  public void addItem(ToDoItem item) {
    this.list.add(item);
  }

  @Override
  public ToDoItem getItem(int i) throws IllegalArgumentException {
    if (i < 0 || i > this.list.size()) {
      throw new IllegalArgumentException("Index i should be in the list size range");
    }
    return this.list.get(i);
  }

  @Override
  public void deleteItem(int i) throws IllegalArgumentException {
    if (i < 0 || i > this.list.size()) {
      throw new IllegalArgumentException("Index i should be in the list size range");
    }
    this.list.remove(i);
  }

  @Override
  public List<ToDoItem> sortByUrgency() {
    this.list.sort(new UrgencyComparator());
    return this.list;
  }

  @Override
  public List<ToDoItem> sortByImportance() {
    this.list.sort(new ImportanceComparator());
    return this.list;
  }

  @Override
  public String toString() {
    String s = "The to do list is: \n";
    for (ToDoItem t : list) {
      s = s + t.toString();
    }
    return s;
  }
}
