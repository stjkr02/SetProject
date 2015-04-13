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
  
  
  public void testNumSetsSimple() {
    Table table = new Table();
   
    Card card = new Card(1, 1, 1, 1);
    Card card1 = new Card(2, 2, 2, 2);
    Card card2 = new Card(3, 3, 3, 3);
    
    table.add(card);
    table.add(card1);
    table.add(card2);
    
    //Assert that there is only one set in this simple table.
    assertEquals(1, table.numSets());  
  }
  
  public void testNumSetsComplex() {
    Table table = new Table();
    Deck deck = new Deck("numSetsComplex.dat");
    
    while (deck.hasNext() == true)
      table.add(deck.getNext());
    
    //Assert that there are 8 cards, but only 3 sets on the table.
    assertEquals(8 , table.numCards());
    assertEquals(3 , table.numSets());
  }
  
  public void testAllCardsPresentHelperMethod() {
    Table table = new Table();
    Deck deck = new Deck("3card.dat");
    
    while (deck.hasNext() == true) 
      table.add(deck.getNext());
    
    //Cards to remove
    Card card = new Card(1, 2, 2, 1);
    Card card1 = new Card(2, 3, 2, 2);
    Card card2 = new Card(3, 1, 2, 3);
    
    table.removeSet(card, card1, card2);
    
    //Asert that the number of cards is 3, as nothing should have been removed due to the cards not being present.
    assertEquals(3, table.numCards());
  }
  
  public void testRemoveSetSimple() {
    Table table = new Table();
    Deck deck = new Deck("3card.dat");
    
    while (deck.hasNext() == true) 
      table.add(deck.getNext());
    
    //Cards to remove
    Card card = new Card(1, 1, 1, 1);
    Card card1 = new Card(2, 2, 2, 2);
    Card card2 = new Card(3, 3, 3, 3);
    
    //Make sure there is a set
    assertEquals(1, table.numSets());
    //Remove that set
    table.removeSet(card, card1, card2);
    //Assert that nothing is on the table
    assertEquals(0, table.numCards());
  }
  
  public void testRemoveSetComplex() {
    Table table = new Table();
    Deck deck = new Deck("numSetsComplex.dat");
    
    while (deck.hasNext() == true) 
      table.add(deck.getNext());
    
    //There should be 3 sets
    assertEquals(3, table.numSets());
    
    //Remove a set
    table.removeSet(new Card(1, 1, 1, 1), new Card(2, 1, 1, 1), new Card(3, 1, 1, 1));
    
    //Assert that there are only 5 cards left.
    assertEquals(5, table.numCards());
    
    //Try to remove another set,
    table.removeSet(new Card(1, 1, 1, 1), new Card(2, 2, 2, 2), new Card(3, 3, 3, 3));
    //But to no avail
    assertEquals(5, table.numCards());
  }

  public void testRemoveSet_NotASet() {
    Table table = new Table();
    Deck deck = new Deck("3card.dat");
    
    while (deck.hasNext() == true) 
      table.add(deck.getNext());
    
    //Cards to remove
    Card card = new Card(1, 1, 1, 1);
    Card card1 = new Card(2, 3, 2, 2); //This one throws the 'set' off
    Card card2 = new Card(3, 3, 3, 3);
    
    //Make sure there is a not set
    assertEquals(false, card.isSet(card2, card1));
    //Attempt to remove the 'set'
    table.removeSet(card, card1, card2);
    //Assert that everything is still on the table.
    assertEquals(3, table.numCards());
  }
}
  
