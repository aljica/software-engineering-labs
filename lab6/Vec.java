// Assignment 2B
import java.util.*;
import java.lang.StringBuilder;

class Vec<E extends Comparable<E>> extends TreeMap<Integer, E> implements SparseVec<E> {

  public static void main(String[] args) {
    Vec<Integer> vec = new Vec<>();
    vec.add(0, 2000);
  }

  public void add(E elem) {
    Set<Map.Entry<Integer, E>> mappings = this.entrySet();
    Iterator<Map.Entry<Integer, E>> itr = mappings.iterator();

    int lowestindex = 0; // Assume lowest possible unoccupied index is 0.
    while (itr.hasNext()) {
      int key = itr.next().getKey();
      if (lowestindex == key) lowestindex++;
      else break; // We have found the unoccupied lowest index.
    }
    this.put(lowestindex, elem);
  }

  public void add(int pos, E elem) {
    this.put(pos, elem);
  }

  public int indexOf(E elem) {
    Set<Map.Entry<Integer, E>> mappings = this.entrySet();
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
    this.remove(pos);
  }

  public void removeElem(E elem) {
    int pos = this.indexOf(elem);
    this.removeAt(pos);
  }

  public int size() {
    return this.size();
  }

  public int minIndex() {
    if (this.size() == 0) return -1;
    return this.firstKey();
  }

  public int maxIndex() {
    if (this.size() == 0) return -1;
    return this.lastKey();
  }

  public String toString() {
    Set<Map.Entry<Integer, E>> mappings = this.entrySet();
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
    return this.get(pos);
  }

  public Object[] toArray() {
    if (this.size() == 0) return null;

    Set<Map.Entry<Integer, E>> mappings = this.entrySet();
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

    Set<Map.Entry<Integer, E>> mappings = this.entrySet();
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
