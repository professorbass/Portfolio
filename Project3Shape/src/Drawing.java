import javax.swing.*;
import java.awt.*;
/**
 * class Drawing extends JPanel (Java JPanel)
 * 
 * */
public class Drawing extends JPanel {
	//id
   private static final long serialVersionUID = 42L;
   //size of screen
   private static final int PREF_SIZE = 200;
  //shape to be draw
   private Shape shape = null;

   /**
    * Method paintComponent to draw Shape
    * */
   @Override
   public void paintComponent(Graphics g) {      
       super.paintComponent(g);
       if (shape != null) {
           shape.draw(g);
           g.setColor(Color.BLACK);
           g.drawString(String.valueOf(shape.getNoOfShapes()), 2, 10);
       }
   }
  
   /**
    * Method to get PreferredSize
    * */
   @Override
   public Dimension getPreferredSize() {
       return new Dimension(PREF_SIZE, PREF_SIZE);
   }
  /**
   * Method to drawShape
   * */
   public void drawShape(Shape shape) {
       try {
           if (shape.x < 0 || shape.y < 0 || shape.x + shape.width > PREF_SIZE || shape.y + shape.height > PREF_SIZE) {
               Shape.count--;
               throw new OutsideBounds("Outside Bounds error");
           } else {
               this.shape = shape;  
               repaint();
           }  
       } catch (Exception e) {
           JOptionPane.showMessageDialog(null, "Outside Bounds error.");
           //System.err.println(e);
       }
          
   }
}