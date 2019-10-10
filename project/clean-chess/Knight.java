public class Knight extends Piece {

  public Knight(int i, int j, boolean isWhite) {
    super(i, j, isWhite);
    if (isWhite) {
      this.value = 4;
    } else {
      this.value = 5;
    }
  }

  public void getJwhenIequalsZero(Piece[][] board) {
    if (this.j == 0) {
      this.oneDownTwoRight();
      this.twoDownOneRight();
    }
    else if (this.j == 1) {

    }
    else if (1 < this.j < 6) {

    }
    else if (this.j == 6) {

    }
    else if (this.j == 7) {

    }
    else {
      // This is temporary (?)
      System.out.println("FATAL ERROR");
      System.exit(0);
    }
  }

  public void checkPossibleSquares(Piece[][] board) {
    // Check conditions and create appropriate sub-functions
    // to handle different possibilities
    switch(this.i) {
      case 0:
        this.getJwhenIequalsZero(board);
      case 1:
        this.getJwhenIequalsOne(board);
    }
  }

  public void addAllPossibleSquares(Piece[][] board) {
    // Up/down from white's point of view.
    this.twoUpOneLeft(board);
    this.twoUpOneRight(board);
    this.twoDownOneLeft(board);
    this.twoDownOneRight(board);

    this.oneUpTwoLeft(board);
    this.oneUpTwoRight(board);
    this.oneDownTwoLeft(board);
    this.oneDownTwoRight(board);
  }

  public void oneDownTwoRight(Piece[][] board) {
    // Moving two steps down, one to the right.
    Piece piece = board[this.i + 1][this.j + 2];
    if (piece != null) {
      // If it's an opposite colored piece, we can capture it
      if ((this.value % 2) != (piece.getIdentifier() % 2)) {
        this.addMove(1, 2);
      }
    }
  }

  public void oneDownTwoLeft(Piece[][] board) {
    // Moving two steps down, one to the right.
    Piece piece = board[this.i + 1][this.j - 2];
    if (piece != null) {
      // If it's an opposite colored piece, we can capture it
      if ((this.value % 2) != (piece.getIdentifier() % 2)) {
        this.addMove(1, -2);
      }
    }
  }

  public void oneUpTwoRight(Piece[][] board) {
    // Moving two steps down, one to the right.
    Piece piece = board[this.i - 1][this.j + 2];
    if (piece != null) {
      // If it's an opposite colored piece, we can capture it
      if ((this.value % 2) != (piece.getIdentifier() % 2)) {
        this.addMove(-1, 2);
      }
    }
  }

  public void oneUpTwoLeft(Piece[][] board) {
    // Moving two steps down, one to the right.
    Piece piece = board[this.i - 1][this.j - 2];
    if (piece != null) {
      // If it's an opposite colored piece, we can capture it
      if ((this.value % 2) != (piece.getIdentifier() % 2)) {
        this.addMove(-1, -2);
      }
    }
  }

  public void twoDownOneRight(Piece[][] board) {
    // Moving two steps down, one to the right.
    Piece piece = board[this.i + 2][this.j + 1];
    if (piece != null) {
      // If it's an opposite colored piece, we can capture it
      if ((this.value % 2) != (piece.getIdentifier() % 2)) {
        this.addMove(2, 1);
      }
    }
  }

  public void twoDownOneLeft(Piece[][] board) {
    // Moving two steps down, one to the left.
    Piece piece = board[this.i + 2][this.j - 1];
    if (piece != null) {
      // If it's an opposite colored piece, we can capture it
      if ((this.value % 2) != (piece.getIdentifier() % 2)) {
        this.addMove(2, -1);
      }
    }
  }

  public void twoUpOneRight(Piece[][] board) {
    // Moving two steps up, one to the right.
    Piece piece = board[this.i - 2][this.j + 1];
    if (piece != null) {
      // If it's an opposite colored piece, we can capture it
      if ((this.value % 2) != (piece.getIdentifier() % 2)) {
        this.addMove(-2, 1);
      }
    }
  }

  public void twoUpOneLeft(Piece[][] board) {
    // Moving two steps up, one to the left.
    Piece piece = board[this.i - 2][this.j - 1];
    if (piece != null) {
      // If it's an opposite colored piece, we can capture it
      if ((this.value % 2) != (piece.getIdentifier() % 2)) {
        this.addMove(-2, -1);
      }
    }
  }

  public void updateLegalMoves(Piece[][] board) {
    if (this.i < 2 || this.i > 5 || this.j < 2 || this.j > 5) {
      this.checkPossibleSquares(board);
      return;
    }
    this.addAllPossibleSquares(board);
  }

}
