import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class ViewControl extends JFrame implements ActionListener {

  private ChessGame game;
  private Square[][] board = new Square[8][8];
  private JPanel chessPanel = new JPanel();
  private JPanel messagePan = new JPanel();
  private JFrame f = new JFrame();

  public void actionPerformed(ActionEvent e) {
    Square square = (Square) e.getSource();
    //game.identifyLegalMoves();
    boolean moveWasSuccess = game.move(square.geti(), square.getj());

    if (moveWasSuccess) {
      boolean moveWasSelection = game.pieceIsSelected();
      if (moveWasSelection) {
        return;
      }
      game.identifyLegalMoves();
      System.out.println("Updating status");
      updateStatus();
      // Also updateMessage() here (maybe a msg in right pane saying "SElected")
    } else {
      System.out.println("Something went wrong");
    }

  }

  void setBtnListeners() {
    Piece piece;
    Square square;
    for (int i = 0; i < 8; i++) {
      for (int j = 0; j < 8; j++) {
        square = board[i][j];
        square.addActionListener(this);
      }
    }
  }

  void updateStatus() {
    Piece piece;
    Square square;
    for (int i = 0; i < 8; i++) {
      for (int j = 0; j < 8; j++) {

        piece = game.getStatus(i, j);
        if (piece == null) {
          board[i][j].setIcon(null); // Not sure if necessary.
          continue;
        }
        square = board[i][j];

        int identifier = piece.getIdentifier();
        square.setImage(piece.getIdentifier());

      }
    }
  }

  void paintBoard() {
    chessPanel.setLayout(new GridLayout(8, 8));
    Color black = new Color(190,97,78);
    Color white = new Color(255,255,255);
    Color c = black;

    for (int i = 0; i < 8; i++) {
      for (int j = 0; j < 8; j++) {

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

        Square square = new Square(i, j, c);
        board[i][j] = square;
        chessPanel.add(square);
      }
    }
  }

  void setFrameSize() {
      Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
      int height = screenSize.height;
      int width = screenSize.width;
      f.setSize(width/2, height/2);
      f.setLocationRelativeTo(null); // Center frame
    }

  ViewControl(ChessGame game) {
    this.game = game;

    setFrameSize();
    f.setLayout(new GridLayout(1, 2));
    f.setVisible(true);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    paintBoard(); // Adds buttons to chess panel.
    f.add(chessPanel);

    // Work on this later
    f.add(messagePan);

    // Btn action listeners
    setBtnListeners();

    // Update chess panel (board) status
    updateStatus();
  }

  public static void main(String[] args) {
    ChessGame game = new ChessGame();
    new ViewControl(game);
  }

}
