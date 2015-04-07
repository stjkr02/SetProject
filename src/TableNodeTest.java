import junit.framework.TestCase;

/**
 * A JUnit test case class.
 * Every method starting with the word "test" will be called when running
 * the test with JUnit.
 */
public class TableNodeTest extends TestCase {
  
  /**
   * A test method.
   * (Replace "X" with a name describing the test.  You may write as
   * many "testSomething" methods in this class as you wish, and each
   * one will be called when running JUnit over this class.)
   */
  public void testQueriesSimple() {
    Card card = new Card(1, 1, 1, 1);
    TableNode node = new TableNode(card);
    
    assertEquals(null, node.getNext());
    assertEquals(card, node.getCard());
  
  }
  
  public void testSetNext() {
    Card card = new Card(1, 1, 1, 1);
    Card card1 = new Card(2, 2, 2, 2);
    
    TableNode nodeA = new TableNode(card);
    TableNode nodeB = new TableNode(card1);
    
    nodeA.setNext(nodeB);
    
    
    //Test nodeA
    assertEquals(nodeB, nodeA.getNext());
    assertEquals(card, nodeA.getCard());
    
    //Test nodeB
    assertEquals(null, nodeB.getNext());
    assertEquals(card1, nodeB.getCard());
  }

}
