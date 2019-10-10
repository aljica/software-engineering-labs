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
      if (this.destinationSquareOK(board, 0, -a)) {
        continue;
      }
      else {
        break;
      }
    }
  }


  public void addHorizontalMovesEastward(Piece[][] board) {
    for (int a = 1; a < (8 - this.j); a++) {
      if (this.destinationSquareOK(board, 0, a)) {
        continue;
      }
      else {
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
      if (this.destinationSquareOK(board, -a, 0)) {
        continue;
      }
      else {
        break;
      }
    }
  }

  public void addVerticalMovesDownwards(Piece[][] board) {
    for (int a = 1; a < (8 - this.i); a++) {
      if (this.destinationSquareOK(board, a, 0)) {
        continue;
      }
      else {
        break;
      }
    }
  }

  public boolean destinationSquareOK(Piece[][] board, int a, int b) {
    if (this.destinationSquareIsEmpty(board, this.i + a, this.j + b)) {
      this.addMove(a, b);
      return true;
    }
    else {
      if (this.destinationSquareHasOppositeColor(board, this.i + a, this.j + b)) {
        this.addMove(a, b);
        return true;
      }
    }
    return false;
  }

  public void updateLegalMoves(Piece[][] board) {
    this.addVerticalMovesUpwards(board);
    this.addVerticalMovesDownwards(board);
    this.addHorizontalMovesEastward(board);
    this.addHorizontalMovesWestward(board);
  }

}
