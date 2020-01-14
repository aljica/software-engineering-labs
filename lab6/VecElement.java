import java.util.*;

class VecElement<E extends Comparable<E>> implements SparseVec<E extends Comparable<E>> {

  private int index;
  private E item;
  private TreeMap<K,V> tree = new TreeMap<K,V>();

  public VecElement(int index, E item) {
    this.index = index;
    this.item = item;
  }

}
