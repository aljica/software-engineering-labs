class NumberedItem<T> {

  private T item;
  private int index;

  public NumberedItem(int index, T item) {
    this.item = item;
    if (index < 0) this.index = 0;
    else this.index = index;
  }

  public int getIndex() {
    return this.index;
  }

  public int compareTo(NumberedItem<T> o) {
    return this.getIndex() - o.getIndex();
  }

  public boolean equals(NumberedItem<T> o) {
    if (o == null) return false;

    if (this.getIndex() - o.getIndex() == 0) return true;
    return false;
  }

  public String toString() {
    return "Index: " + this.index + " Value: " + this.item;
  }

}
