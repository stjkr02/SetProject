public class Table {
  private TableNode head;
  
  Table() {
    head = null;
  }
  
  public void add(Card givenCard) {
    head = new TableNode(givenCard);
  }
  
  public void removeSet(Card card0, Card card1, Card card2) {
    
  }
  
  public int numCards() {
    return 0;
  }
  
  public Card getCard(int givenIndex) {
    if(head != null) 
      return head.getCard();
    else
      return null;
  }
  
  public int numSets() {
    return 0;
  }
  
  
}