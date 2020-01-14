import java.util.*;

class VecElement<E extends Comparable<E>> implements SparseVec<E> {

  private int index;
  private E item;
  private static TreeMap<Integer, Object> tree = new TreeMap<>(); // Object? Questionable.

  public VecElement(int index, E item) {
    this.index = index;
    this.item = item;
  }

  @Override
  public void add(E elem) {
    return;
  }

  public void add(int pos, E elem) {
    return;
  }

  public int indexOf(E elem) {
    return 0;
  }

  public void removeAt(int pos) {
    return;
  }

  public void removeElem(E elem) {
    return;
  }

  public int size() {
    return 0;
  }

  public int minIndex() {
    return 0;
  }

  public int maxIndex() {
    return 0;
  }

  public String toString() {
    return "";
  }

  public E get(int pos) {
    return null;
  }

  public Object[] toArray() {
    return null;
  }

  public List<E> sortedValues() {
    return null;
  }

}
