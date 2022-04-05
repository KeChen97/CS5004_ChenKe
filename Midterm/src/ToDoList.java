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
   * Returns a ToDoList sorted by urgency,
   * if urgency is negative, which means it past the due，so that it will be sorted later
   * 0 means it is due today.Positive means you have more days to complete it.
   * Therefore, if the urgency is 0 or positive, it will be sorted in ascending order. if it is negative, it will be in later position than those urgencies are not negative
   * @return a ToDoList sorted by urgency
   */
  ToDoList sortByUrgency();

  /**
   * Returns a ToDoList sorted by importance.
   * @return a ToDoList sorted by importance.
   */
  ToDoList sortByImportance();

}
