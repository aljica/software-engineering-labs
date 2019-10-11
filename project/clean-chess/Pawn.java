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
    if (this.destinationSquareIsEmpty(board, a, b)) {
      this.addMove(a, b);
    }
  }

  public void addDiagonalSquareIfOpposite(Piece[][] board, int a, int b) {
    if (this.destinationSquareHasOppositeColor(board, a, b)) {
      this.addMove(a, b);
    }
  }

  public void checkRightDiagonal(Piece[][] board) {
    if (this.isWhite) {
      this.addDiagonalSquareIfOpposite(board, this.i-1, this.j+1);
    }
    else {
      this.addDiagonalSquareIfOpposite(board, this.i+1, this.j+1);
    }
  }

  public void checkLeftDiagonal(Piece[][] board) {
    if (this.isWhite) {
      this.addDiagonalSquareIfOpposite(board, this.i-1, this.j-1);
    }
    else {
      this.addDiagonalSquareIfOpposite(board, this.i+1, this.j-1);
    }
  }

  public void checkDiagonalCaptures(Piece[][] board) {
    // Check if the pawn is an edge pawn
    if (this.j == 0) {
      this.checkRightDiagonal(board);
      return;
    }
    else if (this.j == 7) {
      this.checkLeftDiagonal(board);
      return;
    }

    // Left/Right from White's point of view (!)
    this.checkLeftDiagonal(board);
    this.checkRightDiagonal(board);
  }

  public void updateLegalMoves(Piece[][] board) {
    // If i == 8, pawn promotion. Not yet implemented.
    if (this.isWhite) {
      this.addSquareIfEmpty(board, this.i - 1, this.j);
      if (this.firstMove) {
        this.addSquareIfEmpty(board, this.i - 2, this.j);
      }
    }
    else {
      this.addSquareIfEmpty(board, this.i + 1, this.j);
      if (this.firstMove) {
        this.addSquareIfEmpty(board, this.i + 2, this.j);
      }
    }

    this.checkDiagonalCaptures(board);
  }

}
