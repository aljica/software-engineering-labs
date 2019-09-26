// Component class

public abstract class ItemComponent {

  // Allows us to add items
  public void add(ItemComponent newItemComponent) {
    throw new UnsupportedOperationException();
  }

  // Allows us to remove items
  public void remove(ItemComponent newItemComponent) {
    throw new UnsupportedOperationException();
  }

  // Get weight of item (total weight if items in item)
  public int getWeight() {
    throw new UnsupportedOperationException();
  }

  // Display info about item (including items in item)
  public String toString() {
    throw new UnsupportedOperationException();
  }

}
