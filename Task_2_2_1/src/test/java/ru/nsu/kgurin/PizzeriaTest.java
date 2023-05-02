package ru.nsu.kgurin;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * Tests.
 */
public class PizzeriaTest {
    @Test
    public void pizzeriaTest() {
        try {
            Main.main(new String[]{});
        } catch (NullPointerException e) {
            System.err.println(Arrays.toString(e.getStackTrace()));
            throw new NullPointerException();
        }

    }
}
