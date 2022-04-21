import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * This is the JUnit test class for GenericStack
 * This test will test three data types: Integer, Character, String
 */
public class GenericStackTest {
  private GenericStack stackInt;
  private GenericStack stackChar;
  private GenericStack stackString;

  @org.junit.Before
  public void setUp() throws Exception {
    stackInt = new GenericStack<>();
    stackChar = new GenericStack<>();
    stackString = new GenericStack<>();

    stackInt.push(1);
  }

  @Test
  public void emptyTest() {
    assertTrue(stackString.empty());
    assertTrue(stackChar.empty());
    assertFalse(stackInt.empty());
  }

  @org.junit.Test
  public void pushTest() {
    stackString.push("Hello");
    assertFalse(stackString.empty());
    stackChar.push('A');
    assertFalse(stackChar.empty());
  }

  @org.junit.Test (expected = IllegalArgumentException.class)
  public void topTestIfEmpty() {
    assertEquals("",stackString.top());
    assertEquals("",stackChar.top());
  }

  @org.junit.Test
  public void topTest() {
    assertEquals(1,stackInt.top());

    stackString.push("Hello");
    assertEquals("Hello",stackString.top());
    stackString.push("World");
    assertEquals("World",stackString.top());
    stackString.push("!");
    assertEquals("!",stackString.top());

    stackChar.push('A');
    assertEquals('A',stackChar.top());
    stackChar.push('B');
    assertEquals('B',stackChar.top());
  }

  @org.junit.Test (expected = IllegalArgumentException.class)
  public void popTestIfEmpty() {
    stackString.pop();
    stackChar.pop();
  }

  @org.junit.Test
  public void popTest() {
    assertFalse(stackInt.empty());
    stackInt.pop();
    assertTrue(stackInt.empty());

    assertTrue(stackString.empty());
    stackString.push("Hello");
    stackString.pop();
    assertTrue(stackString.empty());

    assertTrue(stackChar.empty());
    stackChar.push("S");
    stackChar.pop();
    assertTrue(stackChar.empty());
  }

  @org.junit.Test
  public void testToString() {
    stackInt.push(2);
    stackInt.push(3);
    stackInt.push(4);
    String s1 = "Stack = 1 2 3 4 \n";
    assertEquals(s1,stackInt.toString());

    stackString.push("Object");
    stackString.push("Oriented");
    stackString.push("Design");
    String s2 = "Stack = Object Oriented Design \n";
    assertEquals(s2,stackString.toString());

    stackChar.push('A');
    stackChar.push('B');
    stackChar.push('C');
    String s3 = "Stack = A B C \n";
    assertEquals(s3,stackChar.toString());
  }
}