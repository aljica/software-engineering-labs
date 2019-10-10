package pieces;

// Pieces should get the Board object after each updateStatus()
// and check which squares the piece in question can move to.
// They could store this information in an ArrayList, perhaps.
// Or in a Collection? Not sure what that is, look it up.

public abstract class Piece {

  public int i;
  public int j;

  public int getI() {
    return this.i;
  }

  public int getJ() {
    return this.j;
  }

  public void setI(int i) {
    this.i = i;
  }

  public void setJ(int j) {
    this.j = j;
  }

  public static Piece create(String type) {

    if (type == "pawn") {
      return new Pawn();
    }
    else if (type == "rook") {
      return new Rook();
    }
    else if (type == "knight") {
      return new Knight();
    }
    else if (type == "bishop") {
      return new Bishop();
    }
    else if (type == "queen") {
      return new Queen();
    }
    else if (type == "king") {
      return new King();
    }

    return null;
  }

}
