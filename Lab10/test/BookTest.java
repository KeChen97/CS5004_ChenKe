import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

/**
 * A JUnit test class for the Book class
 */
public class BookTest {

  private Person author;
  private Book harryPotter;


  @Before
  public void setUp() {
    this.author = new Person("J.K.", "Rowling", 1965);
    this.harryPotter = new Book("Harry Potter", this.author, 20, TypeOfBook.HARDCOVER, GenreOfBook.ADVENTURE);
  }

  @Test
  public void testTitle() {
    assertEquals("Harry Potter", this.harryPotter.getTitle());
  }

  @Test
  public void testAuthor() {
    assertEquals(this.author, this.harryPotter.getAuthor());
  }

  @Test
  public void testPrice() {
    assertEquals(20.0f, this.harryPotter.getPrice(), 0.01);
  }

  @Test
  public void testIllegalDicsount() {
    float discountedPrice;
    try {
      discountedPrice = harryPotter.salePrice(20);
      assertEquals(16.0f, discountedPrice, 0.01);
    } catch (IllegalArgumentException e) {
      fail("An exception should not be thrown.");
    }
    try {
      discountedPrice = harryPotter.salePrice(-10);
      fail("An exception should be thrown.");
    } catch (IllegalArgumentException e) {
    }
  }


  @Test
  public void testToString() {
    String name =  "Title: Harry Potter\n" +
                   "Author: J.K. Rowling\n" +
                  "Type: Hard Cover\n" +
                  "Genre: Adventure\n" +
                  "Price: 20.00" + "\n";
    assertEquals(name, this.harryPotter.toString());

  }
}
