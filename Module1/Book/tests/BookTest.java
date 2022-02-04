import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * A JUnit test class for the Book class
 */
public class BookTest {

  private Person author;
  private Book harryPotter;


  @Before
  public void setUp(){
    this.author  = new Person("J.K.","Rowling",1965);
    this.harryPotter = new Book ("Harry Potter", this.author, 24.99f);
  }

  @Test
  public void testTitle(){
    assertEquals("Harry Potter", this.harryPotter.getTitle());
  }

  @Test
  public void testAuthor(){
    assertEquals(this.author,this.harryPotter.getAuthor());
  }

  @Test
  public void testPrice(){
    assertEquals(24.99f,this.harryPotter.getPrice());
  }
}
