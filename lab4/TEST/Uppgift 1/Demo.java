class Demo {

  public static void main(String[] args) {

    Composite suitcase = new Composite("Suitcase", 15);

    Composite hygieneBag = new Composite("Hygiene Bag", 5);
    Composite plasticBag = new Composite("Plastic Bag", 1);
    Leaf schampo = new Leaf("Schampo", 3);
    Leaf toothPaste = new Leaf("Tooth Paste", 2);
    Leaf toothBrush = new Leaf("Tooth Brush", 2);

    Composite sportsBag = new Composite("Sports Bag", 7);
    Composite shoesBag = new Composite("Shoes bag", 2);
    Leaf shoes = new Leaf("Shoes", 4);
    Leaf tshirt = new Leaf("T-Shirt", 1);

    suitcase.add(sportsBag);
    sportsBag.add(tshirt);
    sportsBag.add(shoesBag);
    shoesBag.add(shoes);

    suitcase.add(hygieneBag);
    hygieneBag.add(schampo);
    hygieneBag.add(plasticBag);
    plasticBag.add(toothPaste);
    plasticBag.add(toothBrush);

    System.out.println(suitcase);
    System.out.println(suitcase.getWeight());

    suitcase.remove(hygieneBag);
    System.out.println(suitcase);
    System.out.println(suitcase.getWeight());
  }

}
