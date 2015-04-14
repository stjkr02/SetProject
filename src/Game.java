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