import java.util.*;

class Main {

  public static void main(String[] u) {

    VecElements<Integer> v = new VecElements<>();
    v.add(0, 1720);
    v.add(1, 1700);
    v.add(3, 1900);

    System.out.println(v.toString());
    Object[] a = v.toArray();
    System.out.println(a[2]);

    v.sortedValues();
  }

}
