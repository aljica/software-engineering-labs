import java.util.*;

class PreorderIterator implements Iterator<Component> {

  ArrayList<Component> dfs = new ArrayList<Component>();

  PreorderIterator(Composite root) {
    dfs.add(root);
    populate(root.getItems());
  }

  public void populate(ArrayList<Component> items) {
    for (Component item : items) {
      dfs.add(item);
      if (!(item.getItems() == null)) {
        populate(item.getItems());
      }
    }
  }

  public boolean hasNext() {
    if (!dfs.isEmpty()) {
      return true;
    }
    return false;
  }

  public Component next() {
    if (hasNext()) {
      Component nextItem = dfs.get(0);
      dfs.remove(0);
      return nextItem;
    }
    return null;
  }

}
