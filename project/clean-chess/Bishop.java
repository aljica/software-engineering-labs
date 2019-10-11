public class Bishop extends Piece {

  public Bishop(int i, int j, boolean isWhite) {
    super(i, j, isWhite);
    if (isWhite) {
      this.value = 6;
    } else {
      this.value = 7;
    }
  }

  public void addAllTheMoves(Piece[][] board, int x, int y) {
    for (int a = 1; a < 8; a++) {
      if (this.addIfEmpty(board, this.i + x*a, this.j + y*a)) {
        continue;
      }
      else {
        this.addIfOpposite(board, this.i + x*a, this.j + y*a);
        break;
      }
    }
  }

  public void updateLegalMoves(Piece[][] board) {
    this.addAllTheMoves(board, 1, 1); // SouthEast
    this.addAllTheMoves(board, 1, -1); // Southwest
    this.addAllTheMoves(board, -1, 1); // northeast
    this.addAllTheMoves(board, -1, -1); // northwest
  }

}
