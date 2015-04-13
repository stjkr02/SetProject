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
  
  public void removeSet(Card givenCard, Card givenCard1, Card givenCard2) {
    //Check if the given cards form a set.
    if (givenCard.isSet(givenCard1, givenCard2) != true)
      return;
    
    //Check if the cards are on the table.
    if (allCardsPresent(givenCard, givenCard1, givenCard2) != true)
      return;
    
    //Remove the cards by traversing the list
    TableNode prev = null;
    TableNode curr = head;
    
    while ( curr != null ) {
      //Check if the current node's card is marked to be removed
      Card temp = curr.getCard();
      if ( temp.equals(givenCard) == true || temp.equals(givenCard1) == true || temp.equals(givenCard2) == true) {
        //Check if it will be a head insertion
        if (prev == null) {
          curr = curr.getNext();
          head = curr;
        } //Else, it's a general body insertion. 
        else {
          prev.setNext(curr.getNext());
          curr = curr.getNext();
        }
      }
      //If the card doesn't match, just move down the list.
      else {
        prev = curr;
        curr = curr.getNext();
      }
    }
  }
  
  private boolean allCardsPresent(Card givenCard, Card givenCard1, Card givenCard2) {
    Card card = givenCard;
    Card card1 = givenCard1;
    Card card2 = givenCard2;
    
    int count = 0;
    
    TableNode node = head;
    while (node != null) {
      Card temp = node.getCard();
      if ( temp.equals(card) == true || temp.equals(card1) == true || temp.equals(card2) == true)
        count++;
      
      node = node.getNext();
    }
    
    if (count == 3)
      return true;
    else
      return false;
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
    if (head == null || givenIndex > (this.numCards() -1) || givenIndex < 0)
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
    int count = 0;
    
    //Initialize the first node and then iterate from the next node until the end of the linked list
    TableNode n1 = head;
    while ( n1 != null ) {
      
      //Initialize the second node to be node following the first, and then iterate through the end.
      TableNode n2 = n1.getNext();
      while ( n2 != null) {
        
        //Same as above really.
        TableNode n3 = n2.getNext();
        while( n3 != null) {
          //Make temporary card references to the cards referenced by each node
          Card temp = n1.getCard();
          Card temp2 = n2.getCard();
          Card temp3 = n3.getCard();
          
          //If those 3 particular referenced cards form a set, increment the count by 1.
          if (temp.isSet(temp2, temp3) == true)
            count++;
          
          //End of the while loop, get the next node.
          n3 = n3.getNext();
        }
        //End of the while loop, get the next node.
        n2 = n2.getNext();
      }
      //End of the while loop, get the next node.
      n1 = n1.getNext();
    }
    //Return the number of sets!
    return count;
  } 
}