// See MyButton.java... subclass of JButton!

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Square extends JButton {

  public int i;
  public int j;
  private String label;

  public Square(int i, int j, String label) {
    this.i = i;
    this.j = j;
    this.label = label;

    setText(label);
    setFont(new Font("Arial", Font.PLAIN, 40));

    setBackground(Color.green);
    setVisible(true);
    // We setbounds in ViewControl.
  }

  void sendData() {
    //System.out.println("i: " + i + " j: " + j);
    return;
  }

}
