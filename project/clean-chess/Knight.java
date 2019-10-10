public class Knight extends Piece {

  public Knight(int i, int j, boolean isWhite) {
    super(i, j, isWhite);
    if (isWhite) {
      this.value = 4;
    } else {
      this.value = 5;
    }
  }

  // Note that several lines below are exactly
  // the same, so we can shorten this method significantly.
  // Although I won't do it, because I want it to be very
  // easy to follow exactly at which squares a knight can move
  // given different starting positions.

  // NOTE: Knight is not completely done. Remember that the knight
  // can only move to all possible squares when in the center of
  // the board, but whenever the knight is within 2 squares of
  // the edge, we have a special case to deal with.
  // So, when when a knight is at coordinate 1 < i < 6,
  // we must then, TOO, add special case scenarios, much like for
  // 1 < j < 6.

  // NOTE TWO: We're not even checking to make sure the square
  // we're moving to does not contain a same colored piece. Re-do this!
  public void checkPossibleSquares(Piece[][] board) {
    if (this.i == 0) {
      // Knight is at (0, j)
      if (this.j == 0) {
        // Knight is at (0, 0)
        this.allPossibleManeuvers(board, 1, 2); // 1 down, 2 right
        this.allPossibleManeuvers(board, 2, 1);
      }
      else if (this.j == 1) {
        this.allPossibleManeuvers(board, 2, 1); // 2 down, 1 right
        this.allPossibleManeuvers(board, 1, 2); // 1 down, 2 right
        this.allPossibleManeuvers(board, 2, -1); // 2 down, 1 left
      }
      else if (1 < this.j && this.j < 6) {
        this.allPossibleManeuvers(board, 2, 1); // 2 down, 1 right
        this.allPossibleManeuvers(board, 1, 2);
        this.allPossibleManeuvers(board, 1, -2);
        this.allPossibleManeuvers(board, 2, -1);
      }
      else if (this.j == 6) {
        this.allPossibleManeuvers(board, 2, 1); // 2 down, 1 right
        this.allPossibleManeuvers(board, 1, -2); // 1 down, 2 left
        this.allPossibleManeuvers(board, 2, -1);
      }
      else if (this.j == 7) {
        this.allPossibleManeuvers(board, 1, -2);
        this.allPossibleManeuvers(board, 2, -1);
      }
    }
    else if (this.i == 1) {
      if (this.j == 0) {
        this.allPossibleManeuvers(board, -1, 2);
        this.allPossibleManeuvers(board, 1, 2);
        this.allPossibleManeuvers(board, 2, 1);
      }
      else if (this.j == 1) {
        this.allPossibleManeuvers(board, -1, 2);
        this.allPossibleManeuvers(board, 2, -1);
        this.allPossibleManeuvers(board, 2, 1);
        this.allPossibleManeuvers(board, 1, 2);
      }
      else if (1 < this.j && this.j < 6) {
        this.allPossibleManeuvers(board, -1, -2);
        this.allPossibleManeuvers(board, -1, 2);
        this.allPossibleManeuvers(board, 1, -2);
        this.allPossibleManeuvers(board, 2, -1);
        this.allPossibleManeuvers(board, 2, 1);
        this.allPossibleManeuvers(board, 1, 2);
      }
      else if (this.j == 6) {
        this.allPossibleManeuvers(board, -1, -2);
        this.allPossibleManeuvers(board, 1, -2);
        this.allPossibleManeuvers(board, 2, -1);
        this.allPossibleManeuvers(board, 2, 1);
      }
      else if (this.j == 7) {
        this.allPossibleManeuvers(board, -1, -2);
        this.allPossibleManeuvers(board, 1, -2);
        this.allPossibleManeuvers(board, 2, -1);
      }
    }
    else if ((1 < this.i && this.i < 6) && this.j < 2) {
      if (this.j == 0) {
        this.allPossibleManeuvers(board, -2, 1);
        this.allPossibleManeuvers(board, -1, 2);
        this.allPossibleManeuvers(board, 1, 2);
        this.allPossibleManeuvers(board, 2, 1);
      }
      else if (this.j == 1) {
        this.allPossibleManeuvers(board, -2, 1);
        this.allPossibleManeuvers(board, -1, 2);
        this.allPossibleManeuvers(board, 1, 2);
        this.allPossibleManeuvers(board, 2, 1);
        this.allPossibleManeuvers(board, -2, -1);
        this.allPossibleManeuvers(board, 2, -1);
      }
    }
    else if ((1 < this.i && this.i < 6) && this.j > 5) {
      if (this.j == 6) {
        this.allPossibleManeuvers(board, -2, -1);
        this.allPossibleManeuvers(board, -1, -2);
        this.allPossibleManeuvers(board, 1, -2);
        this.allPossibleManeuvers(board, 2, -1);
        this.allPossibleManeuvers(board, -2, 1);
        this.allPossibleManeuvers(board, 2, 1);
      }
      if (this.j == 7) {
        this.allPossibleManeuvers(board, -2, -1);
        this.allPossibleManeuvers(board, -1, -2);
        this.allPossibleManeuvers(board, 1, -2);
        this.allPossibleManeuvers(board, 2, -1);
      }
    }
    else if (this.i == 6) {
      if (this.j == 0) {
        this.allPossibleManeuvers(board, -1, 2);
        this.allPossibleManeuvers(board, -2, 1);
        this.allPossibleManeuvers(board, 1, 2);
      }
      else if (this.j == 1) {
        this.allPossibleManeuvers(board, -2, -1);
        this.allPossibleManeuvers(board, -2, 1);
        this.allPossibleManeuvers(board, -1, 2);
        this.allPossibleManeuvers(board, 1, 2);
      }
      else if (1 < this.j && this.j < 6) {
        this.allPossibleManeuvers(board, -1, -2);
        this.allPossibleManeuvers(board, -2, -1);
        this.allPossibleManeuvers(board, -2, 1);
        this.allPossibleManeuvers(board, -1, 2);
        this.allPossibleManeuvers(board, 1, -2);
        this.allPossibleManeuvers(board, 1, 2);
      }
      else if (this.j == 6) {
        this.allPossibleManeuvers(board, -1, -2);
        this.allPossibleManeuvers(board, -2, -1);
        this.allPossibleManeuvers(board, -2, 1);
        this.allPossibleManeuvers(board, 1, -2);
      }
      else if (this.j == 7) {
        this.allPossibleManeuvers(board, -2, -1);
        this.allPossibleManeuvers(board, -1, -2);
        this.allPossibleManeuvers(board, 1, -2);
      }
    }
    else if (this.i == 7) {
      if (this.j == 0) {
        this.allPossibleManeuvers(board, -2, 1);
        this.allPossibleManeuvers(board, -1, 2);
      }
      else if (this.j == 1) {
        this.allPossibleManeuvers(board, -2, -1);
        this.allPossibleManeuvers(board, -2, 1);
        this.allPossibleManeuvers(board, -1, 2);
      }
      else if (1 < this.j && this.j < 6) {
        this.allPossibleManeuvers(board, -1, -2);
        this.allPossibleManeuvers(board, -2, -1);
        this.allPossibleManeuvers(board, -1, 2);
        this.allPossibleManeuvers(board, -2, 1);
      }
      else if (this.j == 6) {
        this.allPossibleManeuvers(board, -1, -2);
        this.allPossibleManeuvers(board, -2, -1);
        this.allPossibleManeuvers(board, -2, 1);
      }
      else if (this.j == 7) {
        this.allPossibleManeuvers(board, -1, -2);
        this.allPossibleManeuvers(board, -2, -1);
      }
    }
  }

  public void addAllPossibleSquares(Piece[][] board) {
    // Up/down from white's point of view.
    this.allPossibleManeuvers(board, -2, -1);
    this.allPossibleManeuvers(board, -2, 1);
    this.allPossibleManeuvers(board, 2, -1);
    this.allPossibleManeuvers(board, 2, 1);

    this.allPossibleManeuvers(board, -1, -2);
    this.allPossibleManeuvers(board, -1, 2);
    this.allPossibleManeuvers(board, 1, -2);
    this.allPossibleManeuvers(board, 1, 2);
  }

  public void allPossibleManeuvers(Piece[][] board, int a, int b) {
    // 1 down 2 right: a = 1, b = 2
    // 1 down 2 left: 1, -2
    // 1 up, 2 right: -1, 2
    // 1 up, 2 left: -1, -2
    // 2 down, 1 right: 2, 1
    // 2 down, 1 left: 2, -1
    // 2 up, 1 right: -2, 1
    // 2 up, 1 left: -2, -1
    if (this.destinationSquareIsEmpty(board, this.i + a, this.j + b)) {
      this.addMove(a, b);
    }
    else {
      if (this.destinationSquareHasOppositeColor(board, this.i + a, this.j + b)) {
        this.addMove(a, b);
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
