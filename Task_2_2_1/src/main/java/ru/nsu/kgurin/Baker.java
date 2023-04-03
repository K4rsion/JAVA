package ru.nsu.kgurin;

/**
 * Baker class.
 */
public class Baker {
    String name;
    int skill;
    boolean isCooking = false;

    /**
     * Empty constructor for Jackson.
     */
    public Baker() {
    }

    /**
     * Change state of baker.
     */
    public void changeIsCooking() {
        isCooking = !isCooking;
    }

    /**
     * Get skill of baker.
     *
     * @return skill of baker
     */
    public int getSkill() {
        return skill;
    }

    /**
     * Get state of baker.
     *
     * @return state of baker
     */
    public boolean getIsCooking() {
        return isCooking;
    }

    /**
     * Get name of baker.
     *
     * @return name of baker
     */
    public String getName() {
        return name;
    }
}