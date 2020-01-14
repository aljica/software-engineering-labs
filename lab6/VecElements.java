import java.util.*;
import java.lang.StringBuilder;

class VecElements<E extends Comparable<E>> implements SparseVec<E> {

  public TreeMap<Integer, E> tree =
    new TreeMap<Integer, E>();

  public static void main(String[] args) {
    VecElements<Integer> vec = new VecElements<>();
    vec.add(0, 5000);
    vec.add(17, 3000);
    vec.add(21, 3050);
    vec.add(3, 10000);
    vec.add(7, 900);

    System.out.println(vec);
    Object[] arr = vec.toArray();
    List<Integer> values = vec.sortedValues();
    System.out.println(values);

    // Test result of toArray()
    int i = 0;
    for (Object o : arr) {
      System.out.print(o);
      System.out.println(" " + i++);
    }
  }

  public void add(E elem) {
    Set<Map.Entry<Integer, E>> mappings = this.tree.entrySet();
    Iterator<Map.Entry<Integer, E>> itr = mappings.iterator();

    int lowestindex = 0; // Assume lowest possible unoccupied index is 0.
    while (itr.hasNext()) {
      int key = itr.next().getKey();
      if (lowestindex == key) lowestindex++;
      else break; // We have found the unoccupied lowest index.
    }
    this.tree.put(lowestindex, elem);
  }

  public void add(int pos, E elem) {
    this.tree.put(pos, elem);
  }

  public int indexOf(E elem) {
    Set<Map.Entry<Integer, E>> mappings = this.tree.entrySet();
    Iterator<Map.Entry<Integer, E>> itr = mappings.iterator();

    while (itr.hasNext()) {
      Map.Entry<Integer, E> item = itr.next();
      int key = item.getKey();
      E element = item.getValue();
      int comparison = element.compareTo(elem);
      if (comparison == 0) return key;
    }
    return -1;
  }

  public void removeAt(int pos) {
    this.tree.remove(pos);
  }

  public void removeElem(E elem) {
    int pos = this.indexOf(elem);
    this.removeAt(pos);
  }

  public int size() {
    return this.tree.size();
  }

  public int minIndex() {
    if (this.size() == 0) return -1;
    return this.tree.firstKey();
  }

  public int maxIndex() {
    if (this.size() == 0) return -1;
    return this.tree.lastKey();
  }

  public String toString() {
    Set<Map.Entry<Integer, E>> mappings = this.tree.entrySet();
    Iterator<Map.Entry<Integer, E>> itr = mappings.iterator();

    StringBuilder s = new StringBuilder(100000);
    while (itr.hasNext()) {
      Map.Entry<Integer, E> item = itr.next();
      int key = item.getKey();
      E element = item.getValue();
      s.append("Key: ");
      s.append(key);
      s.append(" Value: ");
      s.append(element);
      s.append("\n");
    }
    return s.toString();
  }

  public E get(int pos) {
    return this.tree.get(pos);
  }

  public Object[] toArray() {
    if (this.size() == 0) return null;

    Set<Map.Entry<Integer, E>> mappings = this.tree.entrySet();
    Iterator<Map.Entry<Integer, E>> itr = mappings.iterator();

    Object[] arr = new Object[this.maxIndex() + 1];
    Map.Entry<Integer, E> item = itr.next();
    for (int i = 0; i < arr.length; i++) {
      if (item.getKey() == i) {
        arr[i] = item.getValue();
        if (itr.hasNext()) item = itr.next();
      } else {
        arr[i] = null;
      }
    }
    return arr;
  }

  public List<E> sortedValues() {
    if (this.size() == 0) return null;

    Set<Map.Entry<Integer, E>> mappings = this.tree.entrySet();
    Iterator<Map.Entry<Integer, E>> itr = mappings.iterator();
    List<E> values = new ArrayList<>();

    while (itr.hasNext()) {
      Map.Entry<Integer, E> item = itr.next();
      values.add(item.getValue());
    }

    Collections.sort(values);
    return values;
  }

}
