public class Rook extends Piece {

  public Rook(int i, int j, boolean isWhite) {
    super(i, j, isWhite);
    if (isWhite) {
      this.value = 2;
    } else {
      this.value = 3;
    }
  }

  // Upwards from white's point of view.
  private void addVerticalMovesUpwards(Piece[][] board) {
    // a = 1 and not a = 0 so we don't add this object's coordinates
    // as well. Remember, picking up an object and putting it back
    // in the same place will be handled by ChessGame.java in
    // the droppedOnSameSquare() method.
    for (int a = 1; a <= this.i; a++) {
      this.addMove(this.i - a, this.j);
    }
  }

  private void addVerticalMovesDownwards(Piece[][] board) {
    /*
    if ((8 - this.i) == 1) {
    // Might need this because for-loop below might fail otherwise
      return;
    }
    */
    for (int a = 1; a < (8 - this.i); a++) {
      this.addMove(this.i + a, this.j);
    }
  }

  public void updateLegalMoves(Piece[][] board) {
    this.addVerticalMovesUpwards(board);
    this.addVerticalMovesDownwards(board);
  }

}
