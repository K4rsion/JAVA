package ru.nsu.kgurin;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Baker tests.
 */
public class BakerTests {
    @Test
    public void changeIsCookingTest() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Baker baker = objectMapper.readValue(
                new File("src/test/resources/BakerTest.json"),
                Baker.class
        );
        baker.changeIsCooking();
        Assertions.assertTrue(baker.getIsCooking());
    }

    @Test
    public void getSkill() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Baker baker = objectMapper.readValue(
                new File("src/test/resources/BakerTest.json"),
                Baker.class
        );
        Assertions.assertEquals(6, baker.getSkill());
    }

    @Test
    public void getIsCooking() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Baker baker = objectMapper.readValue(
                new File("src/test/resources/BakerTest.json"),
                Baker.class
        );
        baker.changeIsCooking();
        Assertions.assertTrue(baker.getIsCooking());
    }

    @Test
    public void getName() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Baker baker = objectMapper.readValue(
                new File("src/test/resources/BakerTest.json"),
                Baker.class
        );
        Assertions.assertEquals("Albert", baker.getName());
    }
}
