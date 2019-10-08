import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class ViewControl extends JFrame {

  private ChessGame game;
  private Square[][] board;

  JFrame f = new JFrame();

  private void setFrameSize() {
      Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
      int height = screenSize.height;
      int width = screenSize.width;
      f.setSize(width/2, height/2);
      f.setLocationRelativeTo(null); // Center frame
    }

  ViewControl(ChessGame game) {
    this.game = game;

    setFrameSize();
  }

}
