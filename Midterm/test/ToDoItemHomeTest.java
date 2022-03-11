import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
/**
 * This is the test class for testing all the operations of ToDoItemHome
 */
public class ToDoItemHomeTest {
  ToDoItemHome item1;
  ToDoItemHome item2;
  ToDoItemHome item3;

  @Before
  public void setUp() throws Exception {
    List<String> comment1 = new LinkedList<>();
    comment1.add("Laundry");
    item1 = new ToDoItemHome("Laundry", Status.UNSTARTED, ToDoItemCategory.HOME, 4, comment1);
    item3 = new ToDoItemHome("Laundry", Status.UNSTARTED, ToDoItemCategory.HOME, 4, comment1);
    List<String> comment2 = new LinkedList<>();
    comment2.add("dishes");
    item2 = new ToDoItemHome("DishWashing", Status.COMPLETED, ToDoItemCategory.HOME, 2, comment2);

  }

  @Test
  public void getName() {
    assertEquals("Laundry",this.item1.getName());
    assertEquals("DishWashing",this.item2.getName());
  }

  @Test
  public void getCategory() {
    assertEquals(ToDoItemCategory.HOME,this.item1.getCategory());
    assertEquals(ToDoItemCategory.HOME,this.item2.getCategory());
  }

  @Test
  public void getImportance() {
    assertEquals(4,this.item1.getImportance());
    assertEquals(2,this.item2.getImportance());
  }

  @Test
  public void setImportance() {
    this.item1.setImportance(1);
    assertEquals(1,this.item1.getImportance());
    this.item2.setImportance(3);
    assertEquals(3,this.item2.getImportance());
  }

  @Test
  public void getStatus() {
    assertEquals(Status.UNSTARTED,this.item1.getStatus());
    assertEquals(Status.COMPLETED,this.item2.getStatus());
  }

  @Test
  public void setStatus() {
    this.item1.setStatus(Status.COMPLETED);
    assertEquals(Status.COMPLETED,this.item1.getStatus());
    this.item2.setStatus(Status.PENDING);
    assertEquals(Status.PENDING,this.item2.getStatus());
  }

  @Test
  public void addComment() {
  }

  @Test
  public void getComments() {
  }

  @Test
  public void compareTo() {

  }

  @Test
  public void testCompareTo() {
  }

  @Test
  public void equalTo() {
  }

  @Test
  public void testToString() {
  }
}