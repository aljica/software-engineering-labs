import static org.junit.Assert.*;

import org.junit.Test;

public class VecTest {

  @Test
  public void testBasics() {
    /* Tests size(), minIndex(), maxIndex() */
    Vec<Integer> vec = new Vec<>();
    assertEquals(0, vec.size());
    assertEquals(-1, vec.minIndex());
    assertNull(vec.get(3));
    assertNull(vec.sortedValues());
    assertNull(vec.toArray());
  }

  @Test
  public void testAddAndRemove() {
    Vec<Integer> vec = new Vec<>();

    // Test add with specifying position
    vec.add(0, 1900);
    assertEquals(1, vec.size());
    vec.add(1, 1901);
    assertEquals(2, vec.size());
    vec.add(50, 2079);
    assertEquals(3, vec.size());
    vec.add(7, 1601);
    assertEquals(4, vec.size());
    vec.add(13, 1400);
    assertEquals(5, vec.size());

    vec.add(13, 1500);
    assertEquals(5, vec.size());
    assertEquals(0, vec.minIndex());
    assertEquals(50, vec.maxIndex());

    vec.add(50, 2080);
    assertEquals(5, vec.size());
    assertEquals(0, vec.minIndex());
    assertEquals(50, vec.maxIndex());

    vec.add(17, 6000);
    assertEquals(6, vec.size());
    assertEquals(0, vec.minIndex());
    assertEquals(50, vec.maxIndex());

    // Test add without specifying position
    vec.add(5000);
    assertEquals(7, vec.size());
    assertEquals(5000, vec.get(2).intValue()); // Index 2, because that was the lowest unoccupied index when we did vec.add().
    assertNull(vec.get(19));

    // Test remove by specifying index
    vec.removeAt(0);
    assertEquals(6, vec.size());
    assertEquals(1, vec.minIndex());
    assertEquals(50, vec.maxIndex());

    vec.removeAt(50);
    assertEquals(5, vec.size());
    assertEquals(1, vec.minIndex());
    assertEquals(17, vec.maxIndex());

    // Test remove without specifying index
    vec.removeElem(6000); // Has index 17.
    assertEquals(4, vec.size());
    assertEquals(13, vec.maxIndex());
    assertNull(vec.get(17));
  }

  @Test
  public void stringTests() {
    Vec<String> vec = new Vec<>();
    vec.add(0, "Hello");
    vec.add(1, "All");
    assertEquals(0, vec.indexOf("Hello"));
    assertEquals("Hello", vec.get(0));
  }

}
