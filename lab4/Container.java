// Container = behållare på svenska
// Composite class

import java.util.*;

public class Container extends ItemComponent {

  ArrayList<ItemComponent> containerItems = new ArrayList<ItemComponent>();

  String containerName;
  int containerWeight;

  public Container(String name, int weight) {
    containerName = name;
    containerWeight = weight;
  }

  public void add(ItemComponent newItemComponent) {
    containerItems.add(newItemComponent);
  }

  public void remove(ItemComponent newItemComponent) {
    containerItems.remove(newItemComponent);
  }

  public int getWeight() {
    // Must calculate weight of container + all items in container.

    int totalWeight = containerWeight;
    for (int i=0; i<containerItems.size(); i++) {
      totalWeight += containerItems.get(i).getWeight();
    }

    return totalWeight;
  }

  public String toString() {
    // Must get name of container + names of all items in container.

    String allItems = "Name of Container: " + containerName + "\n";
    for (int i=0; i<containerItems.size(); i++) {
      allItems += containerItems.get(i).toString() + "\n";
    }

    return allItems;
  }

}
