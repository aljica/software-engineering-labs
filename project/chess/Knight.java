public class Knight extends Piece {

  public Knight(int i, int j, boolean isWhite) {
    super(i, j, isWhite);
    if (isWhite) {
      this.value = 4;
    } else {
      this.value = 5;
    }
  }

  public void updateLegalMoves(Piece[][] board) {
    // Loop range 2 means it will be executed ONCE only
    this.addAllTheMoves(board, 2, -1, 2); // 2 down, 1 left z
    this.addAllTheMoves(board, 2, 1, 2);
    this.addAllTheMoves(board, 1, -2, 2);
    this.addAllTheMoves(board, 1, 2, 2);
    this.addAllTheMoves(board, -2, -1, 2);
    this.addAllTheMoves(board, -2, 1, 2);
    this.addAllTheMoves(board, -1, 2, 2);
    this.addAllTheMoves(board, -1, -2, 2);
  }

}
