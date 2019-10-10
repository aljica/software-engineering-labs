public class Rook extends Piece {

  public Rook(int i, int j, boolean isWhite) {
    super(i, j, isWhite);
    if (isWhite) {
      this.value = 2;
    } else {
      this.value = 3;
    }
  }

  public void addHorizontalMovesWestward(Piece[][] board) {
    for (int a = 1; a <= this.j; a++) {
      if (this.destinationSquareIsEmpty(board, this.i, this.j - a)) {
        this.addMove(0, -a);
      }
      else {
        if (this.destinationSquareHasOppositeColor(board, this.i, this.j - a)) {
          this.addMove(0, -a);
        }
        break;
      }
    }
  }

  // Upwards from white's point of view.
  public void addVerticalMovesUpwards(Piece[][] board) {
    // a = 1 and not a = 0 so we don't add this object's coordinates
    // as well. Remember, picking up an object and putting it back
    // in the same place will be handled by ChessGame.java in
    // the droppedOnSameSquare() method.
    for (int a = 1; a <= this.i; a++) {
      if (this.destinationSquareIsEmpty(board, this.i - a, this.j)) {
        this.addMove(-a, 0);
      }
      else {
        if (this.destinationSquareHasOppositeColor(board, this.i - a, this.j)) {
          this.addMove(-a, 0);
        }
        break; // We cannot move any further in that direction.
      }
    }
  }

  public void addHorizontalMovesEastward(Piece[][] board) {
    for (int a = 1; a < (8 - this.j); a++) {
      if (this.destinationSquareIsEmpty(board, this.i, this.j + a)) {
        this.addMove(0, a);
      }
      else {
        if (this.destinationSquareHasOppositeColor(board, this.i, this.j + a)) {
          this.addMove(0, a);
        }
        break;
      }
    }
  }

  public void addVerticalMovesDownwards(Piece[][] board) {
    for (int a = 1; a < (8 - this.i); a++) {
      if (this.destinationSquareIsEmpty(board, this.i + a, this.j)) {
        this.addMove(a, 0);
      }
      else {
        if (this.destinationSquareHasOppositeColor(board, this.i + a, this.j)) {
          this.addMove(a, 0);
        }
        break;
      }
    }
  }

  public void updateLegalMoves(Piece[][] board) {
    this.addVerticalMovesUpwards(board);
    this.addVerticalMovesDownwards(board);
    this.addHorizontalMovesEastward(board);
    this.addHorizontalMovesWestward(board);
  }

}
