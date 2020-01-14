class Main {

  public static void main(String[] u) {

    VecElements<Integer> v = new VecElements<>();
    v.add(0, 1720);
    v.add(1, 1700);
    v.add(10, 1900);

    Integer n = v.get(10);
    System.out.println(n.intValue());

    v.removeAt(10);
    v.add(1950);

  }

}
