package ru.nsu.kgurin;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * An implementation of Electronic Record Book.
 */
public class RecordBook {

    private final int diplomaWork;
    private final Map<Integer, Marks> semesterSubjectMark = new HashMap<>();

    /**
     * Constructor for RecordBook class.
     */
    public RecordBook(int diplomaMark) {
        this.diplomaWork = diplomaMark;
    }

    /**
     * Getter for current map of semesterSubjectMark.
     *
     * @return current map
     */
    public Map<Integer, Marks> getSemester() {
        return semesterSubjectMark;
    }

    /**
     * Method to add new semester or new subject for current student.
     *
     * @param semester semester to add
     * @param subject  subject for this semester to add
     * @param mark     mark for this subject to add
     */
    public void addSemester(int semester, String subject, int mark) {
        semesterSubjectMark.computeIfAbsent(semester, (k) -> new Marks())
                .getSubjectMark().put(subject, mark);
    }

    /**
     * Method to remove current semester.
     *
     * @param semester semester to remove
     * @param subject  subject to remove
     */
    public void removeSemester(int semester, String subject) {
        semesterSubjectMark.computeIfAbsent(semester, (k) -> new Marks())
                .getSubjectMark().remove(subject);
    }

    /**
     * Method to calculate a Grade Point Average of diploma.
     *
     * @return GPA value
     */
    public float gpa() {
        float gpa = 0;
        int count = 0;
        for (var semester : semesterSubjectMark.entrySet()) {
            Marks marks = semester.getValue();
            for (var subject : marks.getSubjectMark().entrySet()) {
                count++;
                gpa += subject.getValue();
            }
        }
        return gpa / count;
    }

    /**
     * Method to calculate a Grade Point Average of diploma for current semester.
     *
     * @param numberOfSemester number of semester
     * @return GPA value for current semester
     */
    public float gpa(int numberOfSemester) {
        float gpa = 0;
        int count = 0;
        for (var semester : semesterSubjectMark.entrySet()) {
            if (semester.getKey() == numberOfSemester) {
                Marks marks = semester.getValue();
                for (var subject : marks.getSubjectMark().entrySet()) {
                    count++;
                    gpa += subject.getValue();
                }
            }
        }
        return gpa / count;
    }

    /**
     * Method to find out, if there is a chance to get Red Diploma for student.
     *
     * @return true if there is a chance, false if there is no chance
     */
    public Boolean redDiploma() {
        if (diplomaWork < 5) {
            return false;
        }

        for (var semester : semesterSubjectMark.entrySet()) {
            if (semester.getKey() % 2 == 0 &&
                    semester.getValue().getSubjectMark()
                            .values().stream().anyMatch(s -> s < 4)) {
                return false;
            }
        }

        return (gpa(8) > 4.75);
    }

    /**
     * Method to find out, if there is a chance to get a scholarship for student.
     *
     * @param numberOfSemester number of semester
     * @return true if there is a chance to get scholarship, false if there is no chance
     */
    public boolean scholarship(int numberOfSemester) {
        Marks marks = semesterSubjectMark.get(numberOfSemester);
        for (var subject : marks.getSubjectMark().entrySet()) {
            if (subject.getValue() < 4) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RecordBook that = (RecordBook) o;
        return diplomaWork == that.diplomaWork &&
                Objects.equals(semesterSubjectMark,
                        that.semesterSubjectMark);
    }

    @Override
    public int hashCode() {
        return Objects.hash(diplomaWork, semesterSubjectMark);
    }
}
