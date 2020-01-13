import java.util.*;

class GenericList<E extends Comparable<E>> implements SparseVec<E extends Comparable<E>> {

  private int index;
  private E item;
  private TreeMap<K,V> tree = new TreeMap<K,V>();

  public GenericList(int index, E item) {
    this.index = index;
    this.item = item;
  }

}
