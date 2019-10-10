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

  public void untouchedPawnMovesTwoSquares(Piece[][] board) {
    if (this.isWhite) {
      this.addMove(-1, 0);
      this.addMove(-2, 0);
    }
    else {
      this.addMove(1, 0);
      this.addMove(2, 0);
    }
  }

  public void addSquareInfrontIfEmpty(Piece[][] board) {
    if (this.isWhite) {
      // Seems to be a bug when pawn reaches 7th rank and tries to
      // capture on 8th rank. Array out of bounds exception.
      // Look into it.
      if (this.destinationSquareIsEmpty(board, this.i - 1, this.j)) {
        this.addMove(-1, 0);
      }
    }
    else {
      if (this.destinationSquareIsEmpty(board, this.i + 1, this.j)) {
        this.addMove(1, 0);
      }
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
        this.addMove(-1, 1);
      }
    }
    else {
      if (this.destinationSquareHasOppositeColor(board, this.i+1, this.j+1)) {
        this.addMove(1, 1);
      }
    }
  }

  public void checkLeftDiagonal(Piece[][] board) {
    if (this.isWhite) {
      if (this.destinationSquareHasOppositeColor(board, this.i-1, this.j-1)) {
        this.addMove(-1, -1);
      }
    }
    else {
      if (this.destinationSquareHasOppositeColor(board, this.i+1, this.j-1)) {
        this.addMove(1, -1);
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
      this.untouchedPawnMovesTwoSquares(board);
    }
    else {
      this.addSquareInfrontIfEmpty(board);
    }
    this.checkDiagonalCaptures(board);
  }
}
