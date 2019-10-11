public class King extends Piece {

  public King(int i, int j, boolean isWhite) {
    super(i, j, isWhite);
    if (isWhite) {
      this.value = 10;
    } else {
      this.value = 11;
    }
  }

  public void checkSurroundingSquares(Piece[][] board, int a, int b) {
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
    this.checkSurroundingSquares(board, 1, 0); // Down
    this.checkSurroundingSquares(board, 0, 1); // Right
    this.checkSurroundingSquares(board, 1, 1); // Down right
    this.checkSurroundingSquares(board, 1, -1); // Down left
    this.checkSurroundingSquares(board, -1, 0); // Up
    this.checkSurroundingSquares(board, 0, -1); // Left
    this.checkSurroundingSquares(board, -1, -1); // Up left
    this.checkSurroundingSquares(board, -1, 1); // Up right
  }

}
