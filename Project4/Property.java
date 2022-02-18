


/**
 * Property class that implements the StateChangeable interface
 */
public class Property implements StateChangeable<Status>{

    /**
     * instance variables
     */
    private String address;
    private Integer noOfBedrooms;
    private Integer squareFootage;
    private Integer price;
    private Status status;

    /**
     * parameterized constructor
     */
    public Property(String address, Integer noOfBedrooms, Integer squareFootage, Integer price) {
        this.address = address;
        this.noOfBedrooms = noOfBedrooms;
        this.squareFootage = squareFootage;
        this.price = price;
        this.status = Status.FOR_SALE;
    }
    
    /**
     * changeState method from the StateChangeable interface
     */
    @Override
    public void changeState(Status status) {
        this.status = status;
    }

    /**
     * overridden toString method to get property info in a string
     */
    @Override
    public String toString() {
        return "Property [ Address: "+address
                +", No_Of_Bedrooms: "+noOfBedrooms
                +", Square_Footages: "+squareFootage
                +", Price: "+price
                +", Status: "+status.name()+" ]";
    }
}
