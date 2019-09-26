public class Item extends ItemComponent {

  String itemName;
  int itemWeight;

  public Item(String name, int weight) {
    itemName = name;
    itemWeight = weight;
  }

  public int getWeight() {
    return itemWeight;
  }

  public String toString() {
    return "\tName of Item: " + itemName;
  }

}
