import junit.framework.TestCase;

/**
 * A JUnit test case class.
 * Every method starting with the word "test" will be called when running
 * the test with JUnit.
 */
public class CardTest extends TestCase {
  
  /**
   * A test method.
   * (Replace "X" with a name describing the test.  You may write as
   * many "testSomething" methods in this class as you wish, and each
   * one will be called when running JUnit over this class.)
   */
  public void testGetMethodsBasicCard() {
  Card card = new Card(1, 1, 1, 1);
  
  assertEquals(card.getQuantity(), 1);
  assertEquals(card.getColor(), 1);
  assertEquals(card.getShading(), 1);
  assertEquals(card.getShape(), 1);
  assertEquals(card.toString(), null);
  }
  
}
