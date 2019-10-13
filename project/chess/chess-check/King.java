public class King extends Piece {

  public boolean underAttack = false;
  public boolean stillUnderAttack = false;

  public King(int i, int j, boolean isWhite) {
    super(i, j, isWhite);
    if (isWhite) {
      this.value = 10;
    } else {
      this.value = 11;
    }
  }

  public void setUnderAttack() {
    this.underAttack = true;
  }

  public void resetUnderAttack() {
    this.underAttack = false;
  }

  public boolean underAttack() {
    return underAttack;
  }

  public void setStillUnderAttack() {
    this.stillUnderAttack = true;
  }

  public void resetStillUnderAttack() {
    this.stillUnderAttack = false;
  }

  public boolean stillUnderAttack() {
    return this.stillUnderAttack;
  }

  public void updateLegalMoves(Piece[][] board) {
    this.addAllTheMoves(board, 1, 0, 2); // Down
    this.addAllTheMoves(board, 0, 1, 2); // Right
    this.addAllTheMoves(board, 1, 1, 2); // Down right
    this.addAllTheMoves(board, 1, -1, 2); // Down left
    this.addAllTheMoves(board, -1, 0, 2); // Up
    this.addAllTheMoves(board, 0, -1, 2); // Left
    this.addAllTheMoves(board, -1, -1, 2); // Up left
    this.addAllTheMoves(board, -1, 1, 2); // Up right
  }

}
