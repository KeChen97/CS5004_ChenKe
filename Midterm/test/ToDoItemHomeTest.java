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
    comment1.add("Clothes");
    item1 = new ToDoItemHome("Laundry", Status.UNSTARTED, ToDoItemCategory.HOME, 4, comment1);
    item3 = new ToDoItemHome("Laundry", Status.UNSTARTED, ToDoItemCategory.HOME, 4, comment1);
    List<String> comment2 = new LinkedList<>();
    comment2.add("bowls");
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
  public void getComments() {
    List<String> comment3 = new LinkedList<>();
    comment3.add("Clothes");
    assertEquals(comment3.toString(),this.item1.getComments());
    List<String> comment4 = new LinkedList<>();
    comment4.add("bowls");
    assertEquals(comment4.toString(),this.item2.getComments());
  }

  @Test
  public void addComment() {
    this.item1.addComment("pants");
    List<String> comment3 = new LinkedList<>();
    comment3.add("Clothes"); comment3.add("pants");
    assertEquals(comment3.toString(),this.item1.getComments());

    this.item2.addComment("plates");
    List<String> comment4 = new LinkedList<>();
    comment4.add("bowls"); comment4.add("plates");
    assertEquals(comment4.toString(),this.item2.getComments());
  }



  @Test
  public void compareTo() {
    assertEquals(1,this.item1.compareTo(this.item2));

  }


  @Test
  public void equalTo() {
    assertFalse(this.item1.equalTo(this.item2));
    assertTrue(this.item1.equalTo(this.item3));
  }

  @Test
  public void testToString() {
  }
}