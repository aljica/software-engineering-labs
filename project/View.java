import java.awt.*;
import javax.swing.*;

class View extends JFrame {

  //Boardgame game;
  private Piece[][] board;
  private JPanel chessPanel = new JPanel();
  private JPanel messagePan = new JPanel();
  private JFrame f = new JFrame();
  private int size;

  // Add piece objects to our chessPanel and to our board matrix.
  private void createSquares() {
    Color black = new Color(190,97,78);
    Color white = new Color(255,255,255);
    Color c = black;

    for (int i = 0; i<size; i++) {
      for (int j = 0; j<size; j++) {

        if (i%2 == 0) {
          if (j%2 == 0) {
            c = white;
          } else {
            c = black;
          }
        }

        else if (i%2 == 1) {
          if (j%2 == 0) {
            c = black;
          } else {
            c = white;
          }
        }

        Piece piece = new Piece(i, j, c);
        chessPanel.add(piece);
        board[i][j] = piece;
      }
    }
  }

  private void setFrameSize() {
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    int height = screenSize.height;
    int width = screenSize.width;
    f.setSize(width/2, height/2);
    f.setLocationRelativeTo(null); // Center frame
  }

  // Set images to each of our piece objects in our board matrix.
  private void setIcons() {
    board[0][0].setIcon(new ImageIcon("./img/brook.png"));
    board[0][1].setIcon(new ImageIcon("./img/bknight.png"));
    board[0][2].setIcon(new ImageIcon("./img/bbishop.png"));
    board[0][3].setIcon(new ImageIcon("./img/bqueen.png"));
    board[0][4].setIcon(new ImageIcon("./img/bking.png"));
    board[0][5].setIcon(new ImageIcon("./img/bbishop.png"));
    board[0][6].setIcon(new ImageIcon("./img/bknight.png"));
    board[0][7].setIcon(new ImageIcon("./img/brook.png"));
    for (int j = 0; j < size; j++) {
      board[1][j].setIcon(new ImageIcon("./img/bpawn.png"));
    }

    board[7][0].setIcon(new ImageIcon("./img/rook.png"));
    board[7][1].setIcon(new ImageIcon("./img/knight.png"));
    board[7][2].setIcon(new ImageIcon("./img/bishop.png"));
    board[7][3].setIcon(new ImageIcon("./img/queen.png"));
    board[7][4].setIcon(new ImageIcon("./img/king.png"));
    board[7][5].setIcon(new ImageIcon("./img/bishop.png"));
    board[7][6].setIcon(new ImageIcon("./img/knight.png"));
    board[7][7].setIcon(new ImageIcon("./img/rook.png"));
    for (int j = 0; j < size; j++) {
      board[6][j].setIcon(new ImageIcon("./img/pawn.png"));
    }
  }

  private void startNewGame() {
    // Basic board setup, chess starting position.
    createSquares();
    setIcons();
  }

  View(int n) {
    size = n;
    board = new Piece[size][size];

    setFrameSize();
    f.setLayout(new GridLayout(1, 2));
    f.setVisible(true);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // Set up chess panel and add to frame
    chessPanel.setLayout(new GridLayout(size, size));
    f.add(chessPanel);

    // Set up message pan and add to frame
    messagePan.setLayout(new GridLayout(1, 2));
    f.add(messagePan);

    // Start new game
    startNewGame();
    /*
    This isn't how we should be doing this. It's fundamentally wrong.
    We are mixing logic with the GUI. Not good.
    In this class we are only supposed to use updateStatus() through
    the CheckeredBoardgame interface.
    */
  }

  public static void main(String[] args) {
    new View(8);
  }

}
