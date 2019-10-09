import java.util.ArrayList;

public class Pawn extends Piece {

  private boolean firstMove = true; // Only pawns need this, for 1/2 step initial move.

  public Pawn(int i, int j, boolean isWhite) {
    super(i, j, isWhite);
    if (isWhite) {
      this.value = 0;
    } else {
      this.value = 1;
    }
  }

  public void updateLegalMoves(Piece[][] board) {

    ArrayList<Integer> move = new ArrayList<Integer>();

    if (this.isWhite) {
      if (this.firstMove) {

        // One step forward
        move.add(this.i - 1); move.add(this.j);
        this.legalMoves.add(move);

        // Two steps forward
        ArrayList<Integer> tmp = new ArrayList<Integer>();
        tmp.add(this.i - 2); tmp.add(this.j);
        this.legalMoves.add(tmp);

        this.firstMove = false;
      }
      else {
        if (board[this.i-1][this.j] == null) {
          move.add(this.i-1); move.add(this.j);
          this.legalMoves.add(move);
        }
      }
      // Add else ifs for capturing diagonally here.
    }

    else {
      if (this.firstMove) {
        // One
        move.add(this.i + 1); move.add(j);
        this.legalMoves.add(move);

        // Two
        ArrayList<Integer> tmp = new ArrayList<Integer>();
        tmp.add(this.i + 2); tmp.add(this.j);
        this.legalMoves.add(tmp);

        this.firstMove = false;
      }
      else {
        if (board[this.i+1][this.j] == null) {
          move.add(this.i + 1); move.add(this.j);
          this.legalMoves.add(move);
        }
      }
    }
  }

}
