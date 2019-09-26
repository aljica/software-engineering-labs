// DFS

import java.util.*;

public class ItemIterator implements Iterator<ItemComponent> {

  ArrayList<ItemComponent> dfs = new ArrayList<ItemComponent>();
  ItemComponent container;
  int position = 0;
  int length;

  public ItemIterator(ItemComponent newContainer) {
    container = newContainer; // Setting root as class var
    dfs.add(container); // Adding root as first item in tree

    ArrayList<ItemComponent> containerItems = container.getItems();
    populateDfs(containerItems);

    length = dfs.size();
  }

  // Recursive solution, differs from BFS.
  public void populateDfs(ArrayList<ItemComponent> containerItems) {
    for (ItemComponent item : containerItems) {
      dfs.add(item);
      if (item instanceof Container) {
        populateDfs(item.getItems());
      }
    }
  }

  public boolean hasNext() {
    if (position<length) {
      return true;
    }
    return false;
  }

  public ItemComponent next() {
    if (hasNext()) {
      ItemComponent dfsNext = dfs.get(0);
      dfs.remove(0);
      position++;
      return dfsNext;
    }
    return null;
  }

}
