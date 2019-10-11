public class Rook extends Piece {

  public Rook(int i, int j, boolean isWhite) {
    super(i, j, isWhite);
    if (isWhite) {
      this.value = 2;
    } else {
      this.value = 3;
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

  public void addMoves(Piece[][] board, int x, int y, int range) {
    for (int a = 1; a < range; a++) {
      if (this.destinationSquareOK(board, this.i + x*a, this.j + y*a)) {
        continue;
      }
      else {
        break;
      }
    }
  }

  public void updateLegalMoves(Piece[][] board) {
    //this.addVerticalMovesUpwards(board);
    this.addMoves(board, -1, 0, this.i + 1);
    //this.addVerticalMovesDownwards(board);
    this.addMoves(board, 1, 0, (8 - this.i));
    //this.addHorizontalMovesEastward(board);
    this.addMoves(board, 0, 1, (8 - this.j));
    //this.addHorizontalMovesWestward(board);
    this.addMoves(board, 0, -1, this.j + 1);
  }

}
