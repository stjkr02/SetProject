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
    
    //If the method made it past that isGameOver() check, then there is a set to be removed, and (possibly) cards to be added.
    
    //Get the number of cards before removing a set..
    int cards = numCards();
    
    //Remove a set
    removeASet(cards);
    
    //Check if table had more than 12 cards before adding cards.
    //Add 3 cards if and only if there was less than 12 cards on the table to begin with.
    if (cards <= 12) {
      int i = 0;
      while(d.hasNext() == true && i < 3) {
        t.add(d.getNext());
        i ++;
      }
    }
    
  }
  
  
  private void removeASet(int givenCards) {
    //Pass in the number of cards to check when the cards are finally removed
    int length = givenCards;
    
    for (int i = 0; i < length - 2; i++) {
      for (int j = i + 1; j < length - 1; j++) {
        for (int k = j + 1; k < length; k++) {
          t.removeSet(t.getCard(i), t.getCard(j), t.getCard(k));
          
          //Return if any cards were removed as to only remove one set.
          if (t.numCards() < length)
            return;
        }
      }
    }
    return;
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