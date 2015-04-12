public class TableTestMain {
  public static void main(String[] args) {
    Table table = new Table();
    Deck deck = new Deck("3card.dat");
    
    while (deck.hasNext() == true) 
      table.add(deck.getNext());
    
    //Cards to remove
    Card card = new Card(1, 1, 1, 1);
    Card card1 = new Card(2, 2, 2, 2);
    Card card2 = new Card(3, 3, 3, 3);
    
    

    System.out.println(card.equals(card1));
      
  }
}
