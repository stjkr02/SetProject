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
   
    assertEquals(1, card.getQuantity());
    assertEquals(1, card.getColor());
    assertEquals(1, card.getShading());
    assertEquals(1, card.getShape());
    assertEquals("1ROO", card.toString());
    
    
    //Positive Numbers
    Card card1 = new Card(238, 208, 181, 28);
    
    assertEquals(2, card1.getQuantity());
    assertEquals(2, card1.getColor());
    assertEquals(2, card1.getShading());
    assertEquals(2, card1.getShape());
    assertEquals("2GTD", card1.toString());
    
    //Negative Numbers
    Card card2 = new Card(-206, -259,-96, -170); 
    
    assertEquals(2, card2.getQuantity());
    assertEquals(3, card2.getColor());
    assertEquals(1, card2.getShading());
    assertEquals(2, card2.getShape());
    assertEquals("2POD", card2.toString());
    
    //Negative -> 0
    Card card3 = new Card(-300, -300, -300, -300);
    
    assertEquals(1, card3.getQuantity());
    assertEquals(1, card3.getColor());
    assertEquals(1, card3.getShading());
    assertEquals(1, card3.getShape());
    assertEquals("1ROO", card3.toString());
    
  }
  
}
