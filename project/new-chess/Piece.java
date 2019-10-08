import java.util.ArrayList;

public abstract class Piece {

  public int i;
  public int j;
  public int value = -1;
  public boolean isWhite;
  public boolean firstMove = true;
  public ArrayList<Integer> legalMoves = new ArrayList<Integer>();

  public Piece(int i, int j, boolean isWhite) {
    this.i = i;
    this.j = j;
    this.isWhite = isWhite;
  }

  public abstract void updateLegalMoves(Piece[][] board);

  public int getIdentifier() {
    // 0 for white pawn, 1 for black pawn, etc...
    return this.value;
  }

  // Add some methods
  public void seti(int i) {
    this.i = i;
  }
  public int geti() {
    return this.i;
  }
  public void setj(int j) {
    this.j = j;
  }
  public int getj() {
    return this.j;
  }
}
