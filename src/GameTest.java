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
    
    assertEquals(3, game.numCards());
    assertEquals(1, game.numSets());
    
  }
  
  public void testStringConstructorMoreThan12Cards() {
    Game game = new Game("MoreThan12Cards.dat");
    
    assertEquals(12, game.numCards());
  }
}
