import java.util.*;

class Leaf extends Component {

  Leaf(String name) {
    this.name = name;
  }

  public String getName() {
    return this.name;
  }

  public ArrayList<Component> getItems() {
    return null;
  }

}
