import junit.framework.TestCase;

/**
 * A JUnit test case class.
 * Every method starting with the word "test" will be called when running
 * the test with JUnit.
 */
public class DeckTest extends TestCase {
  
  /**
   * A test method.
   * (Replace "X" with a name describing the test.  You may write as
   * many "testSomething" methods in this class as you wish, and each
   * one will be called when running JUnit over this class.)
   */
  public void testHasNextGetNext() {
    Deck deck = new Deck("3card.dat");
    
    Card card = new Card(1, 1, 1, 1);
    Card card1 = new Card(2, 2, 2, 2);
    Card card2 = new Card(3, 3, 3, 3);
    
    //Check the first position
    assertTrue(deck.hasNext());
    assertTrue(card.equals(deck.getNext()));
    
    //Check the second position
    assertTrue(deck.hasNext());
    assertTrue(card1.equals(deck.getNext()));  
               
    //Check the second position
    assertTrue(deck.hasNext());
    assertTrue(card2.equals(deck.getNext())); 
    
    //Make sure that nothing is left
    assertFalse(deck.hasNext());
  }
  
  public void testEmptyConstructor() {
    //Deck deck = new Deck();
  
  }
}