import static org.junit.Assert.*;

import org.junit.Test;

public class WListADTTest {
  private WListADT list1;

  @Test
  public void testWListADT(){
    //test isEmpty()
    WListADT list = new WListADTImpl();
    assertEquals("",list.toString());
    assertTrue(list.isEmpty());

    //test addIndex
    list.addIndex(0,"0");
    list.addIndex(1,"1");
    list.addIndex(2,"2");
    assertEquals("012",list.toString());

    assertFalse(list.isEmpty());

    //test getSize()
    //test get(int index)
    assertEquals(3,list.getSize());
    assertEquals("0",list.get(0));

    list.addIndex(3,"3");
    list.addIndex(4,"4");
    list.addIndex(5,"5");
    list.addIndex(6,"6");

    //test even words
    assertEquals("0246",list.evenWords().toString());
    //test odd words
    assertEquals("135",list.oddWords().toString());

    //test remove
    list.remove(1);
    assertEquals("023456",list.toString());
    //test remove
    list.remove(2);
    assertEquals("02456",list.toString());

    assertEquals(5,list.getSize());
    assertEquals("0",list.get(0));
  }

  @org.junit.Test
  public void addIndex() {
  }

  @org.junit.Test
  public void remove() {
  }

  @org.junit.Test
  public void get() {
  }

  @org.junit.Test
  public void getSize() {
  }

  @org.junit.Test
  public void isEmpty() {
  }

  @org.junit.Test
  public void oddWords() {
  }

  @org.junit.Test
  public void evenWords() {
  }
}