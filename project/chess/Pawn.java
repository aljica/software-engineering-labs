import java.util.ArrayList;

public class Pawn extends Piece {

  public Pawn(int i, int j, boolean isWhite) {
    super(i, j, isWhite);
    if (isWhite) {
      this.value = 0;
    } else {
      this.value = 1;
    }
  }

  public void addSquareIfEmpty(Piece[][] board, int a, int b) {
    Piece destinationSquare;

    try {
      destinationSquare = board[this.i + a][this.j + b];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      return;
    }

    if (destinationSquare == null) {
      this.addMove(this.i + a, this.j + b);
    }
  }

  public void addDiagonalIfOpposite(Piece[][] board, int a, int b) {
    Piece destinationSquare;

    try {
      destinationSquare = board[this.i + a][this.j + b];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      return;
    }

    if (destinationSquare != null) {
      if (destinationSquare.getIdentifier() % 2 != this.getIdentifier() % 2) {
        this.addMove(this.i + a, this.j + b);
      }
    }
  }

  public void updateLegalMoves(Piece[][] board) {
    if (this.isWhite) {
      this.addSquareIfEmpty(board, -1, 0); // One step in front
      if (this.firstMove) {
        this.addSquareIfEmpty(board, -2, 0);
      }
      // Diagonals
      this.addDiagonalIfOpposite(board, -1, -1);
      this.addDiagonalIfOpposite(board, -1, 1);
    }
    else if (!this.isWhite) {
      this.addSquareIfEmpty(board, 1, 0); // One step in front
      if (this.firstMove) {
        this.addSquareIfEmpty(board, 2, 0);
      }
      // Diagonals
      this.addDiagonalIfOpposite(board, 1, -1);
      this.addDiagonalIfOpposite(board, 1, 1);
    }
  }

}
