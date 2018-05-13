package se.kth.iv1350.inspect.model;

import se.kth.iv1350.inspect.model.Inspection;

/**
 * Vehicle object, used to represent vehicles in registry
 */
public class Vehicle {
    private String regNumber;
    private int nOfInspections;
    private Inspection[] inspections;
    private int currInspection;

    /** 
    * Constructor for Vehicle
    * @param regNumber          The vehicles corresponding registration number
    * @param nOfInspections     The number of inspections that are necessary to perform
    */
    public Vehicle(String regNumber, int nOfInspections) {
        this.regNumber = regNumber;
        this.nOfInspections = nOfInspections;
        this.currInspection = 0;

        for (int i=0;i<this.nOfInspections;i++){
            this.inspections[i] = new Inspection(i);
        }
    }

    /**
     * @return vehicle registration number
     */
    public String getRegNumber() {
        return this.regNumber;
    }

    /**
     * @return next inspection to be performed or null if no inspections remain
     */
    public Inspection getNextNotPassedInspection() {
        if (this.checkIfInspectionComplete()){
            return null;
        }
        while (true) {

            if (!this.inspections[this.currInspection].getState()) {
                return this.inspections[this.currInspection];
            }

            this.currInspection++;
            
            if (this.currInspection==this.nOfInspections){
                this.currInspection = 0;
            }
        }
    }

    private boolean checkIfInspectionComplete() {
        boolean passed = true;

        for (int i=0;i<this.nOfInspections;i++) {
            if (!this.inspections[i].getState()) {
                passed = false;
                break;
            }
        }

        return passed;
    }
    
    /**
     * @return total inspection cost
     */
    public int getTotalInspectionCost() {
        int total = 0;

        for (int i=0;i<this.nOfInspections;i++) {
            total += this.inspections[i].getCost();
        }

        return total;
    }

    /**
     * Passes the inspection that is currently being processed
     */
    public void passCurrInspection() {
        this.inspections[this.currInspection].setPassed();
    }
}