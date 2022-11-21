//Angel Li
//112784616
//Angel.Li@stonybrook.edu
//Homework #2
//CSE 214 (R03)
//TA Kevin Cheng

/**
 *The CarListNode class wraps a Car object, which includes its data members
 *(Make,owner)
 *
 *
 * @author Angel Li
 * Angel.Li@stonybrook.edu
 * 112784616
 */
public class CarListNode {
    static int Capacity;
    private Car data;
    private CarListNode next;
    private CarListNode prev;


    /**
     * This is a default constructor used to create a new CarListNode object
     *
     * @param data
     * data represents a Car object with a Make and owner
     * @throws IllegalArgumentException
     * When the user tries to wrap a null Car object
     */
    public CarListNode(Car data) throws IllegalArgumentException {
        try {
            if (data != null) {
                this.data = data;
                this.next = null;
                this.prev = null;
            }
            else {
                throw new IllegalArgumentException();
            }
        }catch(IllegalArgumentException exception1) {
            System.out.println("CarListNode can not be initialized to a Car" +
                    " object because the Car object is pointing to a null " +
                    "reference");
        }
    }

    /**
     * The method gets the data of the Car object wrapped within the CarListNode
     * object
     *
     * @return
     * Car object along with its data members
     */
    public Car getData(){
        return data;
    }

    /**
     * The method changes the Car object wrapped within the CarListNode object
     *
     * @param data
     * Car object
     */
    public void setData(Car data){
        this.data = data;
    }

    /**
     * The method gives the next CarListNode object (next link) in the list
     *
     * @return
     * Returns a CarListNode that is linked with the current CarListNode object
     * and next in the line
     */
    public CarListNode getNext(){
        return this.next;
    }

    /**
     * The method gives the previous CarListNode (previous link) in the list
     *
     * @return
     * Returns a CarListNode object that is linked with the current
     * CarListNode object and previous in the line
     */
    public CarListNode getPrev(){
        return this.prev;
    }

    /**
     * The method changes the CarListNode object linked after the current
     * CarListNode object
     *
     * @param next
     * A CarListNode object that the user wants to link after the current object
     */
    public void setNext(CarListNode next){
        this.next = next;
    }

    /**
     * The method changes the CarListNode object linked before the current
     * CarListNode object
     *
     * @param prev
     * A CarListNode object that the user wants to link before the current
     * object
     */
    public void setPrev(CarListNode prev){
        this.prev = prev;
    }

    /**
     * The method gives a representation of the CarListNode object
     *
     * @return
     * Returns the Make and owner of the Car object wrapped by the CarListNode
     * object
     */
    public String toString(){
        return "" + this.getData();
    }


}
