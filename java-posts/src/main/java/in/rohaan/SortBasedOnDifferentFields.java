package in.rohaan;

import java.util.Arrays;
import java.util.Comparator;

/*
 * Code for https://stackoverflow.com/questions/66169854
 */
public class SortBasedOnDifferentFields {
    private static class StudentGrade {
        String name;
        double grade;

        public StudentGrade(String n, double g) {
            this.name = n;
            this.grade = g;
        }
    }

    public static void main(String[] args){
        StudentGrade[] studentGrades = new StudentGrade[] {
                new StudentGrade("Garcia", 2.5),
                new StudentGrade("Magsilang", 1.25),
                new StudentGrade("Magbag", 1.5)
        };

        // Sort By Name
        System.out.println("(Student Sorted):");
        Arrays.sort(studentGrades, Comparator.comparing(o -> o.name));
        printStudentGrades(studentGrades);

        // Sort by Grade
        System.out.println("(Grade Sorted):");
        Arrays.sort(studentGrades, Comparator.comparing(o -> o.grade));
        printStudentGrades(studentGrades);
    }

    private static void printStudentGrades(StudentGrade[] studentGrades) {
        for (StudentGrade s : studentGrades) {
            System.out.printf("%s %s\n", s.name, s.grade);
        }
    }
}
