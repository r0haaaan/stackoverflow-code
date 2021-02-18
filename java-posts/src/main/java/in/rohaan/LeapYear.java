package in.rohaan;

import java.util.Scanner;

/*
 * Code for https://stackoverflow.com/questions/66245827
 */
public class LeapYear {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a year");
        int year = scanner.nextInt();
        System.out.println(isLeapYear(year));
    }

    public static boolean isLeapYear(int year) {
        return java.time.Year.of(year).isLeap();
    }
}