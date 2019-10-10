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
    ArrayList<Integer> move1 = new ArrayList<Integer>();
    ArrayList<Integer> move2 = new ArrayList<Integer>();

    if (this.isWhite) {
      move1.add(this.i - 1); move1.add(this.j);
      this.legalMoves.add(move1);

      move2.add(this.i - 2); move2.add(this.j);
      this.legalMoves.add(move2);
    }
    else {
      move1.add(this.i + 1); move1.add(this.j);
      this.legalMoves.add(move1);

      move2.add(this.i + 2); move2.add(this.j);
      this.legalMoves.add(move2);
    }
  }

  public void addSquareInfrontIfEmpty(Piece[][] board) {
    ArrayList<Integer> move = new ArrayList<Integer>();

    if (this.isWhite) {
      if (board[this.i - 1][this.j] == null) {
        move.add(this.i - 1); move.add(this.j);
        this.legalMoves.add(move);
      }
    }
    else {
      if (board[this.i + 1][this.j] == null) {
        move.add(this.i + 1); move.add(this.j);
        this.legalMoves.add(move);
      }
    }
  }

  public void diagonalCapturesForEdges(Piece[][] board) {
    return;
  }

  public void checkDiagonalCaptures(Piece[][] board) {
    // Check if the pawn is an edge pawn
    if (this.j == 0 || this.j == 7) {
      this.diagonalCapturesForEdges(board);
    }
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
