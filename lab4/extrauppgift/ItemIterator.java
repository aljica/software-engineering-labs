// BFS

import java.util.*;

public class ItemIterator implements Iterator<ItemComponent> {

  ArrayList<ItemComponent> bfs = new ArrayList<ItemComponent>();
  ItemComponent container;

  public ItemIterator(ItemComponent newContainer) {
    container = newContainer; // Setting root as class var
    bfs.add(container); // Adding root as first item in tree
  }

  public boolean hasNext() {
    if (bfs.isEmpty()) {
      return false;
    }
    return true;
  }

  public ItemComponent next() {
    if (hasNext()) {
      ItemComponent bfsNext = bfs.get(0);

      if (container instanceof Container) {
        for (ItemComponent item : container.getItems()) {
          bfs.add(item);
        }
      }

      bfs.remove(0);
      if (hasNext()) {
        container = bfs.get(0);
      }
      return bfsNext;
    }
    return null;
  }

}
