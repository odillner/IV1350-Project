package se.kth.iv1350.inspect.integration;

import se.kth.iv1350.inspect.model.Vehicle;

/**
 * Registry containing vehicles and corresponding inspections
 */
public class VehicleRegistry {

    private Vehicle[] vehicles;

    /**
     * Constructor for vehicle registry
     */
    public VehicleRegistry() {
        this.vehicles[0] = new Vehicle("ABC123",3);
        this.vehicles[1] = new Vehicle("ACB321",0);
        this.vehicles[2] = new Vehicle("CBA132",2);
    }

    /**
     * Find the vehicle with corresponding regNumber
     * @return vehicle with corresponding regNumber or null if no such vehicle exists
     */
    public Vehicle findVehicle(String regNumber) {
        for (int i=0;i<this.vehicles.length;i++){
            if (this.vehicles[i].getRegNumber()==regNumber){
                return this.vehicles[i];
            }
        }

        return null;
    }
}