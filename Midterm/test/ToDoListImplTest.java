import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class ToDoListImplTest {
  ToDoListImpl list1;
  ToDoListImpl list2;
  ToDoListImpl list3;
  ToDoItemHome item1;
  ToDoItemHome item2;
  ToDoItemHome item3;
  ToDoItemSchool item4;
  ToDoItemSchool item5;
  ToDoItemSchool item6;

  @Before
  public void setUp() throws Exception {
    List<String> comment1 = new LinkedList<>();
    comment1.add("Clothes");
    this.item1 = new ToDoItemHome("Laundry", Status.UNSTARTED, ToDoItemCategory.HOME, 4, comment1);
    this.item2 = new ToDoItemHome("Trash", Status.UNSTARTED, ToDoItemCategory.HOME, 1, comment1);
    List<String> comment2 = new LinkedList<>();
    comment2.add("Bowls");
    this.item3 = new ToDoItemHome("DishWashing", Status.COMPLETED, ToDoItemCategory.HOME, 2, comment2);

    List<String> comment3 = new LinkedList<>();
    comment1.add("5004lab");
    this.item4 = new ToDoItemSchool("lab1", Status.UNSTARTED, ToDoItemCategory.SCHOOL, 9, comment1,3);
    this.item5 = new ToDoItemSchool("lab2", Status.UNSTARTED, ToDoItemCategory.SCHOOL, 0, comment1,3);
    List<String> comment4 = new LinkedList<>();
    comment2.add("5004Homework");
    this.item6 = new ToDoItemSchool("Homework", Status.COMPLETED, ToDoItemCategory.SCHOOL, 2, comment2,2);


    this.list1 = new ToDoListImpl();
    this.list1.addItem(this.item1);
    this.list2 = new ToDoListImpl();
    this.list2.addItem(this.item4);


  }

  @Test
  public void getItem() {
    assertEquals(item1,this.list1.getItem(0));
    assertEquals(item4,this.list1.getItem(0));
  }


  @Test
  public void addItem() {
    list1.addItem(item3);
    assertEquals(item3,this.list1.getItem(1));
    list2.addItem(item3);
    assertEquals(item3,this.list2.getItem(1));
  }



  @Test (expected = IndexOutOfBoundsException.class)
  public void deleteItem() {
    list1.addItem(item3);
    assertEquals(item3,this.list1.getItem(1));
    list1.deleteItem(1);
    assertEquals(item3,this.list1.getItem(1));
  }

  @Test
  public void testToString() {
    String s = "The to do list is: \n";
    s=s+ this.item1.toString();
    assertEquals(s,this.list1.toString());

    String s2 = "The to do list is: \n";
    s=s2+ this.item4.toString();
    assertEquals(s,this.list2.toString());

  }
  @Test
  public void sortByUrgency() {
    this.list2.addItem(this.item5);
    this.list2.addItem(this.item6);
    String s = "The to do list is: \n";
    s = s + this.item4.toString() + this.item5.toString() + this.item6.toString();
    assertEquals(s,this.list2.toString());
   // this.list2.sortByUrgency();
  }

  @Test
  public void sortByImportance() {
    this.list1.addItem(item2);
    this.list1.addItem(item3);
    String s = "The to do list is: \n";
    s = s + this.item1.toString() + this.item2.toString() + this.item3.toString();
    assertEquals(s,this.list1.toString());
    this.list1.sortByImportance();

    String s2 = "The to do list is: \n";
    s = s + this.item2.toString() + this.item3.toString() + this.item1.toString();
    assertEquals(s2,this.list1.toString());
  }


}