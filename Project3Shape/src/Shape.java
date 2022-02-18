import java.awt.*;

/**
 * Shape Class Extends Java awt Rectangle class just to bound the child shape
 * 
 * 
 * */
public abstract class Shape extends Rectangle {
   //id
	private static final long serialVersionUID = 42L;
  //Color of Shape
   Color color;
   //is filled
   boolean isSolid;
   //count of shapes
   static int count = 0;
  
   /**
    * Constructor of Shape class
    * */
   public Shape(Rectangle rect, Color color, boolean isSolid) {
       super(rect);
       this.color = color;
       this.isSolid = isSolid;
       count++;
   }
   
  /**
   * Setter for Color
   * */
   public void setColor(Graphics g) {
       color = g.getColor();
   }
  /**
   * Getter for Solid
   * 
   * */
   public boolean getSolid() {
       return isSolid;
   }
  /**Getter for count of Shape
   * */
   public int getNoOfShapes() {
       return count;
   }
  /**
   * Method to draw shape
   * */
   public abstract void draw (Graphics g);

}