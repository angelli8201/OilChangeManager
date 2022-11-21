//Angel Li
//112784616
//Angel.Li@stonybrook.edu
//Homework #2
//CSE 214 (R03)
//TA Kevin Cheng

/**
 * I created an enum which contains the following makes:
 * FORD, GMC, CHEVY,  JEEP, DODGE, CHRYSLER, and LINCOLN.
 *
 *
 * @author Angel Li
 * Angel.Li@stonybrook.edu
 * 112784616
 */
public enum Make{
    ford(1), gmc(2), chevy(3), jeep(4), dodge(5),
    chrysler(6), lincoln(7);

    private final int value;

    /**
     * This is constructor used to make a new Make object
     *
     * @param value
     * The value associated with each enum object
     */
    private Make(int value) { this.value = value; }

    /**
     * The method gets the value associated with each enum object
     *
     * @return
     * integer associated with enum object
     */
    public int getValue() { return value; }


}


