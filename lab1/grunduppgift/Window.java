import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Window extends JFrame {

  public Window() {
    setSize(300, 300);
    setVisible(true);

    Container c = getContentPane();
    c.setLayout(new FlowLayout());
    c.setBackground(Color.white);

    JLabel name = new JLabel("Almir");
    add(name);

    MyButton b = new MyButton(Color.red, Color.green, "STOP", "GO");
    MyButton b2 = new MyButton(Color.yellow, Color.blue, "Hi!", "Bye!");
    add(b); add(b2);

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

}
