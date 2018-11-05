package com.motumweb.platform.java.streams.util;

import com.motumweb.platform.java.streams.dto.Student;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jesus Sanchez
 */
public class StudentsGenerator {

    public static List<Student> getStudents(int aproxCount, boolean delete, boolean update) {
        if (aproxCount < 10) {
            aproxCount = 10;
        }
        List<Student> students = new ArrayList<>();
        Student student;

        //create n students
        for (int id = 1; id <= aproxCount; id++) {
            student = new Student();
            student.setStudentId(id);
            student.setFirstName("First name " + id);
            student.setLastName("Last name " + id);
            student.setCity("City " + id);
            student.setAddress("Address " + id);
            student.setPhoneNumber("12345678" + id);
            students.add(student);
        }

        //Delete some random indexes
        if (delete) {
            int countDelete = getRandomIntegerBetweenRange(1, 5);
            while (countDelete != 0) {
                int indexDelete = getRandomIntegerBetweenRange(0, students.size() - 1);
                students.remove(indexDelete);
                countDelete--;
            }
        }

        //update some random indexes
        if (update) {
            int countUpdate = getRandomIntegerBetweenRange(1, 5);
            while (countUpdate != 0) {
                int indexUpdate = getRandomIntegerBetweenRange(0, students.size() - 1);
                student = students.get(indexUpdate);
                student.setFirstName(student.getFirstName() + " x");
                student.setLastName(student.getFirstName() + " x");
                countUpdate--;
            }
        }

        return students;
    }

    //https://dzone.com/articles/random-number-generation-in-java
    private static int getRandomIntegerBetweenRange(int min, int max) {
        return ((int) (Math.random() * ((max - min) + 1)) + min);
    }
}
