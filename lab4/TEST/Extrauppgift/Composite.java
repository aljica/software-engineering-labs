import java.util.*;

class Composite extends Component {

  ArrayList<Component> items = new ArrayList<Component>();

  Composite(String name, int weight) {
    this.name = name;
    this.weight = weight;
  }

  void add(Component item) {
    items.add(item);
  }

  void remove(Component item) {
    items.remove(item);
  }

  public int getWeight() {
    int totalWeight = this.weight;
    for (Component item : items) {
      totalWeight += item.getWeight();
    }
    return totalWeight;
  }

  public String toString() {
    String names = this.name;
    for (Component item : items) {
      names += "\n" + item;
    }
    return names;
  }

}
