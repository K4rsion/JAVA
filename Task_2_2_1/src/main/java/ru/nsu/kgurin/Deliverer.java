package ru.nsu.kgurin;

/**
 * Deliverer class.
 */
public class Deliverer {

    String name;
    int capacity;
    int skill;

    int occupied = 0;
    boolean isDelivering = false;

    /**
     * Empty constructor for Jackson
     */
    public Deliverer() {
    }

    /**
     * Clear deliverer's bag from items.
     */
    public void clearBag() {
        occupied = 0;
    }

    /**
     * Check if deliverer's bag is full.
     * @return true if bag is full, false otherwise
     */
    public boolean isFull() {
        return capacity <= occupied;
    }

    /**
     * Change state of deliverer.
     */
    public void changeIsDelivering() {
        isDelivering = !isDelivering;
    }

    /**
     * Get state of deliverer.
     * @return state of deliverer
     */
    public boolean getIsDelivering() {
        return isDelivering;
    }

    /**
     * Add item to bag.
     */
    public void addItemToBag() {
        occupied++;
    }

    /**
     * Get skill of deliverer.
     * @return skill of deliverer
     */
    public int getSkill() {
        return skill;
    }

    /**
     * Get name of deliverer.
     * @return  name of deliverer
     */
    public String getName() {
        return name;
    }

    /**
     * Get capacity of deliverer.
     * @return capacity of deliverer
     */
    public int getCapacity() {
        return capacity;
    }
}
