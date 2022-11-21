//Angel Li
//112784616
//Angel.Li@stonybrook.edu
//Homework #2
//CSE 214 (R03)
//TA Kevin Cheng

/**
 * The Car class is used to make and represent a Car object with a specific Make
 * and owner.
 *
 *
 * @author Angel Li
 * Angel.Li@stonybrook.edu
 * 112784616
 */
public class Car {
    private Make make;
    private String owner;

    /**
     * This is a constructor used to create a new Car object
     *
     * @param make
     * 	The type of car
     * @param owner
     * 	The name of the Car's object
     */
    public Car(Make make, String owner){
        this.make = make;
        this.owner = owner;
    }

    /**
     * The method gives the Make of the Car object
     *
     * @return
     * The make of the Car object
     */
    public Make getMake(){
        return this.make;
    }

    /**
     * The method gives the owner of the Car object
     *
     * @return
     * The Car object's owner's name
     */
    public String getOwner(){
        return this.owner;
    }

    /**
     * The method changes the Make of the Car object
     *
     * @param make
     * The make of the Car object
     */
    public void setMake(Make make){
        this.make = make;
    }

    /**
     * The method changes the owner of the Car object
     *
     * @param owner
     * The owner's name of the Car object
     */
    public void setOwner(String owner){
        this.owner = owner;
    }

    /**
     * The method gives a representation of the Car object with its data members
     * (Make,owner)
     *
     * @return
     * Returns string of the Car's make and owner
     */
    public String toString(){
        return this.make + "\t\t" +  this.owner;
    }
}
