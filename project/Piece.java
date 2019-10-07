import java.awt.*;
import javax.swing.*;

class Piece extends JButton {

  private int i;
  private int j;

  Piece(int i, int j, Color c) {
    this.i = i;
    this.j = j;

    setBackground(c);
    setVisible(true);
  }

}
