package ru.nsu.kgurin;

import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.channels.Channels;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/** Tests for my realization of Rabin-Karp algorithm
 */
public class RabinCarpAlgorithmTests {
    @Test
    public void simpleTest() throws IOException {
        try (InputStream stream =
                     getClass().getClassLoader().getResourceAsStream("SimpleTest.txt")) {
            RabinKarpAlgorithm alg = new RabinKarpAlgorithm(stream);
            List<Integer> act = alg.rabinKarp("e");
            List<Integer> exp = Arrays.asList(1, 6, 17, 22, 29, 34, 37);

            Assertions.assertEquals(exp, act);
        }
    }

    @Test
    public void countTest() throws IOException {
        try (InputStream file =
                     getClass().getClassLoader().getResourceAsStream("ForOblomov.txt")) {
            assert file != null;
            Scanner scan = new Scanner(file, StandardCharsets.UTF_8);

            String inputFile = scan.nextLine();
            String subline = scan.nextLine();

            try (InputStream stream =
                         getClass().getClassLoader().getResourceAsStream(inputFile)) {
                RabinKarpAlgorithm alg = new RabinKarpAlgorithm(stream);
                List<Integer> act = alg.rabinKarp(subline);

                Assertions.assertEquals(240, act.size());
            }
        }
    }

    @Test
    public void hugeTest() throws IOException {
        try (RandomAccessFile f =
                     new RandomAccessFile("./src/test/resources/HugeTest.txt", "rw")) {
            f.setLength(2000000L);
            f.seek(2341);
            f.writeBytes("test");
            f.seek(12312);
            f.writeBytes("test");
            f.seek(1558188);
            f.writeBytes("test");
            f.seek(0);

            RabinKarpAlgorithm alg = new RabinKarpAlgorithm(
                    Channels.newInputStream(f.getChannel()));
            String subline = "test";

            List<Integer> act = alg.rabinKarp(subline);
            List<Integer> exp = Arrays.asList(2341, 12312, 1558188);

            Assertions.assertEquals(exp, act);
        }
    }
}



