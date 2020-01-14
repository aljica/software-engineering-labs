import java.util.*;
import java.lang.StringBuilder;

class VecElements<E extends Comparable<E>> implements SparseVec<E> {

  public TreeMap<Integer, E> tree =
    new TreeMap<Integer, E>();

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
    return this.tree.firstKey();
  }

  public int maxIndex() {
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
