import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class ViewControl extends JFrame {

  private Boardgame game;
  private int size;
  private Square[][] board; // Square är subklass till JButton (tänk MyButton)
  private JLabel mess = new JLabel();
  JPanel thePanel = new JPanel();

  public static void main(String[] u) {
    Boardgame game = new FifteenModel(); // See https://stackoverflow.com/questions/16750772/instantiating-interfaces-in-java
    //Boardgame game = null; // temporarily
    new ViewControl(game, 4); // For testing purposes.
  }

  ViewControl (Boardgame gm, int n) {
    this.game = gm;
    this.size = n;

    JFrame f = new JFrame();
    f.setSize(700, 700);

    thePanel.setLayout(null); // Could use GridLayout, maybe?
    f.add(thePanel);

    // Creating all the buttons.
    createButtons();

    // Updating game status.
    updateStatus();
    // Updating game message.
    mess.setBounds(100, 50, 1000, 50);
    thePanel.add(mess);

    f.setVisible(true);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

  void createButtons() {
    board = new Square[size][size];

    for (int i=0; i<size; i++) {
      for (int j=0; j<size; j++) {
        Square sq = new Square(i, j, " ");
        sq.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
            //sq.sendData(); // Method to perform move in model class.
            game.move(sq.i, sq.j);
            updateStatus();
            updateMessage();
          }
        });
        thePanel.add(sq);
        sq.setBounds(j*100+100, i*100+100, 100, 100); // j is column-based, i is row-based
        board[i][j] = sq; // Storing the square in our board.
      }
    }
  }

  void updateStatus() {
    String status;
    for (int i=0; i<size; i++) {
      for (int j=0; j<size; j++) {
        status = game.getStatus(i, j);
        //status = "hi";
        board[i][j].setText(status);
      }
    }
  }

  void updateMessage() {
    String msg = game.getMessage();
    mess.setText(msg);
  }

}
