public class Rook extends Piece {

  public Rook(int i, int j, boolean isWhite) {
    super(i, j, isWhite);
    if (isWhite) {
      this.value = 2;
    } else {
      this.value = 3;
    }
  }

  public void updateLegalMoves(Piece[][] board) {
    this.addAllTheMoves(board, 1, 0, 8); // All moves UPWARDS
    // because x = 1 and y = 0, check yourself
    this.addAllTheMoves(board, -1, 0, 8); // all moves Downwards
    this.addAllTheMoves(board, 0, 1, 8); // all moves horizontal right
    this.addAllTheMoves(board, 0, -1, 8); // all moves LEFT
  }

}
