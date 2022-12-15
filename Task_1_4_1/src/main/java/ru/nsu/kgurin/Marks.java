package ru.nsu.kgurin;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Handle class for wrapping a map: Subject, Mark.
 */
public class Marks {

    private final Map<String, Integer> subjectMark = new HashMap<>();

    /**
     * Handle function to get a map: Subject, Mark.
     *
     * @return map: Subject, Mark
     */
    public Map<String, Integer> getSubjectMark() {
        return subjectMark;
    }
}
