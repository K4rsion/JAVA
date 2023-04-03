package ru.nsu.kgurin;

/**
 * Stock class.
 */
public class Stock {
    String name;
    int capacity;
    int occupied = 0;

    /**
     * Empty constructor for Jackson.
     */
    public Stock() {
    }

    /**
     * Method determine if stock is full or not.
     *
     * @return true if is full, false otherwise
     */
    public boolean isFull() {
        return capacity <= occupied;
    }

    /**
     * Add item to stock.
     */
    public void addItem() {
        occupied++;
    }

    /**
     * Remove item from stock.
     */
    public void removeItem() {
        occupied--;
    }

    /**
     * Get a capacity of stock.
     *
     * @return capacity of stock
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * Get count of occupied place in stock.
     *
     * @return count of occupied place in stock
     */
    public int getOccupied() {
        return occupied;
    }

    /**
     * Get name of stock.
     *
     * @return name of stock
     */
    public String getName() {
        return name;
    }
}
