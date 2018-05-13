package se.kth.iv1350.inspect.integration;

/**
* Controls the garage door
*/
public class GarageDoor {
    private boolean open;

    /**
     * Garage door constructor
     */
    public GarageDoor(){
        this.open = false;
    }

    /**
     * Opens garage door
     */
    public void open(){
        this.open = true;
    }
    
    /**
     * Closes garage door
     */
    public void close(){
        this.open = false;
    }

    /**
     * @return current state of garage door
     */
    public boolean getState(){
        return this.open;
    }
}