import java.util.*;

class BreadthIterator implements Iterator<Component> {

  ArrayList<Component> bfs = new ArrayList<Component>();

  BreadthIterator(Composite root) {
    bfs.add(root);
  }

  public boolean hasNext() {
    return !bfs.isEmpty();
  }

  public Component next() {
    if (hasNext()) {
      Component nextItem = bfs.get(0);
      bfs.remove(0);

      if (nextItem.getItems() == null) {
        return nextItem;
      }

      for (Component item : nextItem.getItems()) {
        bfs.add(item);
      }
      return nextItem;
    }
    return null;
  }

}
