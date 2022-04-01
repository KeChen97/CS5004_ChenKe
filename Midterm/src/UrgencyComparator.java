import java.util.Comparator;

/**
 * Like compareTo, but based on the urgency
 *
 */
public class UrgencyComparator implements Comparator<ToDoItem> {
  @Override
  public int compare(ToDoItem item1, ToDoItem item2) {
    if ( (item1 instanceof ToDoItemHome) &&  (item2 instanceof ToDoItemHome)){
      return ImportanceComparator.compare(item1,item2);
    }

    int daysLeft1 = ((ToDoItemSchool) item1).getUrgency();
    int daysLeft2 = ((ToDoItemSchool) item2).getUrgency();
    //if item1 passed the due, its urgency is less, so that it should be sorted later
    if(daysLeft1<0 && daysLeft2 >= 0){
      return -1;
    }
    //if item2 passed the due, its urgency is less, so that it should be sorted later
    if(daysLeft1>=0 && daysLeft2 <0){
      return 1;
    }
    //if both items passed the due, their urgencies are equal
    if(daysLeft1<0 && daysLeft2<0){
      return 0;
    }
    //if no item pass the due, comparison based on the days left before ddl
    // if days left for item1 is less, it is more urgent
    if(daysLeft1>0 && daysLeft2>0 && daysLeft1<daysLeft2){
      return 1;
    }
    // if days left for item1 is more, it is less urgent
    else if(daysLeft1>0 && daysLeft2>0 && daysLeft1>daysLeft2){
      return -1;
    }
    else {
      return 0;
    }
  }
}
