public class King extends Piece {

  public King(int i, int j, boolean isWhite) {
    super(i, j, isWhite);
    if (isWhite) {
      this.value = 10;
    } else {
      this.value = 11;
    }
  }

  public void updateLegalMoves(Piece[][] board) {
    return;
  }

}
