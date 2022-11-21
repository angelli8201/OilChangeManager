//Angel Li
//112784616
//Angel.Li@stonybrook.edu
//Homework #2
//CSE 214 (R03)
//TA Kevin Cheng

/**
 *The CarList class implements a double linked-list data structure.
 *
 *
 * @author Angel Li
 * Angel.Li@stonybrook.edu
 * 112784616
 */
public class CarList {
    private CarListNode head;
    private CarListNode tail;
    private CarListNode cursor;
    private int num;

    /**
     * This is a constructor which creates a CarList object. The head,tail, and
     * cursor reference are initially set to null. Once the user links
     * CarListNode objects to the list, the head, tail, and/or cursor references
     * may change
     */
    public CarList (){
        head = null;
        tail = null;
        cursor = null;
    }

    /**
     * The method changes the head reference of the CarList object
     *
     * @param head
     * A CarListNode object
     */
    public void setHead(CarListNode head){
        this.head = head;
    }

    /**
     * The method gives the object that the head of the CarList object
     * references
     *
     * @return
     * A CarListNode object
     */
    public CarListNode getHead(){
        return head;
    }

    /**
     * The method changes the tail reference of the CarList object
     *
     * @param tail
     * A CarListNode object
     */
    public void setTail(CarListNode tail){
        this.tail = tail;
    }

    /**
     * The method gives the object that the tail of the CarList object
     * references
     *
     * @return
     * A CarListNode object
     */
    public CarListNode getTail(){
        return tail;
    }

    /**
     * The method changes the cursor reference of the CarList object
     *
     * @param cursor
     * A CarListNode object
     */
    public void setCursor(CarListNode cursor){
        this.cursor = cursor;
    }

    /**
     * The method gives the object that the tail of the CarList object
     * references
     *
     * @return
     * A CarListNode object
     */
    public CarListNode getCursor(){
        return cursor;
    }

    /**
     * The method shows how many Car objects are in the CarList
     *
     * @return
     * Returns an integer that represents how many Car objects are in the
     * CarList
     */
    public int numCars(){
        return num;
    }

    /**
     * The method gives the CarListNode that the cursor is currently pointing to
     *
     * @return
     * Returns the CarListNode that is currently referenced by the
      cursor of the CarList object
     */
    public CarListNode getCursorCar() {
        if(this.getCursor() == null) {
            return null;
        }
        return cursor;
    }

    /**
     * The method changes the cursor to the first CarListNode object in the list
     */
    public void resetCursorToHead(){
        if(head != null) {
            cursor = head;
        }
        else{
            cursor = null;
        }
    }

    /**
     * The method moves the cursor forward in the CarList object
     *
     * @throws EndOfListException
     * An exception is thrown if the user tries to move the cursor forward when
     * the cursor references the tail of the CarList object. There would be no
     * CarListNode to reference if the cursor would be moved past the tail.
     */
    public void cursorForward() throws EndOfListException{
        if(cursor == tail){
            throw new EndOfListException();
        }
        else{
            cursor = cursor.getNext();
        }
    }

    /**
     * The method moves the cursor backward in the CarList object
     *
     * @throws EndOfListException
     * An exception is thrown if the user tries to move the cursor backward when
     * the cursor references the head of the CarList object. There would be no
     * CarListNode to reference if the cursor would be moved behind the head.
     */
    public void cursorBackward() throws EndOfListException{
       if (cursor == head) {
           throw new EndOfListException();
       }
       else {
           cursor = cursor.getPrev();
       }
    }

    /**
     * The method makes a new CarListNode object that would be inserted before
     * the CarListNode that's currently referenced by the cursor of the CarList
     * object
     *
     * @param newCar
     * A Car object with a Make and owner
     */
    public void insertBeforeCursor(Car newCar){
        CarListNode temp = new CarListNode(newCar);
        if(temp == null){
            throw new IllegalArgumentException("Trying to add null CarListNode"+
                    " object");
        }
        if(cursor == null){
            head = temp;
            tail = temp;
            cursor = temp;
        }
        else if(cursor == head) {
            cursor.setPrev(temp);
            temp.setNext(cursor);
            setHead(temp);
        }

        else if (cursor != null){
            temp.setNext(cursor);
            temp.setPrev(cursor.getPrev());
            cursor.getPrev().setNext(temp);
            cursor.setPrev(temp);
        }
        num ++;
    }

    /**
     * The method adds a CarListNode to the end of a CarList object
     *
     * @param newCar
     * A car object
     */
    public void appendToTail(Car newCar){
        CarListNode temp = new CarListNode(newCar);
        if(temp == null){
            throw new IllegalArgumentException("Trying to add null CarListNode"+
                    " object");
        }
        else if(tail != null){
            tail.setNext(temp);
            temp.setPrev(tail);
            tail = temp;
        }
        else if(tail == null){
            head = temp;
            tail = temp;
            cursor = temp;
        }
        num ++;
    }

    /**
     * The method removes a CarListNode object from the CarList object
     *
     * @return
     * Returns the Make and owner associated with the CarList object
     * that was removed from the CarList object
     */
    public Car removeCar(){
        Car temp = new Car(cursor.getData().getMake(),
                cursor.getData().getOwner());
        try{
            if(cursor == null) {
                throw new EndOfListException();
            }
            else{
                if(cursor == head && cursor.getNext() == null){
                    head = null;
                    tail = null;
                    cursor = null;
                    return null;
                }

                else if (cursor == head && cursor.getNext() != null){
                    head = cursor.getNext();
                    cursor = head;
                    num--;
                    return temp;
                }

                else if(cursor == tail){
                    tail = cursor.getPrev();
                    cursor.setPrev(null);
                    tail.setNext(null);
                    cursor = tail;
                    num--;
                    return temp;
                }
                else{
                    cursor.getPrev().setNext(cursor.getNext());
                    cursor.getNext().setPrev(cursor.getPrev());
                    cursor = cursor.getPrev();
                    num--;
                    return temp;
                }
            }
        }catch(EndOfListException exception1){
            System.out.println("The cursor is null");
        }
        return temp;
    }

    /**
     * The method gives a representation of the CarList object. The method shows
     * the CarListNodes that are a part of the CarList
     *
     * @return
     * Returns string that represents a list of CarListNode objects
     */
    public String toString(){
        CarListNode nodePtr = head;
        String s = " ";
        while (nodePtr !=null){
            if(nodePtr == this.getCursor()){
                System.out.print("-->");
            }
            System.out.format("%10s%15s%n",nodePtr.getData().getMake()
                    ,nodePtr.getData().getOwner());
            nodePtr = nodePtr.getNext();
        }
        return s;
    }

    /**
     * The method merges two CarList objects by adding CarListNode objects from
     * each CarList object in alternating order.
     *
     * @param c1
     * First CarList object
     * @param c2
     * Second CarList object
     * @return
     * Returns a new CarList object that merges the two CarList objects given
     */
    public static CarList mergeLists(CarList c1, CarList c2){
        CarList temp1 = new CarList();
        CarListNode cursorP = c2.getHead();
        if(c1.getHead() == null) {
            for(int i =0; i<c2.numCars(); i++) {
                temp1.appendToTail(cursorP.getData());
                cursorP = cursorP.getNext();
            }
            return temp1;
        }
        CarList temp2 = new CarList();
        CarListNode cursorP2 = c1.getHead();

        if(c2.getHead() == null) {
            for(int i =0; i<c2.numCars(); i++) {
                temp1.appendToTail(cursorP2.getData());
                cursorP2 = cursorP2.getNext();
            }
            return temp2;
        }

        CarList tempList = new CarList();
        int min = (c1.numCars()<c2.numCars()?c1.numCars():c2.numCars());
        CarListNode cursorPtr1 = c1.getHead();
        CarListNode cursorPtr2 = c2.getHead();

        for(int i =0; i<min;i++){
            tempList.appendToTail(cursorPtr1.getData());
            tempList.appendToTail(cursorPtr2.getData());
            cursorPtr1 = cursorPtr1.getNext();
            cursorPtr2 = cursorPtr2.getNext();
        }

        while(cursorPtr1 != null) {
            tempList.appendToTail(cursorPtr1.getData());
            cursorPtr1 = cursorPtr1.getNext();
        }
        while(cursorPtr2 != null) {
            tempList.appendToTail(cursorPtr2.getData());
            cursorPtr2 = cursorPtr2.getNext();
        }
        return tempList;
    }

}
