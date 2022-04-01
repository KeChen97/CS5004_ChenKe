import static org.junit.Assert.*;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * This is the test class for testing all the operations of ToDoItemSchool
 */
public class ToDoItemSchoolTest {
  ToDoItemSchool item1;
  ToDoItemSchool item2;
  ToDoItemSchool item3;


  @org.junit.Before
  public void setUp() throws Exception {
    List<String> comment1 = new LinkedList<>();
    comment1.add("5004lab");
    item1 = new ToDoItemSchool("lab", Status.UNSTARTED, ToDoItemCategory.SCHOOL, 9, comment1,3);
    item3 = new ToDoItemSchool("lab", Status.UNSTARTED, ToDoItemCategory.SCHOOL, 9, comment1,3);
    List<String> comment2 = new LinkedList<>();
    comment2.add("5004Homework");
    item2 = new ToDoItemSchool("Homework", Status.COMPLETED, ToDoItemCategory.SCHOOL, 2, comment2,2);


  }

  @org.junit.Test
  public void getName() {
    assertEquals("lab",this.item1.getName());
    assertEquals("Homework",this.item2.getName());
  }

  @org.junit.Test
  public void getCategory() {
    assertEquals(ToDoItemCategory.SCHOOL,this.item1.getCategory());
    assertEquals(ToDoItemCategory.SCHOOL,this.item2.getCategory());
  }

  @org.junit.Test
  public void getImportance() {
    assertEquals(9,this.item1.getImportance());
    assertEquals(2,this.item2.getImportance());
  }

  @org.junit.Test
  public void setImportance() {
    this.item1.setImportance(1);
    assertEquals(1,this.item1.getImportance());
    this.item2.setImportance(3);
    assertEquals(3,this.item2.getImportance());
  }

  @org.junit.Test
  public void getStatus() {
    assertEquals(Status.UNSTARTED,this.item1.getStatus());
    assertEquals(Status.COMPLETED,this.item2.getStatus());
  }

  @org.junit.Test
  public void setStatus() {
    this.item1.setStatus(Status.COMPLETED);
    assertEquals(Status.COMPLETED,this.item1.getStatus());
    this.item2.setStatus(Status.PENDING);
    assertEquals(Status.PENDING,this.item2.getStatus());
  }

  @org.junit.Test
  public void getComments() {
    List<String> comment3 = new LinkedList<>();
    comment3.add("5004lab");
    assertEquals(comment3.toString(),this.item1.getComments());
    List<String> comment4 = new LinkedList<>();
    comment4.add("5004Homework");
    assertEquals(comment4.toString(),this.item2.getComments());
  }

  @org.junit.Test
  public void addComment() {
    this.item1.addComment("lab08");
    List<String> comment3 = new LinkedList<>();
    comment3.add("5004lab"); comment3.add("lab08");
    assertEquals(comment3.toString(),this.item1.getComments());

    this.item2.addComment("Homework03");
    List<String> comment4 = new LinkedList<>();
    comment4.add("5004Homework"); comment4.add("Homework03");
    assertEquals(comment4.toString(),this.item2.getComments());
  }


  /**
   * based on importance
   */
  @org.junit.Test
  public void compareTo() {
    assertEquals(1,this.item1.compareTo(this.item2));
  }

  @org.junit.Test
  public void getUrgency() {
    assertEquals(3,this.item1.getUrgency());
    assertEquals(2,this.item2.getUrgency());
  }

  @org.junit.Test
  public void setUrgency() {
    this.item1.setUrgency(1);
    assertEquals(1,this.item1.getUrgency());
    this.item2.setUrgency(1);
    assertEquals(1,this.item2.getUrgency());
  }

  @org.junit.Test
  public void equalTo() {
    assertFalse(this.item1.equalTo(this.item2));
  }

  @org.junit.Test
  public void testToString() {
  }
}