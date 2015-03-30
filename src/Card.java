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
    int value = givenValue % 3;
    
    if (value == 0)
      return 3;
    else if (value < 0)
      return ((value + 3) % 3);
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
    return false;
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
  
  public boolean equals(Object obj) {
    Card that = (Card)obj;
    
    return quantity == that.getQuantity() &&
      color == that.getColor() &&
      shading == that.getShading() &&
      shape == that.getShape();
  }
}
