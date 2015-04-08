public class Table {
  private TableNode head;
  
  Table() {
    head = null;
  }
  
  
  public void add(Card givenCard) {
    if ( head == null )
      head = new TableNode(givenCard);
    else {
      TableNode temp = new TableNode(givenCard);
      temp.setNext(head);
      head = temp;
    }
  }
  
  public void removeSet(Card card0, Card card1, Card card2) {
    
  }
  
  
  
  public int numCards() {
    TableNode temp = head;
    int count = 0;
    
    while(temp != null) {
      count += 1;
      temp = temp.getNext();
    }
    return count;
  }
  
  
  public Card getCard(int givenIndex) {
    if (head == null)
      return null;
    
    int i = 0;
    TableNode temp = head;
    while(i < givenIndex) {
      temp = temp.getNext();
      i++;
    }
    return temp.getCard();
  }
  
  
  public int numSets() {
    return 0;
  }
  
  
}