class ChessGame {

  Piece[][] board = new Piece[8][8];
  private Piece chosenPiece;
  private boolean selected = false;

  public boolean select(int i, int j) {
    if (board[i][j] != null) {
      chosenPiece = board[i][j];
      selected = true;
    }
    return selected;
  }

  public Piece getStatus(int i, int j) {
    return board[i][j];
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
          board[1][j] = new Pawn(i, j, false);
        }
        else if (i == 1) {
          board[6][j] = new Pawn(i, j, true);
        }
      }
    }
  }

  public ChessGame() {
    // Create pieces, set up basic board starting position.
    initBoard();
    // updatePieceMoves(); // Updates all pieces' legal moves.
  }

/*  public static void main(String[] args) {
    new ChessGame();
  }*/

}
