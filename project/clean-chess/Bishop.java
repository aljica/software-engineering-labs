public class Bishop extends Piece {

  public Bishop(int i, int j, boolean isWhite) {
    super(i, j, isWhite);
    if (isWhite) {
      this.value = 6;
    } else {
      this.value = 7;
    }
  }

  public void checkDiagonalMoves(Piece[][] board, int a, int b) {
    int left = this.j;
    int right = this.j;
    // Downwards
    for (int a = 1; a < (8 - this.i); a++) {
      if ((8 - right) > 1) {
        if (this.destinationSquareIsEmpty(board, this.i + a, right + 1) ||
          (this.destinationSquareHasOppositeColor(board, this.i + a, right + 1))) {
          this.addMove2(this.i + a, right + 1);
        }
        right++;
      }
      if (left > 0) {
        if (this.destinationSquareIsEmpty(board, this.i + a, left - 1) ||
          (this.destinationSquareHasOppositeColor(board, this.i + a, left - 1))) {
            this.addMove2(this.i + a, left - 1);
          }
        left--;
      }
    }

    int l = this.j;
    int r = this.j;
    // Upwards
    for (int a = 1; a <= this.i; a++) {
      
    }
  }

  public void updateLegalMoves(Piece[][] board) {
    return;
  }

}
