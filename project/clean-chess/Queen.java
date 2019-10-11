public class Queen extends Piece {

  public Queen(int i, int j, boolean isWhite) {
    super(i, j, isWhite);
    if (isWhite) {
      this.value = 8;
    } else {
      this.value = 9;
    }
  }

  public void addDiagonalMoves(Piece[][] board, int x, int range) {
    int left = this.j;
    int right = this.j;

    for (int a = 1; a < range; a++) {
      if ((8 - right) > 1) {
        if (this.destinationSquareOK(board, this.i + x*a, right + 1)) {
          right++;
        }
        else {
          right = 8; // Break for-loop for right.
        }
      }

      if (left > 0) {
        if (this.destinationSquareOK(board, this.i + x*a, left - 1)) {
          left--;
        }
        else {
          left = 0; // Break for-loop for left.
        }
      }
    }
  }

  public void addVertAndHorizMoves(Piece[][] board, int x, int y, int range) {
    for (int a = 1; a < range; a++) {
      if (this.destinationSquareOK(board, this.i + x*a, this.j + y*a)) {
        continue;
      }
      else {
        break;
      }
    }
  }

  public boolean destinationSquareOK(Piece[][] board, int a, int b) {
    if (this.destinationSquareIsEmpty(board, a, b)) {
      this.addMove(a, b);
      return true;
    }
    else {
      if (this.destinationSquareHasOppositeColor(board, a, b)) {
        this.addMove(a, b);
      }
    }
    return false;
  }

  public void addAllTheMoves(Piece[][] board, int x, int y) {
    Piece destSquare;
    for (int a = 1; a < 8; a++) {
      try {
        destSquare = board[this.i + x*a][this.j + y*a];
      }
      catch (ArrayIndexOutOfBoundsException e) {
        continue;
      }

      if (destSquare == null) {
        this.addMove(this.i + x*a, this.j + y*a);
      }
      else {
        if (destSquare.getIdentifier() % 2 != this.getIdentifier() % 2) {
          this.addMove(this.i + x*a, this.j + y*a);
        }
        break;
      }
    }
  }

  public void updateLegalMoves(Piece[][] board) {
    /*// Same as for Rook:
    //this.addVerticalMovesUpwards(board);
    this.addVertAndHorizMoves(board, -1, 0, this.i + 1);
    //this.addVerticalMovesDownwards(board);
    this.addVertAndHorizMoves(board, 1, 0, (8 - this.i));
    //this.addHorizontalMovesEastward(board);
    this.addVertAndHorizMoves(board, 0, 1, (8 - this.j));
    //this.addHorizontalMovesWestward(board);
    this.addVertAndHorizMoves(board, 0, -1, this.j + 1);

    // Same as for Bishop:
    // Downwards (Southeast and Southwest)
    this.addDiagonalMoves(board, 1, (8 - this.i));
    // Upwards (Northeast and Northwest)
    this.addDiagonalMoves(board, -1, (this.i + 1));*/

    this.addAllTheMoves(board, 1, 0); // All moves UPWARDS
    // because x = 1 and y = 0, check yourself
    this.addAllTheMoves(board, -1, 0); // all moves Downwards
    this.addAllTheMoves(board, 0, 1); // all moves horizontal right
    this.addAllTheMoves(board, 0, -1); // all moves LEFT

    this.addAllTheMoves(board, 1, 1); // SouthEast
    this.addAllTheMoves(board, 1, -1); // Southwest
    this.addAllTheMoves(board, -1, 1); // northeast
    this.addAllTheMoves(board, -1, -1); // northwest 
  }

}
