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
      if (this.destinationSquareIsEmpty(board, this.i - 1, this.j)) {
        this.addMove(this.i - 1, this.j);
      }
      if (this.destinationSquareIsEmpty(board, this.i - 2, this.j)) {
        this.addMove(this.i - 2, this.j);
      }
    }
    else {
      if (this.destinationSquareIsEmpty(board, this.i + 1, this.j)) {
        this.addMove(this.i + 1, this.j);
      }
      if (this.destinationSquareIsEmpty(board, this.i + 2, this.j)) {
        this.addMove(this.i + 2, this.j);
      }
    }
  }

  public void addSquareInfrontIfEmpty(Piece[][] board) {
    if (this.isWhite) {
      // Seems to be a bug when pawn reaches 7th rank and tries to
      // capture on 8th rank. Array out of bounds exception.
      // Look into it.
      // NOTE: Reason is because when we try to place the pawn on
      // the 8th rank, it will automatically try to add index
      // 8 (9th rank) to possible moves, but that rank doesn't
      // exist. Figure out a solution for this.
      if (this.destinationSquareIsEmpty(board, this.i - 1, this.j)) {
        this.addMove(this.i - 1, this.j);
      }
    }
    else {
      if (this.destinationSquareIsEmpty(board, this.i + 1, this.j)) {
        this.addMove(this.i + 1, this.j);
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
      this.untouchedPawnMovesTwoSquares(board);
    }
    else {
      this.addSquareInfrontIfEmpty(board);
    }
    this.checkDiagonalCaptures(board);
  }
}
