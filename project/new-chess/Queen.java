public class Queen extends Piece {

  public Queen(int i, int j, boolean isWhite) {
    super(i, j, isWhite);
    if (isWhite) {
      this.value = 8;
    } else {
      this.value = 9;
    }
  }

  public void updateLegalMoves(Piece[][] board) {
    return;
  }

}
