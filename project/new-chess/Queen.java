public class Queen extends Piece {

  public Queen(int i, int j, boolean isWhite) {
    super(i, j, isWhite);
    this.value = 9;
  }

  public void updateLegalMoves(Piece[][] board) {
    return;
  }

}
