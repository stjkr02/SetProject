import junit.framework.TestCase;

/**
 * A JUnit test case class.
 * Every method starting with the word "test" will be called when running
 * the test with JUnit.
 */
public class GameTest extends TestCase {
  
  /**
   * A test method.
   * (Replace "X" with a name describing the test.  You may write as
   * many "testSomething" methods in this class as you wish, and each
   * one will be called when running JUnit over this class.)
   */
  public void test3cardsGame() {
    //This test will test the Game(String), the numSets(), the numCards() methods.
    Game game = new Game("3card.dat");
    
    //This data file only has 3 cards, and they form a set.
    assertEquals(3, game.numCards());
    assertEquals(1, game.numSets());
    
  }
  
  public void testStringConstructorMoreThan12Cards() {
    Game game = new Game("MoreThan12Cards.dat");
    
    //Assert that only 12 cards were added when the deck (constructed from a dat file) has more than 12 cards.
    assertEquals(12, game.numCards());
  }
  
  public void testEmptyConstructor() {
    Game game = new Game();
    
    //Assert that only 12 cards were added when a new game was constructed.
    assertEquals(12, game.numCards());
  }
  
  public void testIsGameOver() {
    Game game = new Game("isGameOver.dat");
    
    //There are 4 cards on the table, none of them form a set, and no cards remain in deck; the game is over.
    assertEquals(4, game.numCards());
    assertEquals(0, game.numSets());
    assertTrue(game.isGameOver());
  }

  public void test2SetGamePlayRound() {
    Game game = new Game("2SetGame.dat");
    
    //Start with 6 cards, which form 2 sets, in total
    assertEquals(6, game.numCards());
    assertEquals(2, game.numSets());
    
    //Remove a set
    game.playRound();
    
    //There should be 3 cards, and 1 set remaining
    assertEquals(3, game.numCards());
    assertEquals(1, game.numSets());
    
    //Remove the last set
    game.playRound();
    
    //Game should be over
    assertTrue(game.isGameOver());
  }
  
  public void test15CardDeck() {
    //This will test that a deck with more than 12 cards will add at least 3 cards
    Game game = new Game("16CardGame.dat");
    
    //Game should start with 12 cards
    assertEquals(12, game.numCards());
    //Make sure there are at least 2 sets in this deck.
    assertTrue(game.numSets() >= 2);
    
    
    //Remove a set
    game.playRound();
    
    //Check that there are 12 cards on the table.
    assertEquals(12, game.numCards());
    
    //Remove another set
    game.playRound();
    
    //Now there should be 10 cards on the table because the deck only had 16 cards total.
    assertEquals(10, game.numCards());
    
    
  }
}
