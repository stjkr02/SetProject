public class Main {
  public static void main(String[] args) {
    int numGames = 100;
    long[] sums = {0L, 0L};
    
    //Run a bunch of games
    for (int i = 0; i < numGames; i++) {
      //Create a new game
      Game game = new Game();
      
      //Query how many sets are present in the initial 12 cards.
      sums[0] += (long)game.numSets();
      
      
      
      
      //Play the game until the end
      while (game.isGameOver() != true) {
        game.playRound();
      }
      
      //Query how many cards are left at the end of the game
      sums[1] += (long)game.numCards();
    }
    
    //Print out the relevant information
    System.out.println("After " + numGames +" Games:");
    System.out.println("The average number of sets present after the initialization of a new game of set is: " + sums[0]/(double)numGames);
    System.out.println("The average number of cards present when the game is over is: " + sums[1]/(double)numGames);
    
    
  }
}