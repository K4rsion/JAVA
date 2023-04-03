package ru.nsu.kgurin;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Stock tests.
 */
public class StockTest {
    @Test
    public void getCapacityTest() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Stock stock = objectMapper.readValue(
                new File("src/test/resources/StockTest.json"),
                Stock.class
        );
        Assertions.assertEquals(2, stock.getCapacity());
    }

    @Test
    public void getOccupiedTest() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Stock stock = objectMapper.readValue(
                new File("src/test/resources/StockTest.json"),
                Stock.class
        );
        Assertions.assertEquals(0, stock.getOccupied());
    }

    @Test
    public void getNameTest() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Stock stock = objectMapper.readValue(
                new File("src/test/resources/StockTest.json"),
                Stock.class
        );
        Assertions.assertEquals("BaconStreet", stock.getName());
    }

    @Test
    public void addItemTest() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Stock stock = objectMapper.readValue(
                new File("src/test/resources/StockTest.json"),
                Stock.class
        );
        stock.addItem();
        Assertions.assertEquals(1, stock.getOccupied());
    }

    @Test
    public void removeItemTest() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Stock stock = objectMapper.readValue(
                new File("src/test/resources/StockTest.json"),
                Stock.class
        );
        stock.addItem();
        stock.addItem();
        stock.removeItem();
        Assertions.assertEquals(1, stock.getOccupied());
    }

    @Test
    public void isFullTest() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Stock stock = objectMapper.readValue(
                new File("src/test/resources/StockTest.json"),
                Stock.class
        );
        stock.addItem();
        stock.addItem();
        Assertions.assertTrue(stock.isFull());
    }
}
