import javax.swing.*;
import javax.swing.tree.*;

class DefaultMutableTreeNode2 extends DefaultMutableTreeNode {

  String level;
  String text;

  public DefaultMutableTreeNode2(String name, String level, String text) {
    super(name);
    this.level = level;
    this.text = text;
  }

  public String fetchText() {
    return text;
  }

  public String fetchLevel() {
    return level;
  }

}
