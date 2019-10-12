public class Bishop extends Piece {

  public Bishop(int i, int j, boolean isWhite) {
    super(i, j, isWhite);
    if (isWhite) {
      this.value = 6;
    } else {
      this.value = 7;
    }
  }

  public void updateLegalMoves(Piece[][] board) {
    this.addAllTheMoves(board, 1, 1, 8); // SouthEast
    this.addAllTheMoves(board, 1, -1, 8); // Southwest
    this.addAllTheMoves(board, -1, 1, 8); // northeast
    this.addAllTheMoves(board, -1, -1, 8); // northwest
  }

}
