public interface tttModel {
    /**
     * Places an X or O mark in the specified cell. Whether it places an X
     * or O depends on which player's turn it is.
     *
     * @param column the column of the cell
     * @param row    the row of the cell
     * @throws IllegalStateException if the game is over, or if there is
     * already a mark in the cell.
     * @throws IndexOutOfBoundsException if the cell is out of bounds.
     * Legal values for column and row are 0, 1, 2
     */
    void move(int column, int row) throws IllegalStateException, IndexOutOfBoundsException;

    /** Whose turn is it?
    // In order to allow the client to find out whose turn it is, we
    // also have several choices. One simple way is a boolean method
    // or methods to ask if it is a particular player’s turn:

    // Even within the above approach, we have a design choice: What
    // should the methods do if called once the game is over? They
    // could return false, or they could throw an exception; either
    // way, we ought to document this choice. Which do you prefer, and
    // why?

    // Another way would be to have the method return some
    // representation of the player whose turn it is, like so:

    /**
     * Returns the player whose turn is next.
     *
     * @return the next player
     * @throws IllegalStateException if the game is over
     */
    Player nextPlayer() throws IllegalStateException;

    // Getting the grid

    // We need to offer a way for a client of our model to get the
    // current state of the game. We can write a method that simply
    // returns the board. However we must be careful not to return the
    // actual reference, because the client can then mutate it to
    // directly change the model! (Imagine someone else wrote the
    // controller and the view, and their controller got the board
    // from your model and then directly manipulated it to win the
    // game!)

    /**
     * Returns a two-dimensional array representing the state of the
     * grid. The first index is the column and the second the row.
     * The resulting array is newly allocated and unconnected to the model;
     * thus, mutating it will have no effect on the model or subsequent
     * calls to getGrid(). Important not to return a raw reference to the grid
     *
     * @return a copy of the grid
     */
    Player[][] getGrid();

    // Alternatively, rather than return some representation of the
    // grid, we could provide some means of querying it:

    /**
     * Returns the Player whose mark is in the cell at the given
     * coordinates, or {@code null} if that cell is empty.
     *
     * @param column the column of the cell
     * @param row    the row of the cell
     * @return a {@code Player} or {@code null}
     * @throws IndexOutOfBoundsException if the cell is out of bounds.
     */
    Player getMarkAt(int column, int row) throws IndexOutOfBoundsException;

    // Finding out the results

    // Way to find out when the game is over and
    // who, if anyone, won. Unlike the previous operations, there
    // isn’t much room in this design space (though there are a few
    // sensible alternatives). We will have one method to ask whether
    // the game is over and another to ask who has won:

    /**
     * Determines whether the game is over.
     *
     * @return boolean, true iff the game is over, either because of a win or
     * because no squares are left empty
     */
    boolean isGameOver();

    /**
     * Returns the winner of the game, or NOBODY if the game is a
     * tie.
     *
     * @return the winner or  null (for a tie)
     * @throws IllegalStateException if the game isn't over
     */
    Player getWinner() throws IllegalStateException;
}
