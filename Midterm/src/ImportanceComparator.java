import java.util.Comparator;
/**
 * Like compareTo, but based on the importance
 *
 */
public class ImportanceComparator implements Comparator<ToDoItem> {
  @Override
  public static int compare(ToDoItem item1, ToDoItem item2) {
    int importance1 = item1.getImportance();
    int importance2 = item2.getImportance();
    if(importance1<importance2){
      return -1;
    }
    else if(importance1>importance2){
      return 1;
    }
    else {
      return 0;
    }
  }
}
