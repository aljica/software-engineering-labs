import java.util.ArrayList;

public class Pawn extends Piece {

  //public boolean firstMove = true; // Only pawns need this, for 1/2 step initial move.

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
      // Change this to:
      // this.addMove(a, b);
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
      if (board[this.i - 1][this.j] == null) {
        this.addMove(-1, 0);
      }
    }
    else {
      if (board[this.i + 1][this.j] == null) {
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
      Piece rightDiagonalSquare = board[this.i - 1][this.j + 1];

      if (rightDiagonalSquare != null) {
        // If it's a black piece, we can capture it.
        if (rightDiagonalSquare.getIdentifier() % 2 == 1) {
          this.addMove(-1, 1);
        }
      }
    }
    else {
      Piece rightDiagonalSquare = board[this.i + 1][this.j + 1];

      if (rightDiagonalSquare != null) {
        // If it's a black piece, we can capture it.
        if (rightDiagonalSquare.getIdentifier() % 2 == 1) {
          this.addMove(1, 1);
        }
      }
    }
  }

  public void addMove(int a, int b) {
    ArrayList<Integer> move = new ArrayList<Integer>();
    move.add(this.i + a); move.add(this.j + b);
    this.legalMoves.add(move);
  }

  public void checkLeftDiagonal(Piece[][] board) {
    if (this.isWhite) {
      Piece leftDiagonalSquare = board[this.i - 1][this.j - 1];

      if (leftDiagonalSquare != null) {
        // If it's a black piece, we can capture it.
        if (leftDiagonalSquare.getIdentifier() % 2 == 1) {
          this.addMove(-1, -1);
        }
      }
    }
    else {
      Piece leftDiagonalSquare = board[this.i + 1][this.j - 1];

      if (leftDiagonalSquare != null) {
        // If it's a white piece, we can capture it.
        if (leftDiagonalSquare.getIdentifier() % 2 == 0) {
          this.addMove(1, -1);
        }
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

  public void handlePieceMoves(Piece[][] board) {
    if (this.firstMove) {
      this.untouchedPawnMovesTwoSquares(board);
    }
    else {
      this.addSquareInfrontIfEmpty(board);
    }
    this.checkDiagonalCaptures(board);
  }

  public void updateLegalMoves(Piece[][] board) {

    this.handlePieceMoves(board); // Everything below can be removed
  }
}
