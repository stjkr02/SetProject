public class Game {
  private Table t;
  private Deck d;
  
  public Game() {
    t = new Table();
    d = new Deck();
  
    //Add cards to the table ensuring that only 12 cards are placed on the table
    int i = 0;
    while(i < 12) {
      t.add(d.getNext());
      i++;
    }
  }
 
  public Game(String givenString) {
    t = new Table();
    d = new Deck(givenString);
    
    //Add cards to the table ensuring that only 12 cards are placed on the table
    int i = 0;
    while (d.hasNext() == true && i < 12) {
      t.add(d.getNext());
      i++;
    }
  }
  
  
  public int numSets() {
    return t.numSets();
  }
  
  
  public int numCards() {
    return t.numCards();
  }
  
  
  public void playRound() {
    //Check, and stop, if the game is over (i.e. No sets can be removed and the deck is exhausted).
    if ( isGameOver() == true)
      return;
    
    //Notes:
    //Check if there are any sets on the table.
    //Remove that set (if applicable)
    
    //Check if table had more than 12 cards.
    //Add 3 cards as necessary
    
  }
  
  
  public boolean isGameOver() {
    //Check if there are sets on the table.
    if (t.numSets()  != 0)
      return false;
    //Check if any cards remain in the deck.
    if (d.hasNext() == true)
      return false;
    
    //If the method gets down here, then the game is over
    return true;
  }
}