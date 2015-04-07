import junit.framework.TestCase;

/**
 * A JUnit test case class.
 * Every method starting with the word "test" will be called when running
 * the test with JUnit.
 */
public class TableTest extends TestCase {
  
  /**
   * A test method.
   * (Replace "X" with a name describing the test.  You may write as
   * many "testSomething" methods in this class as you wish, and each
   * one will be called when running JUnit over this class.)
   */
  public void testBareClass() {
    Table table = new Table();
    
    assertEquals(null, table.getCard(0));
    assertEquals(0, table.numCards());
    assertEquals(0, table.numSets());
  }
  
  public void testOneCard() {
    Table table = new Table();
    Card card = new Card(1, 1, 1, 1);
    
    table.add(card);
    
    assertEquals(card, table.getCard(0));
    assertEquals(1, table.numCards());
    assertEquals(0, table.numSets());
  }
}
