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

  public void diagonalCapturesForEdgePawns(Piece[][] board) {
    if (this.j == 0) {
      // If pawn on left edge of board, only check right diagonal.
      this.checkRightDiagonal(board);
    }
    else {
      this.checkLeftDiagonal(board);
    }
  }

  public void checkRightDiagonal(Piece[][] board) {
    if (this.isWhite) {
      if (this.destinationSquareHasOppositeColor(board, this.i-1, this.j+1)) {
        this.addMove(this.i - 1, this.j + 1);
      }
    }
    else {
      if (this.destinationSquareHasOppositeColor(board, this.i+1, this.j+1)) {
        this.addMove(this.i + 1, this.j + 1);
      }
    }
  }

  public void checkLeftDiagonal(Piece[][] board) {
    if (this.isWhite) {
      if (this.destinationSquareHasOppositeColor(board, this.i-1, this.j-1)) {
        this.addMove(this.i - 1, this.j - 1);
      }
    }
    else {
      if (this.destinationSquareHasOppositeColor(board, this.i+1, this.j-1)) {
        this.addMove(this.i + 1, this.j - 1);
      }
    }
  }

  public void checkDiagonalCaptures(Piece[][] board) {
    // Check if the pawn is an edge pawn
    if (this.j == 0 || this.j == 7) {
      this.diagonalCapturesForEdgePawns(board);
      return;
    }

    // Left/Right from White's point of view (!)
    this.checkLeftDiagonal(board);
    this.checkRightDiagonal(board);
  }

  public void updateLegalMoves(Piece[][] board) {
    if (this.firstMove) {
      if (this.isWhite) {
        // Add the square directly in front, and 2 steps in front.
        this.addSquareIfEmpty(board, this.i - 1, this.j);
        this.addSquareIfEmpty(board, this.i - 2, this.j);
      }
      else {
        this.addSquareIfEmpty(board, this.i + 1, this.j);
        this.addSquareIfEmpty(board, this.i + 2, this.j);
      }
    }
    else {
      if (this.isWhite) {
        this.addSquareIfEmpty(board, this.i - 1, this.j);
      }
      else {
        this.addSquareIfEmpty(board, this.i + 1, this.j);
      }
    }
    this.checkDiagonalCaptures(board);
  }

}
