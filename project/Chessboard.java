import pieces.*;

class Chessboard implements CheckeredBoardgame {

  private Piece[][] board = new Piece[8][8];

  Chessboard() {
    Piece pawn = Piece.create("pawn");
    board[0][0] = pawn;
    Piece p = board[0][0];
    System.out.println(p.getI());

  }

  public boolean move(int i, int j) {
    return true;
  }

  public String getStatus(int i, int j) {
    return "Works";
  }

  public String getMessage() {
    return "OK";
  }

}
