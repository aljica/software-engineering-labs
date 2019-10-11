public class Bishop extends Piece {

  public Bishop(int i, int j, boolean isWhite) {
    super(i, j, isWhite);
    if (isWhite) {
      this.value = 6;
    } else {
      this.value = 7;
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

  public void addMoves(Piece[][] board, int x, int range) {
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
    /*// Downwards (Southeast and Southwest)
    this.addMoves(board, 1, (8 - this.i));
    // Upwards (Northeast and Northwest)
    this.addMoves(board, -1, (this.i + 1));*/

    this.addAllTheMoves(board, 1, 1); // SouthEast
    this.addAllTheMoves(board, 1, -1); // Southwest
    this.addAllTheMoves(board, -1, 1); // northeast
    this.addAllTheMoves(board, -1, -1); // northwest 
  }

}
