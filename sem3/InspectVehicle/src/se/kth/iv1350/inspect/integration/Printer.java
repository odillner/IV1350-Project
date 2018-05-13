package se.kth.iv1350.inspect.integration;

import se.kth.iv1350.inspect.model.Reciept;
/**
 * Printer control
 */
public class Printer {

    /**
     * Constructor for printer
     */
    public Printer() {

    }

    /**
     * Prints reciept for payment
     * @param reciept   The reciept to be printed
     * @return if print job was successful
     */
    public boolean printReciept(Reciept reciept){
        return true;
    }

    /**
     * Prints results of inspection
     * @param result   The result to be printed
     * @return if print job was successful
     */
    public boolean printInspectionResult(String result){
        return true;
    }
}
