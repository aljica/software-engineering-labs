class Leaf extends Component {

  Leaf(String name, int weight) {
    this.name = name;
    this.weight = weight;
  }

  public int getWeight() {
    return this.weight;
  }

  public String toString() {
    return this.name;
  }

}
