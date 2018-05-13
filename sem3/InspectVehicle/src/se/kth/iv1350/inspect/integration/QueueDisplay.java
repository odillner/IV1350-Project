package se.kth.iv1350.inspect.integration;

/**
 * Handles queue and corresponding display
 */

public class QueueDisplay {
    private int queueNumber;

    /**
     * Queue display constructor
     */
    public QueueDisplay() {
        this.queueNumber = 1;
    }

    /**
     * Increments queue number
     */
    public void nextNumber() {
        queueNumber++;
    }

    /**
     * @return current queueNumber
     */
    public int getQueueNumber() {
        return this.queueNumber;
    }

    /**
     * Resets queue to initial value
     */
    public void resetQueue() {
        this.queueNumber = 1;
    }
}
