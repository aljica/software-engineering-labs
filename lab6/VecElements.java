import java.util.*;

class VecElements<E extends Comparable<E>> implements SparseVec<E> {
  public TreeMap<Integer, E> tree =
    new TreeMap<Integer, E>(); // Object? Questionable.

  @Override
  public void add(E elem) {
    return;
  }

  public void add(int pos, E elem) {
    this.tree.put(pos, elem);
  }

  public int indexOf(E elem) {
    return 0;
  }

  public void removeAt(int pos) {
    return this.tree.remove(pos);
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
    return "";
  }

  public E get(int pos) {
    return this.tree.get(pos);
  }

  public Object[] toArray() {
    return null;
  }

  public List<E> sortedValues() {
    return null;
  }

}
