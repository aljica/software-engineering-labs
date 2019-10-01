abstract class Component {

  String name;
  int weight;

  public abstract int getWeight();
  public abstract String toString();

  // Vi kan ha detta också. Förhindrar då Leaf från att ärva add() (?).
  /*public astract void add() {
    throw new UnsupportedOperationException();
  }*/

}
