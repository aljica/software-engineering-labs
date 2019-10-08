public class Rook extends Piece {

  public Rook(int i, int j, boolean isWhite) {
    super(i, j, isWhite);
    this.value = 5;
  }

  public void updateLegalMoves(Piece[][] board) {
    return;
  }

}
