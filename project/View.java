import java.awt.*;
import javax.swing.*;

class View extends JFrame {

  //Boardgame game;
  private Piece[][] buttons;
  private JPanel chessPanel = new JPanel();
  private JPanel messagePan = new JPanel();
  private JFrame f = new JFrame();
  private int size;

  private void createSquares() {
    Color black = new Color(0,0,0);
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
        buttons[i][j] = piece;
      }
    }

    f.setVisible(true);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

  private void setFrameSize() {
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    int height = screenSize.height;
    int width = screenSize.width;
    f.setSize(width/2, height/2);
    f.setLocationRelativeTo(null);
  }

  View(int n) {
    size = n;
    buttons = new Piece[size][size];

    setFrameSize();
    f.setLayout(new GridLayout(1, 2));

    // Set up chess panel
    chessPanel.setLayout(new GridLayout(size, size));
    createSquares();
    f.add(chessPanel);

    ImageIcon icon = new ImageIcon("brook.png"); // need to get this to work
    buttons[0][0].setIcon(icon);

    // Set up message pan
    messagePan.setLayout(new GridLayout(1, 2));
    f.add(messagePan);
  }

  public static void main(String[] args) {
    new View(8);
  }

}
