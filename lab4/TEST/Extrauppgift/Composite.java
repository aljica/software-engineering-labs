import java.util.*;

class Composite extends Component implements Iterable<Component> {

  ArrayList<Component> items = new ArrayList<Component>();

  Composite(String name) {
    this.name = name;
  }

  public Iterator<Component> iterator() {
    return new PreorderIterator(this);
  }

  public void add(Component item) {
    items.add(item);
  }

  public void remove(Component item) {
    items.remove(item);
  }

  public String getName() {
    return this.name;
  }

  public ArrayList<Component> getItems() {
    return this.items;
  }

}
