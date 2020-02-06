package cs271.lab.list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestPerformance {

  // TODO run test and record running times for SIZE = 10, 100, 1000, 10000
  //  which of the two lists performs better as the size increases?
  private final int SIZE = 10000;
  //size 1 112 ms
  //size 10 139 ms
  //size 100 134 ms
  //size 1000 494 ms
  //size 10000 5446 ms
  //Answer to the question: ArrayListAccess and LinkedListAddRemove performs better as size increases.

  private final int REPS = 1000000;

  private List<Integer> arrayList;

  private List<Integer> linkedList;

  @Before
  public void setUp() throws Exception {
    arrayList = new ArrayList<Integer>(SIZE);
    linkedList = new LinkedList<Integer>();
    for (int i = 0; i < SIZE; i++) {
      arrayList.add(i);
      linkedList.add(i);
    }
  }

  @After
  public void tearDown() throws Exception {
    arrayList = null;
    linkedList = null;
  }

  @Test
  public void testLinkedListAddRemove() {
    for (int r = 0; r < REPS; r++) {
      linkedList.add(0, 77);
      linkedList.remove(0);
    }
  }

  @Test
  public void testArrayListAddRemove() {
    for (int r = 0; r < REPS; r++) {
      arrayList.add(0, 77);
      arrayList.remove(0);
    }
  }

  @Test
  public void testLinkedListAccess() {
    long sum = 0;
    for (int r = 0; r < REPS; r++) {
      sum += linkedList.get(r % SIZE);
    }
  }

  @Test
  public void testArrayListAccess() {
    long sum = 0;
    for (int r = 0; r < REPS; r++) {
      sum += arrayList.get(r % SIZE);
    }
  }
}