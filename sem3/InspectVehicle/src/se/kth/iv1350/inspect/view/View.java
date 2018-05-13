package se.kth.iv1350.inspect.view;

import se.kth.iv1350.inspect.controller.Controller;
public class View {
    private Controller control;

    /**
     * constructor for view
     * @param control Controller used by view
     */
    public View(Controller control) {
        this.control = control;
        this.sampleFlow();
    }
    private void sampleFlow(){
        
    }
}