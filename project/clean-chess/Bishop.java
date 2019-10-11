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

  public void checkDiagonalMoves(Piece[][] board) {
    // Downwards
    this.addMoves(board, 1, (8 - this.i));
    // Upwards
    this.addMoves(board, -1, (this.i + 1));
  }

  public void updateLegalMoves(Piece[][] board) {
    this.checkDiagonalMoves(board);
  }

}
