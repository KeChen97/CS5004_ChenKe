import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class tttModelTest {
  tttModel model1;
  tttModel model2;
  tttModel model3;
  tttModel model4;
  tttModel model5;

  @Before
  public void setUp() throws Exception {
    model1 = new tttModelImpl(Player.X);
    model1.move(1, 1);  // X moved to center square
    //  ___|___|___
    //  ___|_X_|___
    //  ___|___|___

    model2 = new tttModelImpl(Player.X);
    model2.move(0, 0);  // X moved to upper left
    model2.move(2, 2); // O moved to bottom right
    //  _X_|___|___
    //  ___|___|___
    //  ___|___|_O_

    model3 = new tttModelImpl(Player.X);
    model3.move(0, 0);  // X moved to upper left
    model3.move(2, 2); // O moved to bottom right
    model3.move(1, 1); // X moved to center
    //  _X_|___|___
    //  ___|_X_|___
    //  ___|___|_O_

    model4 = new tttModelImpl(Player.X);
    model4.move(0, 0);  //X
    model4.move(1, 0);  // O
    model4.move(1, 1);  // X
    model4.move(2, 0); // O
    model4.move(2, 2); // X wins
    //  _X_|_O_|_O_
    //  ___|_X_|___
    //  ___|___|_X_

    model5 = new tttModelImpl(Player.O);
    model5.move(0, 0);  //O
    model5.move(1, 0);  // X
    model5.move(2, 0);  // O
    model5.move(0, 1);  // X
    model5.move(0, 2); // O
    model5.move(1, 1); // X
    model5.move(2, 1);  // O
    model5.move(2, 2);  // X
    model5.move(1, 2);  // O
    // This is a tie.
    //  _O_|_X_|_O_
    //  _X_|_X_|_O_
    //  _O_|_O_|_X_
  }

  @Test
  public void isGameOverTest() {
    assertFalse(model1.isGameOver());
    assertFalse(model2.isGameOver());
    assertFalse(model3.isGameOver());
    assertTrue(model4.isGameOver());
    assertTrue(model5.isGameOver());
  }

  @Test
  public void getWinnerTest() {
    assertEquals(model4.getWinner(), Player.X);
    assertEquals(model5.getWinner(), Player.NOBODY);
  }

  @Test (expected = IllegalStateException.class)
  public void getWinnerExceptionTest() {
    assertEquals(model1.getWinner(), Player.X);
    assertEquals(model2.getWinner(), Player.X);
    assertEquals(model3.getWinner(), Player.X);
  }

  @Test
  public void getMarkAtTest() {
  // Test end state of Board to match the moves that were made
    assertEquals(model1.getMarkAt(1, 1), Player.X);
    assertEquals(model2.getMarkAt(0, 0), Player.X);
    assertEquals(model3.getMarkAt(2, 2), Player.O);
    assertEquals(model4.getMarkAt(1, 0), Player.O);
  }

  @Test(expected = IndexOutOfBoundsException.class)
  public void getMarkAtExceptionTest() {
    assertEquals(model1.getMarkAt(3, 1), Player.X);
    assertEquals(model2.getMarkAt(-1, 0), Player.X);
  }

  @Test
  public void moveTest() {
    model1.move(0,1); //O's move
    assertEquals(model1.getMarkAt(0, 0), Player.O);
    model2.move(1,1); //X's move
    assertEquals(model2.getMarkAt(0, 0), Player.X);
  }

  @Test (expected = IllegalStateException.class)
  public void moveExceptionTest() {
    model4.move(0,0); //O's move, but X has already won
    model5.move(1,1); //X's move, but the game is already over
  }

  @Test
  public void nextPlayer() {
    assertEquals(Player.O,this.model1.nextPlayer());
    assertEquals(Player.X,this.model2.nextPlayer());
    assertEquals(Player.O,this.model3.nextPlayer());
  }

  @Test
  public void getGrid() {
    //initialize a grid
    Player[][] grid = new Player[3][3];
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        grid[i][j] = Player.NOBODY;
      }
    }
    grid[1][1] = Player.X;
    assertEquals(grid,this.model1.getGrid());

    grid[0][0] = Player.X;
    grid[2][2] = Player.O;
    assertEquals(grid,this.model3.getGrid());
  }

}