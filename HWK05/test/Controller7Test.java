import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.InputMismatchException;
import org.junit.Before;
import org.junit.ComparisonFailure;
import org.junit.Test;

/**
 * A "fake" calculator model just for testing the job of controller
 * it looks like the real model, but actually helps to infer what is being given to it
 * and what is being done with whatever it produces
 */
class MockModel implements CalModelInterface{
  private StringBuilder log;
  private final int uniqueCode;

  /**
   * Constructor of MockModel.
   * It stores input numbers in a log.
   * @param uniqueCode a unique number which is unlikely to be the true result of calculator
   */
  public MockModel(int uniqueCode) {
    this.log = new StringBuilder();
    this.uniqueCode = uniqueCode;
  }

  /**
   * The mock model of calculator
   * @param num1 the first number passed into this model
   * @param num2 the second number passed into this model
   * @return a uniqueCode which is unlikely to be the true result of calculator
   */
  @Override
  public int add(int num1, int num2) {
    log.append("Passed: " + num1 +" " + num2);
    log.append(System.lineSeparator());
    return this.uniqueCode;
  }

  public String getLog(){
    return log.toString();
  }
}


/**
 * A test not only for testing the combination of controller and model
 * But also for isolated controller
 */
public class Controller7Test {
  private Controller6 controllerCorrect;
  private Controller7 controllerWrong;
  private Calculator realModel;
  private MockModel mockModel;
  Readable in;
  Appendable out;

  @Before
  public void setUp() throws Exception {
    this.realModel = new Calculator();
    this.mockModel = new MockModel(-12345);
    this.out = new StringBuffer();
  }

  /**
   * This test is for the combination of controller7 and model
   * it should return a false pass even though there is bug in controller7
   * @throws IOException
   */
  @Test
  public void goTestController7 () throws IOException {
    String input = "+ 10 20 q";
    Reader in = new StringReader(input);
    this.controllerWrong = new Controller7(in,out);
    controllerWrong.go(this.realModel);
    assertEquals("30\n",out.toString());
  }

  /**
   * This test is for testing the isolated controller7 with bug, it should return a failure
   * @throws IOException
   */
  @Test (expected = ComparisonFailure.class)
  public void goTestWrongController() throws IOException {
    String input = "+ 1 2 + 3 4 + 5 6 q";
    Reader in = new StringReader(input);
    this.controllerWrong = new Controller7(in,out);

    StringBuilder log = new StringBuilder(); //log for mock model
    controllerWrong.go(this.mockModel);
    // 1. verify that the mock model got the number 1 and 2, 3 and 4, 5 and 6
    // if this assert fails, it means that the controller is not passing the inputs we gave, to the model
    String expectedInput = "Passed: 1 2\nPassed: 3 4\nPassed: 5 6\n";
    assertEquals(expectedInput,this.mockModel.getLog());//inputs reached the model correctly
    // 2. verify that the controller transmitted whatever the model gave it to the out
    String expectedOutput = "-12345\n-12345\n-12345\n";
    assertEquals(expectedOutput,out.toString());//output of model transmitted correctly
  }

  /**
   * This test is for testing the isolated correct controller6
   * @throws IOException
   */
  @Test
  public void goTestCorrectController() throws IOException {
    out = new StringBuffer();
    String input = "+ 1 2 + 3 4 + 5 6 q";
    Reader in = new StringReader(input);
    this.controllerCorrect = new Controller6(in,out);

    StringBuilder log = new StringBuilder(); //log for mock model
    controllerCorrect.go(this.mockModel);
    // 1. verify that the mock model got the number 1 and 2, 3 and 4, 5 and 6
    // if this assert fails, it means that the controller is not passing the inputs we gave, to the model
    String expectedInput = "Passed: 1 2\nPassed: 3 4\nPassed: 5 6\n";
    assertEquals(expectedInput,this.mockModel.getLog());//inputs reached the model correctly
    // 2. verify that the controller transmitted whatever the model gave it to the out
    String expectedOutput = "-12345\n-12345\n-12345\n";
    assertEquals(expectedOutput,out.toString());//output of model transmitted correctly

    // 3. verify that the controller does not try to pass any additional inputs after the "q" token has been received from the test string.
    StringBuffer out2 = new StringBuffer();
    String input2 = "+ 1 2 + 3 4 + 5 6 q 7 8";
    Reader in2 = new StringReader(input);
    Controller6 controllerCorrect2 = new Controller6(in2,out2);
    MockModel mockModel2 = new MockModel(-12345);
    StringBuilder log2 = new StringBuilder(); //log for mock model
    controllerCorrect2.go(mockModel2);
    assertEquals(expectedInput,mockModel2.getLog());//inputs reached the model correctly
    assertEquals(expectedOutput,out2.toString());//output of model transmitted correctly

    StringBuffer out3 = new StringBuffer();
    String input3 = "+ 10 20 + 30 40 q 50 60";
    Reader in3 = new StringReader(input3);
    Controller6 controllerCorrect3 = new Controller6(in3,out3);
    MockModel mockModel3 = new MockModel(-12345);
    StringBuilder log3 = new StringBuilder(); //log for mock model
    controllerCorrect3.go(mockModel3);
    String expectedInput3 = "Passed: 10 20\nPassed: 30 40\n";
    String expectedOutput3 = "-12345\n-12345\n";
    assertEquals(expectedInput3,mockModel3.getLog());//inputs reached the model correctly
    assertEquals(expectedOutput3,out3.toString());//output of model transmitted correctly

    //4. verify invalid input such as a float when an int is required, or another operator (such as *) when only + is supported
    StringBuffer out4 = new StringBuffer();
    String input4 = "* * + 10 20 q";
    Reader in4 = new StringReader(input4);
    Controller6 controllerCorrect4 = new Controller6(in4,out4);
    MockModel mockModel4 = new MockModel(-12345);
    StringBuilder log4 = new StringBuilder(); //log for mock model
    controllerCorrect4.go(mockModel4);
    String expectedInput4 = "Passed: 10 20\n";  // the controller will ignore the input which is not the case "+"
    String expectedOutput4 = "-12345\n";
    assertEquals(expectedInput4,mockModel4.getLog());//inputs reached the model correctly
    assertEquals(expectedOutput4,out4.toString());//output of model transmitted correctly
  }

  /**
   * This test is for testing invalid input, it should return InputMismatchException
   * @throws IOException
   */
  @Test (expected = InputMismatchException.class)
  public void goTestInvaidInput() throws IOException {
    out = new StringBuffer();
    String input = "+ 1 1.1 q"; // 1.1 is not an integer, so that it is an invalid input
    Reader in = new StringReader(input);
    this.controllerCorrect = new Controller6(in,out);
    controllerCorrect.go(this.mockModel);
  }

}