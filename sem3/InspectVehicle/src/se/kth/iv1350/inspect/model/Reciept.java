package se.kth.iv1350.inspect.model;

import java.text.SimpleDateFormat;
import java.util.Calendar;
/**
 * Representation of a reciept following purchase
 */

public class Reciept {

    private int amount;
    private String timeStamp;
    /**
     * Constructor for Reciept
     * @param amount    Amount payed
     */
    public Reciept(int amount) {
        this.amount = amount;
        this.timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
    }

}
