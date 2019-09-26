package human;

public abstract class Human {

  Human() {
  } // Not specifying access modifier disables us from
  // instantiating new Human() {} in Demo.java.

  public static Human create(String name, String pnr) {

    int identifier = Integer.parseInt(String.valueOf(pnr.charAt(10)));

    if (identifier == 0) {
      return new NonBinary(name);
    }
    else if (identifier%2 == 1) {
      return new Man(name);
    }
    else {
      return new Woman(name);
    }

  }

}
