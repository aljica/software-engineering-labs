// Extrauppgiften

package framebuttons;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Window extends JFrame implements ActionListener {

  MyButton[] allButtons;

  public Window(int numButtons, String[] labelData) {
    allButtons = new MyButton[numButtons];
    setSize(300, 300);
    setVisible(true);

    Container c = getContentPane();
    c.setLayout(new FlowLayout());
    c.setBackground(Color.white);

    for (int i=0; i<numButtons; i++) {
      MyButton b = new MyButton(Color.red, Color.green, labelData[2*i], labelData[2*i+1]);
      allButtons[i] = b; allButtons[i].addActionListener(this);
      add(allButtons[i]);
    }

    // Helt annan konstruktion:
    /*for (int i=0; i<allButtons.length; i++) {
      final int k = i;
      allButtons[i].addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          for (int j=0; j<allButtons.length; j++) {
            if (k != j) {
              allButtons[j].toggleState();
            }
          }
        }
      });
    }*/

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

  public void actionPerformed(ActionEvent e) {
    MyButton btmp = (MyButton) e.getSource();
    for (MyButton b : allButtons) {
      if (b == btmp) continue;
    b.toggleState();
    }
  }

}
