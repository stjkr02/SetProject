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

  public void testNumCardsandGetCard() {
    Table table = new Table();
    
    Card card = new Card(1, 1, 1, 1);
    Card card1 = new Card(2, 2, 2, 2);
    Card card2 = new Card(3, 3, 3, 3);
    
    table.add(card);
    table.add(card1);
    table.add(card2);
    
    assertEquals(3, table.numCards());
    assertEquals(card, table.getCard(2));
    assertEquals(card1, table.getCard(1));
    assertEquals(card2, table.getCard(0));
  }

  public void testGetCardOutOfIndex() {
    Table table = new Table();
   
    Card card = new Card(1, 1, 1, 1);
    Card card1 = new Card(2, 2, 2, 2);
    Card card2 = new Card(3, 3, 3, 3);
   
    table.add(card);
    table.add(card1);
    table.add(card2);
    
    assertEquals(card2, table.getCard(0));
    assertEquals(card1, table.getCard(1));
    assertEquals(card, table.getCard(2));
    assertEquals(null, table.getCard(5));
    assertEquals(null, table.getCard(-10));
  }
                 

}
