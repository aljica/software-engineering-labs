public class Pawn extends Piece {

  public Pawn(int i, int j, boolean isWhite) {
    super(i, j, isWhite);
    this.value = 1;
  }

  public void updateLegalMoves(Piece[][] board) {
    this.legalMoves.clear(); // Not sure.
    if (this.isWhite) {
      if (this.firstMove) {
        // One step forward
        this.legalMoves.add(this.i - 1);
        this.legalMoves.add(this.j);
        // Two steps forward
        this.legalMoves.add(this.i - 2);
        this.legalMoves.add(this.j);
        firstMove = false;
      }
      else if (board[i-1][j].geti() == -1) {
        // If square in front is empty
        this.legalMoves.add(i-1);
        this.legalMoves.add(j);
      }
      // Add else ifs for capturing diagonally here.
    }
    else if (!this.isWhite) {
      if (this.firstMove) {
        // One
        this.legalMoves.add(this.i + 1);
        this.legalMoves.add(this.j);
        // Two
        this.legalMoves.add(this.i + 2);
        this.legalMoves.add(this.j);
        firstMove = false;
      }
    }
  }

}
