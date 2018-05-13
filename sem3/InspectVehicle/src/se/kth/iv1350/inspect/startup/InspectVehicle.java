package se.kth.iv1350.inspect.startup;

import se.kth.iv1350.inspect.integration.*;
import se.kth.iv1350.inspect.view.View;
import se.kth.iv1350.inspect.controller.Controller;

public class InspectVehicle {

    /**
     *   main method, inits integration modules, controller and view
     *   @param args
     */
    public static void main(String[] args) {

        GarageDoor door = new GarageDoor();
        PaymentAuthorization authorizer = new PaymentAuthorization();
        Printer printer = new Printer();
        QueueDisplay display = new QueueDisplay();
        VehicleRegistry registry = new VehicleRegistry();

        Controller control = new Controller(door,authorizer,printer,display,registry);
        new View(control);
    }

}