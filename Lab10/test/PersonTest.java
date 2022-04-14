import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

/**
 * A JUnit test class for the Person class
 */
public class PersonTest {
 
  private Person john;
  private Person sally;
  private Person sally2;
  private Person mark;
 
  @Before
  public void setUp() {
    this.john = new Person("John", "Doe", 1945);
    this.sally = new Person("Sally", "Ride", 1951);
    this.sally2 = new Person("Sally", "Ride", 1951);
  }
 
  @Test
  public void testFirst() {
    assertEquals("John", this.john.getFirstName());
    assertEquals("Sally", this.sally.getFirstName());
  }

  @Test
  public void testGetYearOfBirth(){
    assertEquals(1945, this.john.getYearOfBirth());
    assertEquals(1951, this.sally.getYearOfBirth());
  }

  @Test
  public void testAge() {
    assertEquals(75, this.john.getAge());
    assertEquals(69, this.sally.getAge());
  }
 
  @Test
  public void testFullName() {
    assertEquals("John Doe", this.john.getFullName());
    assertEquals("Sally Ride", this.sally.getFullName());
  }

  @Test (expected = IllegalArgumentException.class)
  public void testReasonableFirstname (){
    this.mark = new Person("", "Miller", 1951);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testReasonableBirth (){
    this.mark = new Person("a", "a", 0);
  }

  @Test
  public void testToString() {
    assertEquals("John Doe, 1945, 75",this.john.toString());
  }
  @Test
  public void testSamePerson(){
    assertTrue(this.sally.samePerson(sally2));
  }

}