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

  public boolean addIfOpposite(Piece[][] board, int a, int b) {
    Piece destinationSquare;

    try {
      destinationSquare = board[a][b];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      return false;
    }

    // THIS SOLVES A PROBLEM OF NULLPOINTEREXCEPTION FOR PAWN.java
    // BUT MAYBE WE DON'T NEED THIS HERE...? MAYBE WE CAN DO THIS
    // CHECK INSIDE OF PAWN.JAVA?
    if (destinationSquare == null) {
      return false; // This should solve the problem for pawn.
    }

    if (this.getIdentifier() % 2 != destinationSquare.getIdentifier() % 2) {
      return this.addMove(a, b);
    }
    return false;
  }

  public boolean addIfEmpty(Piece[][] board, int a, int b) {
    Piece destinationSquare;

    try {
      destinationSquare = board[a][b];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      return false;
    }

    if (destinationSquare == null) {
      return this.addMove(a, b);
    }
    return false;
  }

  public boolean addMove(int a, int b) {
    ArrayList<Integer> move = new ArrayList<Integer>();
    move.add(a); move.add(b);
    this.legalMoves.add(move);
    return true;
  }

  public abstract void updateLegalMoves(Piece[][] board);

  public void clearLegalMoves() {
    this.legalMoves.clear();
  }

  public ArrayList<ArrayList<Integer>> getLegalMoves() {
    return this.legalMoves;
  }

  public int getIdentifier() {
    // 0 for white pawn, 1 for black pawn, etc...
    return this.value;
  }

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
