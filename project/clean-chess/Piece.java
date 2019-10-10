import java.util.ArrayList;

public abstract class Piece {

  public int i;
  public int j;
  public int value = -1;
  public boolean isWhite;
  public boolean firstMove = true;
  public ArrayList<ArrayList<Integer>> legalMoves = new ArrayList<ArrayList<Integer>>();

  public Piece(int i, int j, boolean isWhite) {
    this.i = i;
    this.j = j;
    this.isWhite = isWhite;
  }

  public void firstMoveHasBeenMade() {
    this.firstMove = false;
  }

  public void addMove(int a, int b) {
    ArrayList<Integer> move = new ArrayList<Integer>();
    move.add(this.i + a); move.add(this.j + b);
    this.legalMoves.add(move);
  }

  public abstract void updateLegalMoves(Piece[][] board);

  public void clearLegalMoves() {
    this.legalMoves.clear();
  }

  public ArrayList<ArrayList<Integer>> getLegalMoves() {
    // Could even have an iterator for this.
    return this.legalMoves;
  }

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
