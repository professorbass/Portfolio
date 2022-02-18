
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 * Rectanglar Class Extends Shape class
 * 
 * 
 * */

public class Rectanglar extends Shape {
  //id
   private static final long serialVersionUID = 42L;
  /**
   * Constructor for Rectanglar
   * */
   public Rectanglar(Rectangle rect, Color color, boolean isSolid) {
       super(rect, color, isSolid);
   }
  /**
   * Method for draw
   * */
   public void draw (Graphics g) {
       g.setColor(color);
       int x = super.x;
       int y = super.y;
       int width = super.width;
       int height = super.height;
       if (getSolid())
           g.fillRect(x, y, width, height);
       else
           g.drawRect(x, y, width, height);
   }

}