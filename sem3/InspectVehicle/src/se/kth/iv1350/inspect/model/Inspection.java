package se.kth.iv1350.inspect.model;

/**
 *  Represents single inspection to be performed to corresponding vehicle
 */
public class Inspection {

    public static final String[] POSSIBLE_NAMES = {"wheels","engine","brake lights","oil levels"};
    public static final int[] CORRESPONDING_COSTS = {500,1000,150,100};

    private int cost;
    private String name;
    private boolean passed;

    /**
     * Constructor for Inspection
     * @param index     Generates inspection depending on specified index
     */
    public Inspection(int index) {
        if (index>3) {
            index=3;
        }
        this.cost = CORRESPONDING_COSTS[index];
        this.name = POSSIBLE_NAMES[index];
        this.passed = false;
    }

    /**
     * @return inspection cost
     */
    public int getCost() {
        return this.cost;
    }

    /**
     * @return inspection name
     */
    public String getName() {
        return this.name;
    }

    /**
     * @return inspection passed state
     */
    public boolean getState() {
        return this.passed;
    }

    /**
     * Sets the inspection as passed
     */
    public void setPassed() {
        this.passed = true;
    }
    
}