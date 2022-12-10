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
    public void AddSemesterTest() {
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
    public void RemoveSemesterTest() {
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
    public void GpaTest() {
        //actual
        RecordBook actual = new RecordBook(5);
        actual.addSemester(1, "Math", 5);
        actual.addSemester(2, "History", 4);
        actual.addSemester(3, "Java", 5);

        //asserts
        Assertions.assertEquals((float) (14.0 / 3), actual.gpa());
        Assertions.assertEquals((float) 4.0, actual.gpa(2));
    }

    @Test
    public void ScholarshipTest() {
        //actual
        RecordBook actual = new RecordBook(5);
        actual.addSemester(1, "Math", 5);
        actual.addSemester(1, "History", 4);
        actual.addSemester(1, "Java", 3);

        //asserts
        Assertions.assertFalse(actual.scholarship(1));
    }

    @Test
    public void RedDiplomaTest() {
        // Diploma work is less than 5
        RecordBook actualDiploma = new RecordBook(4);
        Assertions.assertFalse(actualDiploma.redDiploma());

        // There is a "3" in the last semester
        RecordBook actualBadMark = new RecordBook(5);
        actualBadMark.addSemester(1, "Math", 5);
        actualBadMark.addSemester(8, "Math", 3);
        Assertions.assertFalse(actualBadMark.redDiploma());

        // Less than 75% of mark is "5"
        RecordBook actualApllication = new RecordBook(5);
        actualApllication.addSemester(8, "C", 4);
        actualApllication.addSemester(8, "English", 4);
        actualApllication.addSemester(8, "Philosophy", 5);
        actualApllication.addSemester(8, "Project", 5);
        Assertions.assertFalse(actualApllication.redDiploma());
    }

    //other tests
    @Test
    public void DifferentMethodsTest() {
        RecordBook Ivan = new RecordBook(4);
        Ivan.addSemester(1, "Math", 5);
        Ivan.addSemester(2, "OOP", 2);
        Ivan.addSemester(3, "History", 2);
        Ivan.addSemester(4, "Project", 3);
        Ivan.addSemester(5, "C", 4);
        Ivan.addSemester(6, "Philosophy", 5);
        Ivan.addSemester(7, "English", 3);
        Ivan.addSemester(8, "C++", 4);

        Assertions.assertFalse(Ivan.scholarship(3));
        Assertions.assertFalse(Ivan.redDiploma());

        RecordBook Elena = new RecordBook(5);
        Elena.addSemester(1, "Math", 4);
        Elena.addSemester(2, "OOP", 5);
        Elena.addSemester(3, "History", 5);
        Elena.addSemester(4, "Project", 5);
        Elena.addSemester(5, "C", 3);
        Elena.addSemester(6, "Philosophy", 5);
        Elena.addSemester(7, "English", 4);
        Elena.addSemester(8, "C++", 5);

        Assertions.assertTrue(Elena.scholarship(3));
        Assertions.assertTrue(Elena.redDiploma());

        Assertions.assertTrue(Elena.gpa() > Ivan.gpa());

    }
}
