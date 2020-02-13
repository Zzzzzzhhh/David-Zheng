package main.java.edu.luc.cs271.wordcount;
import java.util.HashMap;
import static org.junit.Assert.*;
import java.util.Arrays;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestWordCounter {

  // DONE complete this test class

  // DONE declare a reference to the SUT (system under test), i.e., WordCounter
  private WordCounter words;
  
  @Before
  public void setUp() {
    words= new WordCounter( new HashMap<>());
  }  // DONE create the SUT instance

  @After
  public void tearDown() {
    words = null;
  }  // DONE set the SUT instance to null

  @Test
  public void testGetCountEmpty() {
    assertTrue(words.getCounts().isEmpty());

  } //DONE verify that the SUT initially returns an empty map DONE

  @Test
  public void testGetCountNonEmpty() {
    words.countWords( Arrays.asList("Hello","word", "juts", "what", "up","Hello").iterator());
    assertEquals(words.getCount("Hello"), 2);
    assertEquals(words.getCount("word"), 1);
    assertEquals(words.getCount("juts"), 1);
    assertEquals(words.getCount("tongli"), 0);

    // DONE run the SUT on a specific String iterator with some repeated words
    // then use assertions to verify the correct counts
    // do this for at least two words in the iterator and two not in the iterator
    //fail();

  }
}
