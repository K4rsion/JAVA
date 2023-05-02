package ru.nsu.kgurin;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;

/**
 * Class implementing deliverers.
 */
public class Deliverer implements Runnable {
    int capacity;
    int skill;
    String name;
    boolean isBusy = false;

    /**
     * Constructor for ru.nsu.kgurin.Deliverer class.
     *
     * @param skill    skill of deliverer
     * @param name     name of deliverer
     * @param capacity bag capacity of deliverer
     */
    public Deliverer(int capacity, int skill, String name) {
        this.capacity = capacity;
        this.skill = skill;
        this.name = name;
    }

    /**
     * Method to check if deliverer is busy or not.
     *
     * @return true if busy, false otherwise
     */
    public boolean isBusy() {
        return isBusy;
    }

    /**
     * Method to implement delivering process.
     *
     * @param orders list of orders
     * @throws InterruptedException if interrupted
     */
    public void deliver(List<Order> orders) throws InterruptedException {
        System.out.println("START(delivering): " + Arrays.toString(orders.toArray()) + " <- " + name);
        OptionalDouble average = orders.stream()
                .mapToInt(Order::getComplexity)
                .average();
        if (average.isPresent()) {
            double result = average.getAsDouble();
            Thread.sleep((long) (result / skill * 100L));
        }
        System.out.println("END(delivering): " + Arrays.toString(orders.toArray()) + " <- " + name);
    }

    /**
     * Deliver while being interrupted.
     */
    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            isBusy = true;
            try {
                List<Order> orders = Main.takeFromStock(capacity);
                if (orders.isEmpty()) {
                    isBusy = false;
                    return;
                }
                deliver(orders);
            } catch (InterruptedException e) {
                System.out.println("Deliverers handled all orders");
            }
            isBusy = false;
        }
    }
}
