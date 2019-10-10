import java.util.ArrayList;

class ChessGame {

  Piece[][] board = new Piece[8][8];
  //private Piece chosenPiece;
  private int choseni;
  private int chosenj;
  private boolean selected = false;
  private boolean whitesTurn = true;
  private String message = "Game started";

  public String updateMsg() {
    return this.message;
  }

  public boolean move(int i, int j) {
    if (pieceIsSelected()) {
      return !drop(i, j);
    } else {
      return select(i, j);
    }
  }

  public boolean droppedOnSameSquare(int i, int j) {
    if (i == this.choseni && j == this.chosenj) {
      // If user picks up piece then drops on same square.
      this.selected = false;
      this.message = "Piece was put back in its place";
      this.clearPiecesLegalMoves();
    }
    return !this.selected;
  }

  public void checkIfValidMove(int i, int j) {
    Piece chosenPiece = this.board[choseni][chosenj];
    ArrayList<ArrayList<Integer>> piecesLegalMoves;
    piecesLegalMoves = chosenPiece.getLegalMoves();
    int moveToi; int moveToj;

    for (int k = 0; k < piecesLegalMoves.size(); k++) {

      moveToi = piecesLegalMoves.get(k).get(0);
      moveToj = piecesLegalMoves.get(k).get(1);

      // Somewhere here, we want to check if the piece at
      // index (i, j) where user wants to drop their selected
      // piece, contains an opposite colored piece.
      // If so, we should add said opposite colored piece to
      // an ArrayList of captured pieces belonging to the
      // appropriate player (we ought to have two of these
      // ArrayLists to differentiate between which player has
      // caught which pieces), indicating which pieces that player
      // has "won". For now however, we will simply overwrite the
      // piece with a null.

      if (i == moveToi && j == moveToj) {

        // Perform drop
        this.board[i][j] = chosenPiece;
        this.board[this.choseni][this.chosenj] = null; // Overwrites potential
        // existing piece with "null".

        // Set the piece's i and j variables to new square.
        chosenPiece.seti(i); chosenPiece.setj(j);

        // Set message
        this.message = "Moved " + this.choseni + " " +
          this.chosenj + " to " + i + " " + j;

        // First move made for the given piece, and clear moves.
        chosenPiece.firstMoveHasBeenMade();
        this.clearPiecesLegalMoves();

        // No longer selected (because drop was successful)
        // and now other player's turn.
        this.selected = false;
        toggleWhoseTurn();
      }
    }
  }

  public boolean drop(int i, int j) {

    // If user picks up piece then drops on same square.
    if (this.droppedOnSameSquare(i, j)) {
      return this.selected;
    }
    else {
      this.checkIfValidMove(i, j);
    }
    return this.selected;
  }

  public void clearPiecesLegalMoves() {
    Piece piece;
    for (int i = 0; i < 8; i++) {
      for (int j = 0; j < 8; j++) {
        if (board[i][j] == null) {
          continue;
        }
        piece = this.board[i][j];
        piece.clearLegalMoves(); // Update legal moves for each piece.
      }
    }
  }

  public void identifyLegalMoves() {
    Piece piece;
    for (int i = 0; i < 8; i++) {
      for (int j = 0; j < 8; j++) {
        if (board[i][j] == null) {
          continue;
        }
        piece = this.board[i][j];
        piece.updateLegalMoves(this.board); // Update legal moves for each piece.
      }
    }
  }

  void pickupPiece(int i, int j) {
    this.choseni = i;
    this.chosenj = j;
    this.selected = true;
    this.message = "Selected " + i + " " + j;
  }

  public boolean select(int i, int j) {
    if (board[i][j] != null) {
      int identifier = board[i][j].getIdentifier();

      if (whiteToMove()) {
        if (identifier % 2 == 0) {
          pickupPiece(i, j);
        } else {
          this.message = "It is white to move";
        }
      }
      else {
        if (identifier % 2 == 1) {
          pickupPiece(i, j);
        } else {
          this.message = "It is black to move";
        }
      }
    }

    return selected;
  }

  public boolean pieceIsSelected() {
    return this.selected;
  }

  public void toggleWhoseTurn() {
    if (whiteToMove()) {
      this.whitesTurn = false;
    } else {
      this.whitesTurn = true;
    }
  }

  public boolean whiteToMove() {
    return this.whitesTurn;
  }

  public Piece getStatus(int i, int j) {
    return this.board[i][j];
  }

  public String getMessage() {
    return this.message;
  }

  void initBoard() {
    board[0][0] = new Rook(0, 0, false);
    board[0][1] = new Knight(0, 1, false);
    board[0][2] = new Bishop(0, 2, false);
    board[0][3] = new Queen(0, 3, false);
    board[0][4] = new King(0, 4, false);
    board[0][5] = new Bishop(0, 5, false);
    board[0][6] = new Knight(0, 6, false);
    board[0][7] = new Rook(0, 7, false);

    board[7][0] = new Rook(7, 0, true);
    board[7][1] = new Knight(7, 1, true);
    board[7][2] = new Bishop(7, 2, true);
    board[7][3] = new Queen(7, 3, true);
    board[7][4] = new King(7, 4, true);
    board[7][5] = new Bishop(7, 5, true);
    board[7][6] = new Knight(7, 6, true);
    board[7][7] = new Rook(7, 7, true);

    for (int i = 0; i < 2; i++) {
      for (int j = 0; j < 8; j++) {
        if (i == 0) {
          board[1][j] = new Pawn(1, j, false);
        }
        else if (i == 1) {
          board[6][j] = new Pawn(6, j, true);
        }
      }
    }

    this.identifyLegalMoves(); // init all possible moves for the pieces
  }

  public ChessGame() {
    // Create pieces, set up basic board starting position.
    initBoard();
    // updatePieceMoves(); // Updates all pieces' legal moves.
  }

}
