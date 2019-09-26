public class SuitcaseDemo {

  public static void main(String[] args) {

    ItemComponent suitcase = new Container("Suitcase", 2000); //
    ItemComponent plasticBag = new Container("Plastic Bag", 1);
    ItemComponent goldBox = new Container("Gold Box", 20);
    ItemComponent hygieneBag = new Container("Hygiene Bag", 50);
    ItemComponent makeupBag = new Container("Makeup Bag", 30);
    ItemComponent toothPaste = new Item("Tooth Paste", 20);
    ItemComponent toothBrush = new Item("Tooth Brush", 10);
    ItemComponent makeup = new Item("Makeup", 12);
    ItemComponent mascara = new Item("Mascara", 10);
    ItemComponent phone = new Item("Phone", 30);
    ItemComponent radio = new Item("Radio", 100);
    ItemComponent gold = new Item("Gold", 10);

    ItemComponent accessoriesBag = new Container("Accessories Bag", 10);
    ItemComponent accessory1 = new Item("Accessory 1", 5);

    suitcase.add(plasticBag); suitcase.add(hygieneBag);

    hygieneBag.add(makeupBag); hygieneBag.add(toothPaste);
    hygieneBag.add(toothBrush);
    makeupBag.add(makeup); makeupBag.add(mascara);
    makeupBag.add(accessoriesBag);
    accessoriesBag.add(accessory1);

    plasticBag.add(goldBox); plasticBag.add(phone);
    plasticBag.add(radio);
    goldBox.add(gold);

    // Total vikt: 2308
    System.out.println(suitcase);
    System.out.println(suitcase.getWeight());

    suitcase.remove(plasticBag);
    // Ny vikt: 2147
    System.out.println(suitcase);
    System.out.println(suitcase.getWeight());

  }

}
