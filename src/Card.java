public class Card {
  private int quantity;
  private int color;
  private int shading;
  private int shape;
  
  public Card(int givenQuantity, int givenColor, int givenShading, int givenShape) {
    quantity = givenQuantity;
    color = givenColor;
    shading = givenShading;
    shape = givenShape;
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
    return null;
  }
  
  public boolean equals(Object obj) {
    Card that = (Card)obj;
    
    return quantity == that.getQuantity() &&
      color == that.getColor() &&
      shading == that.getShading() &&
      shape == that.getShape();
  }
}
