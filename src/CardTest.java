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
  
    assertEquals(1, card.getQuantity());
    assertEquals(1, card.getColor());
    assertEquals(1, card.getShading());
    assertEquals(1, card.getShape());
    assertEquals("1ROO", card.toString());
  }
  
  public void testModder() {
    //All Zeros
    Card card = new Card(0, 0, 0, 0);
   
    assertEquals(3, card.getQuantity());
    assertEquals(3, card.getColor());
    assertEquals(3, card.getShading());
    assertEquals(3, card.getShape());
    assertEquals("3PSS", card.toString());
    
    
    //Positive Numbers
    Card card1 = new Card(238, 208, 181, 28);
    
    assertEquals(1, card1.getQuantity());
    assertEquals(1, card1.getColor());
    assertEquals(1, card1.getShading());
    assertEquals(1, card1.getShape());
    assertEquals("1ROO", card1.toString());
    
    //Negative Numbers
    Card card2 = new Card(-206, -259,-96, -170); 
    
    assertEquals(1, card2.getQuantity());
    assertEquals(2, card2.getColor());
    assertEquals(3, card2.getShading());
    assertEquals(1, card2.getShape());
    assertEquals("1GSO", card2.toString());                      
  }
  
}
