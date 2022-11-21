//Angel Li
//112784616
//Angel.Li@stonybrook.edu
//Homework #2
//CSE 214 (R03)
//TA Kevin Cheng

/**
 * The OilChangeManager class creates three instances of the CarList class and
 * provides an interface for a user to manipulate the list by adding, and
 * removing Cars.
 *
 *
 * @author Angel Li
 * Angel.Li@stonybrook.edu
 * 112784616
 */

import java.util.Scanner;
public class OilChangeManager {
    public static void main(String[] args) throws EndOfListException {
        CarList listJoe = new CarList();
        CarList listDonny = new CarList();
        CarList listFinished = new CarList();
        CarList listCut = new CarList();
        Scanner input = new Scanner(System.in);
        String selection;
        String selectionName;
        System.out.println("Welcome to Tony's Discount Oil Change" +
                " Computer Management System! It's way better than a rolodex," +
                " cork board, post-its, and pre-chewed bubblegum!");

        System.out.println("L - List Operations - select Joe (J) or Donny (D)\n" +
                "M - Merge lists\n"+
                "P - Print Lists\n" +
                "F - Paste car to finished list.\n" +
                "Q - Quit");

        do {
            System.out.println("Pick an option:");
            selection = input.next();
            if(selection.equalsIgnoreCase("q")) {
                System.out.println("Enjoy your retirement!");
                break;
            }

            switch (selection) {
                case "L":
                case "l":
                    System.out.println("Please select Joe's List(J) or " +
                            "Donny's List(D):");
                    selectionName = input.next();
                    if (!(selectionName.equalsIgnoreCase("d") ||
                            selectionName.equalsIgnoreCase("j"))){
                        System.out.println("The selection was not Joe or Donny! " +
                                "Please try again and pick one!");
                        break;
                    }
                    else

                    System.out.println("A - Add a car to the end\n" +
                            "F - Cursor Forward\n" +
                            "H - Cursor to Head\n" +
                            "T - Cursor to Tail\n" +
                            "B - Cursor Backward\n" +
                            "I - Insert car before cursor\n" +
                            "X - Cut car at cursor\n" +
                            "V - Paste car before cursor\n" +
                            "R - Remove car at cursor\n");


                    System.out.println("Please select a list option:");
                    String selection2 = input.next();
                    switch (selection2) {

                            case "a":
                            case "A":
                                try {
                                    System.out.println("Please enter vehicle make " +
                                        "(Ford, GMC, Chevy, Jeep, Dodge, Chrysler, " +
                                        "and Lincoln):");
                                    String name = input.next().toLowerCase();
                                    Make carType = Make.valueOf(Make.class, name);
                                    System.out.println("Please enter owner's name:");
                                    String ownerName = input.next();
                                    Car newCar = new Car((Make) carType, ownerName);

                                    if (selectionName.equalsIgnoreCase("j")) {
                                    listJoe.appendToTail(newCar);
                                    System.out.println(ownerName + "'s " + name + " has been " +
                                            "scheduled for an " +
                                            "oil change with Joe and has been added to his list");
                                    System.out.println("");
                                     }
                                    if (selectionName.equalsIgnoreCase("d")) {
                                    listDonny.appendToTail(newCar);
                                    System.out.println(ownerName + "'s " + name + " has been " +
                                            "scheduled for an " +
                                            "oil change with Donny and has been added to his list");
                                    System.out.println("");
                                    }
                                }catch(IllegalArgumentException ex){
                                    System.out.println("We don't service that car!");
                                    System.out.println("");
                                }
                                break;

                            case "F":
                            case "f":
                                try {
                                    if (selectionName.equalsIgnoreCase("j")) {
                                        listJoe.cursorForward();
                                        System.out.println("Cursor moved forward in Joe's List");
                                        System.out.println("");
                                    }
                                    if (selectionName.equalsIgnoreCase("d")) {
                                        listDonny.cursorForward();
                                        System.out.println("Cursor moved forward in Donny's List");
                                        System.out.println("");
                                    }
                                }catch(EndOfListException ex1){
                                    System.out.println("Cursor is at the end");
                                    System.out.println("");
                                }
                                break;

                            case "H":
                            case "h":
                                if (selectionName.equalsIgnoreCase("j")) {
                                    listJoe.resetCursorToHead();
                                    System.out.println("Cursor reset to head in Joe's list");
                                    System.out.println("");
                                }
                                if (selectionName.equalsIgnoreCase("d")) {
                                    listDonny.resetCursorToHead();
                                    System.out.println("Cursor reset to head in Donny's list");
                                    System.out.println("");
                                }
                                break;

                            case "T":
                            case "t":
                                if (selectionName.equalsIgnoreCase("j")) {
                                    listJoe.setCursor(listJoe.getTail());
                                    System.out.println("Cursor moved to tail in Joe's list");
                                    System.out.println("");
                                }
                                if (selectionName.equalsIgnoreCase("d")) {
                                    listJoe.setCursor(listDonny.getTail());
                                    System.out.println("Cursor moved to tail in Donny's list");
                                    System.out.println("");
                                }
                                break;

                            case "B":
                            case "b":
                                try {
                                    if (selectionName.equalsIgnoreCase("j")) {
                                        listJoe.cursorBackward();
                                        System.out.println("Cursor moved backward in Joe's List");
                                        System.out.println("");
                                    }
                                    if (selectionName.equalsIgnoreCase("d")) {
                                        listDonny.cursorBackward();
                                        System.out.println("Cursor moved backward in Donny's List");
                                        System.out.println("");
                                    }
                                }catch(EndOfListException ex1){
                                    System.out.println("Cursor is at the front");
                                    System.out.println("");
                                }
                                break;

                            case "I":
                            case "i":

                                System.out.println("Please enter vehicle make " +
                                        "(Ford, GMC, Chevy, Jeep, Dodge, Chrysler, " +
                                        "and Lincoln):");
                                String name = input.next().toLowerCase();
                                Make carType = Make.valueOf(Make.class, name);
                                System.out.println("Please enter owner's name:");
                                String ownerName = input.next();
                                Car newCar = new Car((Make) carType, ownerName);

                                if (selectionName.equalsIgnoreCase("j")) {
                                    listJoe.insertBeforeCursor(newCar);
                                    System.out.println(ownerName + "'s " + name + " has been " +
                                            "scheduled for an " +
                                            "oil change with Joe and has been added to his list");
                                    System.out.println("");
                                }
                                if (selectionName.equalsIgnoreCase("d")) {
                                    listDonny.insertBeforeCursor(newCar);
                                    System.out.println(ownerName + "'s " + name + " has been " +
                                            "scheduled for an " +
                                            "oil change with Donny and has been added to his list");
                                    System.out.println("");
                                }

                                break;

                            case "X":
                            case "x":
                                try {
                                    if (selectionName.equalsIgnoreCase("j")) {
                                        Car newCar2 = new Car((Make) listJoe.getCursorCar().getData().getMake()
                                                , listJoe.getCursorCar().getData().getOwner());
                                        listCut.appendToTail(newCar2);
                                        listJoe.removeCar();
                                        System.out.println("Cursor cut in Joe's List.");
                                        System.out.println("");
                                    }
                                    if (selectionName.equalsIgnoreCase("d")) {
                                        Car newCar2 = new Car((Make) listDonny.getCursorCar().getData().getMake()
                                                , listDonny.getCursorCar().getData().getOwner());
                                        listCut.appendToTail(newCar2);
                                        listDonny.removeCar();
                                        System.out.println("Cursor cut in Donny's List.");
                                        System.out.println("");
                                    }
                                }catch(Exception exc){
                                    System.out.println("Nothing to cut");
                                    System.out.println("");
                                }

                                break;

                            case "V":
                            case "v":
                                //paste car
                                if(listCut.getCursorCar() == null) {
                                    System.out.println("Nothing to paste");
                                    System.out.println("");
                                    break;
                                }
                                else{
                                    if (selectionName.equalsIgnoreCase("j")) {
                                        listJoe.insertBeforeCursor(listCut.getCursorCar().getData());
                                        listCut.removeCar();
                                        System.out.println("Car pasted in Joe's List");
                                        System.out.println("");
                                    }

                                    if (selectionName.equalsIgnoreCase("d")) {
                                        listDonny.insertBeforeCursor(listCut.getCursorCar().getData());
                                        listCut.removeCar();
                                        System.out.println("Car pasted in Donny's List");
                                        System.out.println("");
                                    }
                                }
                                break;

                            case "R":
                            case "r":
                                try {
                                    if (selectionName.equalsIgnoreCase("j")) {
                                        listJoe.removeCar();
                                        System.out.println("Cursor removed in Joe's List.");
                                        System.out.println("");
                                    }
                                    if (selectionName.equalsIgnoreCase("d")) {
                                        listDonny.removeCar();
                                        System.out.println("Cursor removed in Donny's List.");
                                        System.out.println("");
                                    }
                                }catch(Exception ex){
                                    System.out.println("No car to remove");
                                    System.out.println("");
                                }
                                break;

                            default:
                            System.out.println("");
                            System.out.println(selection + " is not a menu option. " +
                                    "Please try again:");
                            System.out.println("");
                    }
                    break;

                case "M":
                case "m":
                    System.out.println("Select a list to merge into:");
                    String selectionName2 = input.next();
                    CarList tempMerge1 = CarList.mergeLists(listJoe,listDonny);
                    CarList tempMerge2 = CarList.mergeLists(listDonny,listJoe);
                    if (selectionName2.equalsIgnoreCase("j")) {
                        listJoe = tempMerge1;
                        while(listDonny.getCursor() != null) {
                            listDonny.removeCar();
                        }
                        System.out.println("Car list merged into Joe's list");
                        System.out.println("");
                    }

                    if (selectionName2.equalsIgnoreCase("d")) {
                        listDonny = tempMerge2;
                        while(listJoe.getCursor() != null) {
                            listJoe.removeCar();
                        }
                        System.out.println("Car list merged into Donny's list");
                        System.out.println("");
                    }

                    break;

                case "P":
                case "p":
                    System.out.println("Joe's List:");
                    System.out.println("\tMake \t\t\tName" );
                    System.out.println("-----------------------------------");
                    System.out.println(listJoe.toString());
                    System.out.println("");
                    System.out.println("Donny's List:");
                    System.out.println("\tMake \t\t\tName" );
                    System.out.println("-----------------------------------");
                    System.out.println(listDonny.toString());
                    System.out.println("");
                    System.out.println("Finished List:");
                    System.out.println("\tMake \t\t\tName" );
                    System.out.println("-----------------------------------");
                    System.out.println(listFinished.toString());
                    System.out.println("");



                    break;

                case "F":
                case "f":
                    if(listCut.getHead()!=null){
                        listFinished.appendToTail(listCut.getHead().getData());
                        listCut.removeCar();
                        System.out.println("Car pasted in finished list.");
                        System.out.println("");
                    }
                    else{
                        System.out.println("Nothing to paste");
                        System.out.println("");
                    }
                    break;

                case "Q":
                case "q":
                    System.out.println("Enjoy your retirement!");
                    break;

                default:
                    System.out.println("");
                    System.out.println(selection + " is not a menu option. " +
                            "Please try again:");
                    System.out.println("");

            }
        } while (!selection.equalsIgnoreCase("Q"));
    }
}
