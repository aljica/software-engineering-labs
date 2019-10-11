import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;

class ViewControl extends JFrame implements ActionListener {

  private ChessGame game;
  private Square[][] board = new Square[8][8];
  private JPanel chessPanel = new JPanel();
  private JFrame f = new JFrame();

  private JPanel infoPanel = new JPanel();
  private String msg;
  private JLabel text = new JLabel();

  void updateMessage() {
    msg = game.updateMsg();
    text.setText(msg);
  }

  public void actionPerformed(ActionEvent e) {

    Square square = (Square) e.getSource();
    boolean moveWasSuccess = game.move(square.geti(), square.getj());

    if (moveWasSuccess) {
      this.updateMessage();
      boolean moveWasSelection = game.pieceIsSelected();
      if (moveWasSelection) {
        return;
      }
      game.identifyLegalMoves();

      // Just for testing purposes, printing all squares on
      // our board
      Piece p;
      for (int a = 0; a < 8; a++) {
        for (int b = 0; b < 8; b++) {
          p = game.getStatus(a, b);
          if (p==null) {
            System.out.println("null");
          } else {
            System.out.println(p);
            System.out.print(p.geti() + " ");
            System.out.println(p.getj() + " ");

            ArrayList<ArrayList<Integer>> tmp =
              new ArrayList<ArrayList<Integer>>();
            tmp = p.getLegalMoves();
            System.out.print("size of tmp ");
            System.out.println(tmp.size() + " ");
            for (int c = 0; c < tmp.size(); c++) {
              System.out.print(tmp.get(c).get(0) + " ");
              System.out.println(tmp.get(c).get(1) + " ");
            }
            System.out.println();
          }
        }
      }

      // Test captured pieces:
      ArrayList<Piece> captured = game.getCapturedPieces();
      for (Piece piece : captured) {
        System.out.println("Captured pieces: ");
        System.out.println(piece);
        System.out.print(piece.geti() + " ");
        System.out.println(piece.getj() + " ");
      }
      /* END testing purposes */
      updateStatus();
    }
    else {
      if (game.pieceIsSelected()) {
        this.text.setText("Cannot move there");
      }
      else {
        this.updateMessage();
      }
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
    this.chessPanel.setLayout(new GridLayout(8, 8));
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
        this.board[i][j] = square;
        this.chessPanel.add(square);
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
    f.add(this.chessPanel);

    // Work on this later
    this.infoPanel.setLayout(new GridLayout(2, 2));
    this.infoPanel.add(this.text, BorderLayout.NORTH);
    f.add(this.infoPanel);

    // Btn action listeners
    setBtnListeners();

    // Update chess panel (board) status
    updateStatus();
    updateMessage();
  }

  public static void main(String[] args) {
    ChessGame game = new ChessGame();
    new ViewControl(game);
  }

}
