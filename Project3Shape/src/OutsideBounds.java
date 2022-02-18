/**
 * class OutsideBounds extends Exception (java exception class)
 * */
public class OutsideBounds extends Exception {
   private static final long serialVersionUID = 42L;
  
   
   /**
    * Constructor of class OutsideBounds
    * */
public OutsideBounds(String errorMessage) {
super(errorMessage);
}

}