package ru.nsu.kgurin;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Deliverer tests.
 */
public class DelivererTest {
    @Test
    public void getSkillTest() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Deliverer deliverer = objectMapper.readValue(
                new File("src/test/resources/DelivererTest.json"),
                Deliverer.class
        );
        Assertions.assertEquals(7, deliverer.getSkill());
    }

    @Test
    public void getNameTest() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Deliverer deliverer = objectMapper.readValue(
                new File("src/test/resources/DelivererTest.json"),
                Deliverer.class
        );
        Assertions.assertEquals("Jake", deliverer.getName());
    }

    @Test
    public void getCapacityTest() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Deliverer deliverer = objectMapper.readValue(
                new File("src/test/resources/DelivererTest.json"),
                Deliverer.class
        );
        Assertions.assertEquals(2, deliverer.getCapacity());
    }

    @Test
    public void getIsDeliveringTest() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Deliverer deliverer = objectMapper.readValue(
                new File("src/test/resources/DelivererTest.json"),
                Deliverer.class
        );
        Assertions.assertFalse(deliverer.getIsDelivering());
    }

    @Test
    public void changeIsDeliveringTest() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Deliverer deliverer = objectMapper.readValue(
                new File("src/test/resources/DelivererTest.json"),
                Deliverer.class
        );
        deliverer.changeIsDelivering();
        Assertions.assertTrue(deliverer.getIsDelivering());
    }

    @Test
    public void bagIsFullTest() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Deliverer deliverer = objectMapper.readValue(
                new File("src/test/resources/DelivererTest.json"),
                Deliverer.class
        );
        deliverer.addItemToBag();
        deliverer.addItemToBag();
        Assertions.assertTrue(deliverer.isFull());
    }
}
