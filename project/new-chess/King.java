public class King extends Piece {

  public King(int i, int j, boolean isWhite) {
    super(i, j, isWhite);
    this.value = -1;
  }

  public void updateLegalMoves(Piece[][] board) {
    return;
  }

}
