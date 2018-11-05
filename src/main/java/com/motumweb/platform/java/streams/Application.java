package com.motumweb.platform.java.streams;

import com.motumweb.platform.java.streams.dto.Student;
import com.motumweb.platform.java.streams.util.StudentsGenerator;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Jesus Sanchez
 */
public class Application {

    private static final int MAX_STUDENTS_LIST_1 = 12;
    private static final int MAX_STUDENTS_LIST_2 = 10;

    public static void main(String[] args) {
        //Get the first students list (some students are modified or deleted)
        List<Student> students1 = StudentsGenerator.getStudents(MAX_STUDENTS_LIST_1, true, true);

        //Gest the second students list (clean list)
        List<Student> students2 = StudentsGenerator.getStudents(MAX_STUDENTS_LIST_2, false, false);

        System.out.println("Student list....");
        System.out.println("Student list 1");
        students1.forEach(s -> System.out.println(s));
        System.out.println("Student list 2");
        students2.forEach(s -> System.out.println(s));

        //Get the new students
        List<Student> newStudents = students1.stream().filter(s1 -> {
            return !students2.contains(s1);
        }).collect(Collectors.toList());

        //Get the modified
        List<Student> updateStudents = students1.stream().filter(s1 -> {
            int index = students2.indexOf(s1);
            if (index == -1) {
                return false;
            }
            return !students2.get(index).toString().equals(s1.toString());
        }).collect(Collectors.toList());

        List<Student> deleteStudents = students2.stream().filter(s2 -> {
            return !students1.contains(s2);
        }).collect(Collectors.toList());

        System.out.println("New students");
        newStudents.forEach(s -> System.out.println(s));

        System.out.println("Students changed");
        updateStudents.forEach(s -> System.out.println(s));

        System.out.println("Students deleted");
        deleteStudents.forEach(s -> System.out.println(s));
    }

}
