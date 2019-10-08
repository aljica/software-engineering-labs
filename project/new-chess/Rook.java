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
    return;
  }

}
