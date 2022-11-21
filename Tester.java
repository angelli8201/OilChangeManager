

public class Tester {
    public static void main(String[] args) throws EndOfListException {
        Car c1 = new Car(Make.ford, "1");
        Car c2 = new Car(Make.chevy, "2");
        Car c3 = new Car(Make.chrysler, "3");
        Car c4 = new Car(Make.ford, "4");
        Car c5 = new Car(Make.ford, "5");
        Car c6 = new Car(Make.ford, "6");
        CarListNode l1 = new CarListNode(c1);
        CarListNode l2 = new CarListNode(c2);
        CarListNode l3 = new CarListNode(c3);
        CarList list1 = new CarList();
        CarList list2 = new CarList();
        list2.insertBeforeCursor(c2);
        list2.insertBeforeCursor(c1);


        CarList list3 = CarList.mergeLists(list2,list1);
        System.out.println(list3);


























    }
}
