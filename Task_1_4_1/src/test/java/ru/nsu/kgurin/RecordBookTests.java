package ru.nsu.kgurin;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Tests for my Record Book implementation.
 */
public class RecordBookTests {
    //atomic tests
    @Test
    public void addSemesterTest() {
        //actual
        RecordBook actual = new RecordBook(5);
        actual.addSemester(1, "Math", 5);

        //expected
        Map<String, Integer> expected = new HashMap<>();
        expected.put("Math", 5);

        //asserts
        Assertions.assertEquals(expected,
                actual.getSemester().get(1).getSubjectMark());
    }

    @Test
    public void removeSemesterTest() {
        //actual
        RecordBook actual = new RecordBook(5);
        actual.addSemester(1, "Math", 5);
        actual.removeSemester(1, "Math");

        //expected
        Map<String, Integer> expected = new HashMap<>();
        expected.put("Math", 5);

        //asserts
        Assertions.assertNotEquals(expected,
                actual.getSemester().get(1).getSubjectMark());
    }

    @Test
    public void gpaTest() {
        //actual
        RecordBook actual = new RecordBook(5);
        actual.addSemester(1, "Math", 5);
        actual.addSemester(2, "History", 4);
        actual.addSemester(3, "Java", 5);

        //asserts
        Assertions.assertEquals((float) (14.0 / 3), actual.gpa());
    }

    @Test
    public void gpaForSemesterTest() {
        //actual
        RecordBook actual = new RecordBook(5);
        actual.addSemester(1, "Math", 5);
        actual.addSemester(2, "History", 4);
        actual.addSemester(3, "Java", 5);

        //asserts
        Assertions.assertEquals((float) 4.0, actual.gpa(2));
    }

    @Test
    public void scholarshipTest() {
        //actual
        RecordBook actual = new RecordBook(5);
        actual.addSemester(1, "Math", 5);
        actual.addSemester(1, "History", 4);
        actual.addSemester(1, "Java", 3);

        //asserts
        Assertions.assertFalse(actual.scholarship(1));
    }

    @Test
    public void redDiplomaTest() {
        // Diploma work is less than 5
        RecordBook actualDiploma = new RecordBook(4);
        Assertions.assertFalse(actualDiploma.redDiploma());

        // There is a "3" in the last semester
        RecordBook actualBadMark = new RecordBook(5);
        actualBadMark.addSemester(1, "Math", 5);
        actualBadMark.addSemester(8, "Math", 3);
        Assertions.assertFalse(actualBadMark.redDiploma());

        // Less than 75% of mark is "5"
        RecordBook actualApplication = new RecordBook(5);
        actualApplication.addSemester(8, "C", 4);
        actualApplication.addSemester(8, "English", 4);
        actualApplication.addSemester(8, "Philosophy", 5);
        actualApplication.addSemester(8, "Project", 5);
        Assertions.assertFalse(actualApplication.redDiploma());
    }

    //other tests
    @Test
    public void differentMethodsTest() {
        RecordBook ivan = new RecordBook(4);
        ivan.addSemester(1, "Math", 5);
        ivan.addSemester(2, "OOP", 2);
        ivan.addSemester(3, "History", 2);
        ivan.addSemester(4, "Project", 3);
        ivan.addSemester(5, "C", 4);
        ivan.addSemester(6, "Philosophy", 5);
        ivan.addSemester(7, "English", 3);
        ivan.addSemester(8, "C++", 4);

        Assertions.assertFalse(ivan.scholarship(3));
        Assertions.assertFalse(ivan.redDiploma());

        RecordBook elena = new RecordBook(5);
        elena.addSemester(1, "Math", 4);
        elena.addSemester(2, "OOP", 5);
        elena.addSemester(3, "History", 5);
        elena.addSemester(4, "Project", 5);
        elena.addSemester(5, "C", 3);
        elena.addSemester(6, "Philosophy", 5);
        elena.addSemester(7, "English", 4);
        elena.addSemester(8, "C++", 5);

        Assertions.assertTrue(elena.scholarship(3));
        Assertions.assertTrue(elena.redDiploma());

        Assertions.assertTrue(elena.gpa() > ivan.gpa());

    }
}
