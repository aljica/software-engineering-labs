import java.util.*;

class Demo {

  public static void main(String[] args) {

    Composite suitcase = new Composite("Suitcase");

    Composite hygieneBag = new Composite("Hygiene Bag");
    Composite plasticBag = new Composite("Plastic Bag");
    Leaf schampo = new Leaf("Schampo");
    Leaf toothPaste = new Leaf("Tooth Paste");
    Leaf toothBrush = new Leaf("Tooth Brush");

    Composite sportsBag = new Composite("Sports Bag");
    Composite shoesBag = new Composite("Shoes bag");
    Leaf shoes = new Leaf("Shoes");
    Leaf tshirt = new Leaf("T-Shirt");

    suitcase.add(sportsBag);
    sportsBag.add(tshirt);
    sportsBag.add(shoesBag);
    shoesBag.add(shoes);

    suitcase.add(hygieneBag);
    hygieneBag.add(schampo);
    hygieneBag.add(plasticBag);
    plasticBag.add(toothPaste);
    plasticBag.add(toothBrush);

    Iterator<Component> itr = suitcase.iterator();
    while (itr.hasNext()) {
      Component t = itr.next();
      System.out.println(t.getName());
    }

    for (Component item : suitcase) {
      System.out.println(item.getName());
    }
  }

}
