/**
 * This interface contains all operations that all types of items
 * should support.
 */
public interface ToDoList {

  /**
   * Adds an item to a ToDoList, returns void
   * @param item the ToDoItem will be added to this list
   */
  void addItem(ToDoItem item);

  /**
   * Gets item i from a ToDoList
   * @param i an int index of the list
   * @return the item at index i
   * @throws IllegalArgumentException if i<0 or i>size
   */
  ToDoItem getItem(int i) throws IllegalArgumentException;

  /**
   * Deletes item i from a ToDoList, return void
   * @param i an int index of the list
   * @throws IllegalArgumentException if i<0 or i>size
   */
  void deleteItem(int i) throws IllegalArgumentException;

  /**
   * Returns a ToDoList sorted by urgency
   * @return a ToDoList sorted by urgency
   */
  ToDoList sortByUrgency();

  /**
   * Returns a ToDoList sorted by importance.
   * @return a ToDoList sorted by importance.
   */
  ToDoList sortByImportance();

}
