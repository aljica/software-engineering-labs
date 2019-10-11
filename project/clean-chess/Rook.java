public class Rook extends Piece {

  public Rook(int i, int j, boolean isWhite) {
    super(i, j, isWhite);
    if (isWhite) {
      this.value = 2;
    } else {
      this.value = 3;
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
    this.addAllTheMoves(board, 1, 0); // All moves UPWARDS
    // because x = 1 and y = 0, check yourself
    this.addAllTheMoves(board, -1, 0); // all moves Downwards
    this.addAllTheMoves(board, 0, 1); // all moves horizontal right
    this.addAllTheMoves(board, 0, -1); // all moves LEFT
  }

}
