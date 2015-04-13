public class Card {
  private int quantity;
  private int color;
  private int shading;
  private int shape;
  
  public Card(int givenQuantity, int givenColor, int givenShading, int givenShape) {
    quantity = modder(givenQuantity);
    color = modder(givenColor);
    shading = modder(givenShading);
    shape = modder(givenShape);
  }
  
  private int modder(int givenValue){
    int value = givenValue;
    
    if (value < 1 || value > 3)
      return ((( value % 3) + 3) % 3) + 1;
    else 
      return value;
  }
  
  public int getQuantity() {
    return quantity;
  }
  
  public int getColor() {
    return color;
  }
  
  public int getShading() {
    return shading;
  }
  
  public int getShape() {
    return shape;
  }
  
  public boolean isSet(Card card1, Card card2){
    boolean checker = false;
   
    //Make an array for the cards and the sums.
    Card[] cards = {this, card1, card2}; 
    int[] sums = {0, 0, 0, 0};
    
    //Iterate through the values of the atributes of the cards to make sure they form sets, if they do not, the 
    //program will return false without wasting time on the remaining atributes.
    
    //Check Quantity
    for ( Card i : cards)
      sums[0] += i.getQuantity();
      
    if (sums[0] % 3 != 0) {
      return checker;
    }
      
    //Check Color
    for ( Card i : cards)
      sums[1] += i.getColor();
      
    if (sums[1] % 3 != 0) {
      return checker;
    }
      
    //Check Shading
    for ( Card i : cards)
      sums[2] += i.getShading();
        
    if (sums[2] % 3 != 0) {
      return checker;
    }

    
      //Check Shape
    for ( Card i : cards)
      sums[3] += i.getShape();
      
    if(sums[3] % 3 != 0){
      return checker;
    }
      
    //Awesome, if the method got down to this line without returning, then the three cards are a set.
    checker = true;
            
    return checker;
  }
  
  public String toString() {
    String name = "" + quantity;
    
    //Color
    if (color == 1)
      name += "R";
    else if (color == 2)
      name += "G";
    else if (color == 3)
      name += "P";
    
    //Shading
    if (shading == 1)
      name += "O";
    else if (shading == 2)
      name += "T";
    else if (shading == 3)
      name += "S";
    
    //Shape
    if (shape == 1)
      name += "O";
    else if (shape == 2)
      name += "D";
    else if (shape == 3)
      name += "S";  
    
    return name;
  }
  @Override
  public boolean equals(Object obj) {
    Card that = (Card)obj;
    
    return quantity == that.getQuantity() &&
      color == that.getColor() &&
      shading == that.getShading() &&
      shape == that.getShape();
  }
}
