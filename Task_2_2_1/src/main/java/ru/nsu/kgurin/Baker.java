package ru.nsu.kgurin;

/**
 * Class implementing bakers.
 */
public class Baker implements Runnable {
    int skill;
    String name;
    boolean isBusy = false;

    /**
     * Constructor for ru.nsu.kgurin.Baker class.
     *
     * @param skill skill of baker
     * @param name  name of baker
     */
    public Baker(int skill, String name) {
        this.skill = skill;
        this.name = name;
    }

    /**
     * Method to check if baker is busy or not.
     *
     * @return true if busy, false otherwise
     */
    public boolean isBusy() {
        return isBusy;
    }

    /**
     * Method to implement cooking process.
     *
     * @param order current order
     * @throws InterruptedException if interrupted
     */
    public void cook(Order order) throws InterruptedException {
        System.out.println("START(cooking): [" + order.getId() + "] <- " + name);
        Thread.sleep(order.getComplexity() / skill * 100L);
        System.out.println("END(cooking): [" + order.getId() + "] <- " + name);
    }

    /**
     * Cook while being interrupted.
     */
    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            isBusy = true;
            try {
                Order order = Main.takeFromQueue();
                if (order == null) {
                    isBusy = false;
                    return;
                }
                cook(order);
                Main.putInStock(order);
            } catch (InterruptedException e) {
                System.out.println("Bakers handled all orders");
            }
            isBusy = false;
        }
    }
}