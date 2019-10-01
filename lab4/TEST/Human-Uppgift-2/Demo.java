import human.*;

public class Demo {

  public static void main(String[] args) {

    Human billie = Human.create("Billie", "990101-5600");
    Human anna = Human.create("Anna", "920202-5602");
    Human magnus = Human.create("Magnus", "910303-5601");
    System.out.println(billie);
    System.out.println(anna);
    System.out.println(magnus);

    //Human h = new Human() {}; // HOW to get this NOT to compile?????

    /*
    Man m = new Man("hi");
    System.out.println(m);
    Human man = new Man("man");
    System.out.println(m2);
    Human w = new Woman("woman");
    System.out.println(w);
    Human nb = new NonBinary("nb");
    System.out.println(nb);

    /*
    Man is not public in package human (we don't use any access
    modifier in class declaration), thus cannot instantiate these.
    */

  }

}
