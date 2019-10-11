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

  public void checkDiagonalMoves(Piece[][] board) {
    int left = this.j;
    int right = this.j;
    // Downwards
    for (int a = 1; a < (8 - this.i); a++) {
      if ((8 - right) > 1) {
        if (this.destinationSquareOK(board, this.i + a, right + 1)) {
          right++;
        }
        else {
          right = 8; // Break for-loop for right.
        }
      }

      if (left > 0) {
        if (this.destinationSquareOK(board, this.i + a, left - 1)) {
          left--;
        }
        else {
          left = 0; // Breaking the loop for left!
        }
      }
    }

    int l = this.j;
    int r = this.j;
    // Upwards
    for (int a = 1; a <= this.i ; a++) {
      if ((8 - r) > 1) {
        if (this.destinationSquareOK(board, this.i - a, r + 1)) {
          r++;
        }
        else {
          r = 8;
        }
      }

      if (l > 0) {
        if (this.destinationSquareOK(board, this.i - a, l - 1)) {
          l--;
        }
        else {
          l = 0;
        }
      }
    }
  }

  public void updateLegalMoves(Piece[][] board) {
    this.checkDiagonalMoves(board);
  }

}
