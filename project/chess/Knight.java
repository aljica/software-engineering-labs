public class Knight extends Piece {

  public Knight(int i, int j, boolean isWhite) {
    super(i, j, isWhite);
    if (isWhite) {
      this.value = 4;
    } else {
      this.value = 5;
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
    this.addAllTheMoves(board, 2, -1); // 2 down, 1 left z
    this.addAllTheMoves(board, 2, 1);
    this.addAllTheMoves(board, 1, -2);
    this.addAllTheMoves(board, 1, 2);
    this.addAllTheMoves(board, -2, -1);
    this.addAllTheMoves(board, -2, 1);
    this.addAllTheMoves(board, -1, 2);
    this.addAllTheMoves(board, -1, -2);
  }

}
