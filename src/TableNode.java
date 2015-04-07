public class TableNode {
  private Card card;
  private TableNode next;
  
  TableNode(Card givenCard) {
    next = null;
    card = givenCard;  
  }
  
  
  public void setNext(TableNode target) {
    next = target;
  }
  
  
  public TableNode getNext() {
    return next;
  }
  
  
  public Card getCard() {
    return card;
  }
}