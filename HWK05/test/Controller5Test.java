import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

public class Controller5Test {
  private Calculator model;
  private Controller5 controller;
  private Readable in;
  private Appendable out;

  @org.junit.Before
  public void setUp() throws Exception {
   this.model = new Calculator();
  }

  @org.junit.Test
  public void goTest() throws IOException {
    String input = "1 2";
    Reader in = new StringReader(input);
    StringBuffer out = new StringBuffer();
    this.controller = new Controller5(in,out);

    controller.go(this.model);
    //assert what the controller wrote with the expected answer
    assertEquals("3\n", out.toString());
  }
}