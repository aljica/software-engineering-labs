import java.awt.*;
import javax.swing.*;

class Test extends JFrame {

  JButton[][] buttons = new JButton[8][8];

  Test() {
    JFrame f = new JFrame();
    f.setSize(1000, 1000);

    JPanel panel = new JPanel();
    panel.setLayout(new GridLayout(8, 8));
    f.add(panel);

    Color black = new Color(0,0,0);
    Color white = new Color(255,255,255);
    Color c = black;

    for (int i = 0; i<8; i++) {
      for (int j = 0; j<8; j++) {

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

        JButton button = new JButton();
        button.setBackground(c);
        panel.add(button);
        buttons[i][j] = button;
      }
    }

    f.setVisible(true);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

  public static void main(String[] args) {
    new Test();
  }

}
