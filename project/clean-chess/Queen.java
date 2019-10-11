public class Queen extends Piece {

  public Queen(int i, int j, boolean isWhite) {
    super(i, j, isWhite);
    if (isWhite) {
      this.value = 8;
    } else {
      this.value = 9;
    }
  }

  public void addAllTheMoves(Piece[][] board, int x, int y) {
    Piece destSquare;
    for (int a = 1; a < 8; a++) {
      try {
        destSquare = board[this.i + x*a][this.j + y*a];
      }
      catch (ArrayIndexOutOfBoundsException e) {
        continue;
      }

      if (destSquare == null) {
        this.addMove(this.i + x*a, this.j + y*a);
      }
      else {
        if (destSquare.getIdentifier() % 2 != this.getIdentifier() % 2) {
          this.addMove(this.i + x*a, this.j + y*a);
        }
        break;
      }
    }
  }

  public void updateLegalMoves(Piece[][] board) {
    this.addAllTheMoves(board, 1, 0); // All moves UPWARDS
    // because x = 1 and y = 0, check yourself
    this.addAllTheMoves(board, -1, 0); // all moves Downwards
    this.addAllTheMoves(board, 0, 1); // all moves horizontal right
    this.addAllTheMoves(board, 0, -1); // all moves LEFT

    this.addAllTheMoves(board, 1, 1); // SouthEast
    this.addAllTheMoves(board, 1, -1); // Southwest
    this.addAllTheMoves(board, -1, 1); // northeast
    this.addAllTheMoves(board, -1, -1); // northwest
  }

}
