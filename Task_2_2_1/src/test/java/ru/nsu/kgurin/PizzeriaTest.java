package ru.nsu.kgurin;

import org.junit.jupiter.api.Test;

/**
 * Tests.
 */
public class PizzeriaTest {
    @Test
    public void pizzeriaTest() {
        try {
            Main.main(new String[]{});
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }
}
