public class King extends Piece {

  public King(int i, int j, boolean isWhite) {
    super(i, j, isWhite);
    if (isWhite) {
      this.value = 10;
    } else {
      this.value = 11;
    }
  }

  public void addAllTheMoves(Piece[][] board, int a, int b) {
    if (this.addIfEmpty(board, this.i + a, this.j + b)) {
      return;
    }
    else {
      this.addIfOpposite(board, this.i + a, this.j + b);
    }
  }

  public void updateLegalMoves(Piece[][] board) {
    this.addAllTheMoves(board, 1, 0); // Down
    this.addAllTheMoves(board, 0, 1); // Right
    this.addAllTheMoves(board, 1, 1); // Down right
    this.addAllTheMoves(board, 1, -1); // Down left
    this.addAllTheMoves(board, -1, 0); // Up
    this.addAllTheMoves(board, 0, -1); // Left
    this.addAllTheMoves(board, -1, -1); // Up left
    this.addAllTheMoves(board, -1, 1); // Up right
  }

}
