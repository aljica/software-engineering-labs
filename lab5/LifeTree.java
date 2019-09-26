import javax.swing.*;
import javax.swing.tree.*;
import java.io.*;
import java.util.*;

class LifeTree extends TreeFrame {

  DefaultMutableTreeNode2 root;
  static Scanner sc;
  static String fileName = "Life.txt";

  void initTree() {
    sc.nextLine(); // Get rid of <?xml-tag.
    root = createNode(sc.nextLine()); // Create root node
    treeModel = new DefaultTreeModel(root);
    tree = new JTree(treeModel);
    buildTree(sc.nextLine(), root);
  }

  DefaultMutableTreeNode2 createNode(String line) {
    String openingLevel = line.substring(line.indexOf("<")+1,
      line.indexOf(" namn"));
    String name = line.substring(line.indexOf("=\"")+2,
      line.indexOf(">")-1);
    String text = line.substring(line.indexOf("> ")+2,
      line.length());

    return new DefaultMutableTreeNode2(name, openingLevel, text);
  }

  void buildTree(String line, DefaultMutableTreeNode2 parent) {

    if (line.substring(0, 2).equals("</")) {
      if (line.substring(line.indexOf("/")+1,
        line.indexOf(">")).equals(parent.fetchLevel())) {
          if (sc.hasNextLine()) {
            DefaultMutableTreeNode2 p =
              (DefaultMutableTreeNode2) parent.getParent();
            buildTree(sc.nextLine(), p);
          }
          return;
      }
    }
    else {
      DefaultMutableTreeNode2 child = createNode(line);
      parent.add(child);
      if (sc.hasNextLine()) {
        buildTree(sc.nextLine(), child);
      }
    }
  }

  void showDetails(TreePath path){
    if (path == null)
        return;

    DefaultMutableTreeNode2 node = (DefaultMutableTreeNode2) path.getLastPathComponent();
    String info = node.fetchLevel() + ": " + node.toString() + " " + node.fetchText() + "\n";
    String extraInfo = "Men allt som ar " + node.toString();
    while (node.getParent() != null) {
      node = (DefaultMutableTreeNode2) node.getParent();
      extraInfo = extraInfo + " ar " + node.toString();
    }
    info += extraInfo;
    JOptionPane.showMessageDialog(this, info);
  }

  public static void main(String[] args) {
    if (args.length>0) {
      fileName = args[0];
    }

    try {
      sc = new Scanner(new File(fileName));
    }
    catch (Exception e) {
      System.exit(0);
    }

    new LifeTree();
  }

}
