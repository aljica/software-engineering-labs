public class Knight extends Piece {

  public Knight(int i, int j, boolean isWhite) {
    super(i, j, isWhite);
    if (isWhite) {
      this.value = 4;
    } else {
      this.value = 5;
    }
  }

  public void checkPossibleSquares(Piece[][] board, int a, int b) {
    Piece destinationSquare;

    try {
      destinationSquare = board[this.i + a][this.j + b];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      return;
    }

    if (destinationSquare == null ||
      (destinationSquare.getIdentifier() % 2 != this.getIdentifier() % 2)) {
      this.addMove(this.i + a, this.j + b);
    }
  }

  public void updateLegalMoves(Piece[][] board) {
    this.checkPossibleSquares(board, 2, -1); // 2 down, 1 left z
    this.checkPossibleSquares(board, 2, 1);
    this.checkPossibleSquares(board, 1, -2);
    this.checkPossibleSquares(board, 1, 2);
    this.checkPossibleSquares(board, -2, -1);
    this.checkPossibleSquares(board, -2, 1);
    this.checkPossibleSquares(board, -1, 2);
    this.checkPossibleSquares(board, -1, -2);
  }

}
