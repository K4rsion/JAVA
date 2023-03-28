package ru.nsu.kgurin;

/**
 * Class for describing current order.
 */
public class Order {
    String id;
    int complexity;

    /**
     * Empty constructor for Jackson
     */
    public Order() {
    }

    /**
     * Get order ID.
     *
     * @return order ID
     */
    public String getId() {
        return id;
    }

    /**
     * Get order complexity(for calculating necessary
     * time for bakers and deliverers to handle this order).
     *
     * @return order complexity
     */
    public int getComplexity() {
        return complexity;
    }
}
