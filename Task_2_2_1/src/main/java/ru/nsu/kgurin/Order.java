package ru.nsu.kgurin;

/**
 * Class implementing order.
 */
public class Order {
    int complexity;
    String id;

    /**
     * Constructor for ru.nsu.kgurin.Order class.
     *
     * @param complexity complexity of current order
     * @param id         id of current order
     */
    public Order(int complexity, String id) {
        this.complexity = complexity;
        this.id = id;
    }

    /**
     * Method to get complexity of current order.
     *
     * @return complexity of current order
     */
    public int getComplexity() {
        return complexity;
    }

    /**
     * Method to get id of current order.
     *
     * @return id of current order
     */
    public String getId() {
        return id;
    }

    /**
     * Method to get order as string.
     *
     * @return order as string
     */
    @Override
    public String toString() {
        return id;
    }
}
