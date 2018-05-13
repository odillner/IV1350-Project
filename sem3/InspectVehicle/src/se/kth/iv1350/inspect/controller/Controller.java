package se.kth.iv1350.inspect.controller;

import se.kth.iv1350.inspect.model.*;
import se.kth.iv1350.inspect.integration.*;

/**
 * The application controller
 */
public class Controller {

    private GarageDoor door;
    private PaymentAuthorization authorizer;
    private Printer printer;
    private QueueDisplay display;
    private VehicleRegistry registry;

    private Vehicle currVehicle;
    
    /**
     * Contructor for controller
     *
     * @param door          The garage door
     * @param authorizer    The payment authorization          
     * @param printer       The printer
     * @param display       The queue number display
     * @param registry      The vehicle registry
     */ 
    public Controller(GarageDoor door, PaymentAuthorization authorizer, Printer printer, QueueDisplay display, VehicleRegistry registry) {
        this.print("Initializing..");
        this.door = door;
        this.authorizer = authorizer;
        this.printer = printer;
        this.display = display;
        this.registry = registry;
        this.print("Initialization done");
    }
    private void print(String s){
        String out = "CONTROLLER: " + s + ".";
        System.out.println(out);
    }
    /**
     * Starts a new vehicle inspection by openining garage door and incrementing queue display number
     */
    public void startInspection(){
        this.door.open();
        this.print("Garage door opened");

        this.display.nextNumber();
        this.print("Queue display updated");
    }

    /**
     * Open garage door after inspection is done.
     */
    public void openGarageDoor(){
        this.door.open();
        this.print("Garage door opened");
    }

    /**
     * Close garage door after new inspection has started or after customer has left garage
     */
    public void closeGarageDoor(){
        this.door.close();
        this.print("Garage door closed");
    }


    /**
     * Enters car into system, allowing it to be processed
     * @param regNumber     The vehicles registration number
     * @return total inspection cost
     */
    public int enterRegNumber(String regNumber){
        if (this.setCurrVehicle(regNumber)) {
            this.print("Calculating total cost");
            return this.currVehicle.getTotalInspectionCost();
        } else {
            return 0;
        }
    }

    private boolean setCurrVehicle(String regNumber){
        this.print("Searching for car in registry");
        this.currVehicle = this.registry.findVehicle(regNumber);

        if (this.currVehicle==null){
            this.print("No such car in registry");
            return false;
        } else {
            this.print("Car found");
            return true;
        }
    }

    /** 
     *  Initializes a payment by credit card
     *  @param card     Credit card
     *  @param amount   Amount to pay
     */
    public void creditCardPayment(CreditCard card, int amount){
        this.print("Initializing credit card payment");
        this.print("Seeking authorization for payment");

        if (this.authorizer.authorizePayment(card,amount)) {
            this.print("Payment authorized, printing reciept..");
        } else {
            this.print("Failed to authorize payment, please try again");
        }

        Reciept reciept = new Reciept(amount);
        if (this.printer.printReciept(reciept)){
            this.print("Reciept print job successful");
        } else {
            this.print("Reciept print job failed");
        }
    }

    /** 
     *  Provides inspector with next inspection to be performed to current car
     *  @return Inspection to be performed next
     */
    public String getNextInspection(){
        return this.currVehicle.getNextNotPassedInspection().getName();
    }
    
    public void passCurrInspection(){
        this.currVehicle.passCurrInspection();
    }
}