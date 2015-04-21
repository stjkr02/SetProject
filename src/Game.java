public class Game {
  private Table t;
  private Deck d;
  
  public Game() {
    t = new Table();
    d = new Deck();
  
    //Add cards to the table ensuring that only 12 cards are placed on the table
    for ( int i = 0; i < 12; i++) {
      t.add(d.getNext());
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
    //Query the number of Sets present on the table
    int sets = numSets();

    //Check, and stop, if the game is over (i.e. No sets can be removed and the deck is exhausted).
    if (isGameOver(sets) == true)
      return;
    
    //If the method made it past that isGameOver() check, then there is a set to be removed, and/or (possibly) cards to be added.
    //Need to check if we only need to add cards versus removing a set and then adding cards
    if (sets == 0) {
      add3Cards();
      return;
    }
      
    //Get the number of cards before removing a set.
    int cards = numCards();
    
    //Remove a set
    removeASet(cards);
    
    //Check if table had more than 12 cards before adding cards.
    //Add 3 cards if and only if there was at most 12 cards on the table to begin with.
    if (cards <= 12) {
      add3Cards();
    }
    
  }
  
  
  private void removeASet(int givenCards) {
    //Pass in the number of cards to establish the length of the for-loop
    int length = givenCards;
    
    for (int i = 0; i < length - 2; i++) {
      for (int j = i + 1; j < length - 1; j++) {
        for (int k = j + 1; k < length; k++) {
          if(t.getCard(i).isSet(t.getCard(j), t.getCard(k)) == true) {
            t.removeSet(t.getCard(i), t.getCard(j), t.getCard(k));
            return;
          }
        }
      }
    }
    return;
  }
  
  private void add3Cards() {
    int i = 0;
    while(d.hasNext() == true && i < 3) {
      t.add(d.getNext());
      i ++;
    }
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
  
  
  //Private overload of isGameOver to improve efficiency
  private boolean isGameOver(int givenNumSets) {
    //Check if there are sets on the table.
    if (givenNumSets != 0)
      return false;
    //Check if any cards remain in the deck.
    if (d.hasNext() == true)
      return false;
    
    //If the method gets down here, then the game is over
    return true;
  }
}