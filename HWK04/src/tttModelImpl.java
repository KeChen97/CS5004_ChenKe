/**
 * This is the concrete class implements all the operations of TicTacToe tttModel
 */
public class tttModelImpl implements tttModel {

  Player[][] grid;
  Player nextPlayer;
  Player winner;

  /**
   * Initialize the TicTacToe Model with a grid and the first player
   *
   * @param nextPlayer input the player in the first round: X or O
   * @throws IllegalStateException if nextPlayer is NOBODY. Because it has to be X or O's turn.
   */
  public tttModelImpl(Player nextPlayer) throws IllegalStateException {
    //Initialize every cell in this 3X3 grid with NOBODY
    this.grid = new Player[3][3];
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        this.grid[i][j] = Player.NOBODY;
      }
    }
    //The player in the first round has to be X or O, if it is not, throws an illegalStateException
    if (nextPlayer == Player.NOBODY) {
      throw new IllegalStateException();
    }
    this.nextPlayer = nextPlayer;
    this.winner = Player.NOBODY;
  }

  @Override
  public void move(int column, int row) throws IllegalStateException, IndexOutOfBoundsException {
    if (column < 0 || column > 2 || row < 0 || row > 2) {
      throw new IndexOutOfBoundsException();
    }
    if(this.isGameOver() || this.grid[column][row] != Player.NOBODY){
      throw new IllegalStateException();
    }

    this.grid[column][row] = this.nextPlayer;
    if (this.nextPlayer == Player.X){
      this.nextPlayer = Player.O;
    }
    else{
      this.nextPlayer = Player.X;
    }
  }

  @Override
  public Player nextPlayer() throws IllegalStateException {
    if (isGameOver()) {
      throw new IllegalStateException();
    }
    return this.nextPlayer;
  }

  @Override
  public Player[][] getGrid() {
    return this.grid;
  }

  @Override
  public Player getMarkAt(int column, int row) throws IndexOutOfBoundsException {
    if (column < 0 || column > 2 || row < 0 || row > 2) {
      throw new IndexOutOfBoundsException();
    }
    return this.grid[column][row];
  }

  @Override
  public boolean isGameOver() {
    //check if there is a winner at first, if there is, the game is over
    //check every diagonal
    if (this.grid[0][0] == this.grid[1][1] && this.grid[1][1] == this.grid[2][2]
        && this.grid[1][1] != Player.NOBODY) {
      this.winner = this.grid[1][1];
      return true;
    }
    if (this.grid[2][0] == this.grid[1][1] && this.grid[1][1] == this.grid[0][2]
        && this.grid[1][1] != Player.NOBODY) {
      this.winner = this.grid[1][1];
      return true;
    }

    for (int i = 0; i < 3; i++) {
      //check every column
      if (this.grid[i][0] == this.grid[i][1] && this.grid[i][1] == this.grid[i][2]
          && this.grid[i][0] != Player.NOBODY) {
        this.winner = this.grid[i][0];
        return true;
      }
      //check every row
      if (this.grid[0][i] == this.grid[1][i] && this.grid[1][i] == this.grid[2][i]
          && this.grid[0][i] != Player.NOBODY) {
        this.winner = this.grid[0][i];
        return true;
      }
    }

    //No one won for now
    // if there is at least one cell is NOBODY, the game is not over
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        if (this.grid[i][j] == Player.NOBODY) {
          return false;
        }
      }
    }
    //Otherwise, it is a tie
    return true;
  }

  @Override
  public Player getWinner() throws IllegalStateException {
    if (!this.isGameOver()) {
      throw new IllegalStateException();
    }
    return this.winner;
  }
}
