import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PetRockTest {
  private PetRock rocky;
  private PetRock rocky2;
  private PetRock rocky3;

  @Before
  public void setUp()  {
    this.rocky = new PetRock("Rocky",2.1);
    this.rocky2 = new PetRock("Rocky2",0.0);
    this.rocky3 = new PetRock("Rocky",2.1);
  }

  @Test
  public void getName() {
    assertEquals("Rocky",this.rocky.getName());
  }

  @Test
  public void getWeight() {
    assertEquals(2.1,this.rocky.getWeight(),0.01);
  }

  @Test  (expected = IllegalArgumentException.class)
  public void testEmpty() {
    this.rocky2 = new PetRock("",0.0);
  }

  @Test
  public void testUnhappyToStart() {
    assertFalse(rocky.isHappy());
  }

  @Test
  public void testHappyAfterPlay() {
    this.rocky.playWithRock();
    assertTrue(this.rocky.isHappy());
  }

  @Test (expected = IllegalArgumentException.class)
  public void testPrint() {
    this.rocky2.getHappyMessage();
  }

  @Test
  public void testMessage() {
    this.rocky2.playWithRock();
    String msg = this.rocky2.getHappyMessage();
    assertEquals("I am happy.",msg);
  }

  @Test
  public void testToString() {
    assertEquals("PetRock: name = Rocky, weight = 2.1g, happy? false", this.rocky.toString());
  }

  @Test
  public void isSameRock() {
    assertFalse(this.rocky.isSameRock(this.rocky2));
    assertTrue(this.rocky.isSameRock(this.rocky3));
  }

  @Test
  public void isSameRock2() {
    assertSame(this.rocky,this.rocky);
    assertNotSame(this.rocky,this.rocky2);
    assertNotSame(this.rocky,this.rocky3);
  }
}