import static org.junit.Assert.*;

import java.io.IOException;
import java.io.StringReader;
import java.io.Reader;
import org.junit.Before;
import org.junit.Test;

public class Controller6Test {
  private Controller6 controller;
  private Calculator model;
  Readable in;
  Appendable out;

  @Before
  public void setUp() throws Exception {
    this.model = new Calculator();
  }

  // Test Receiving multiple inputs
  @Test
  public void goTest() throws IOException {
    String input = "+ 1 2 + 3 4 + 5 6 q";
    Reader in = new StringReader(input);
    StringBuffer out = new StringBuffer();
    this.controller = new Controller6(in,out);
    controller.go(this.model);
    assertEquals("3\n7\n11\n",out.toString());
  }
}