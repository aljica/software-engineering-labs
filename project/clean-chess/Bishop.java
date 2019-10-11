public class Bishop extends Piece {

  public Bishop(int i, int j, boolean isWhite) {
    super(i, j, isWhite);
    if (isWhite) {
      this.value = 6;
    } else {
      this.value = 7;
    }
  }

  public void checkDiagonalMoves(Piece[][] board) {
    int left = this.j;
    int right = this.j;
    // Downwards
    for (int a = 1; a < (8 - this.i); a++) {
      if ((8 - right) > 1) {
        if (this.destinationSquareIsEmpty(board, this.i + a, right + 1)) {
          this.addMove(this.i + a, right + 1);
          right++;
        }
        else {
          if (this.destinationSquareHasOppositeColor(board, this.i + a, right + 1)) {
            this.addMove(this.i + a, right + 1);
          }
          //break;
          right = 8; // Breaking the loop for right!
        }
      }
      if (left > 0) {
        if (this.destinationSquareIsEmpty(board, this.i + a, left - 1)) {
          this.addMove(this.i + a, left - 1);
          left--;
        }
        else {
          if (this.destinationSquareHasOppositeColor(board, this.i + a, left - 1)) {
            this.addMove(this.i + a, left - 1);
          }
          //break;
          left = 0; // Breaking the loop for left!
        }
      }
    }

    int l = this.j;
    int r = this.j;
    // Upwards
    for (int a = 1; a <= this.i ; a++) {
      if ((8 - r) > 1) {
        if (this.destinationSquareIsEmpty(board, this.i - a, r + 1)) {
          this.addMove(this.i - a, r + 1);
          r++;
        }
        else {
          if (this.destinationSquareHasOppositeColor(board, this.i - a, r + 1)) {
            this.addMove(this.i - a, r + 1);
          }
          //break;
          r = 8;
        }
      }
      if (l > 0) {
        if (this.destinationSquareIsEmpty(board, this.i - a, l - 1)) {
          this.addMove(this.i - a, l - 1);
          l--;
        }
        else {
          if (this.destinationSquareHasOppositeColor(board, this.i - a, l - 1)) {
            this.addMove(this.i - a, l - 1);
          }
          //break;
          l = 0;
        }
      }
    }
  }

  public void updateLegalMoves(Piece[][] board) {
    this.checkDiagonalMoves(board);
  }

}
