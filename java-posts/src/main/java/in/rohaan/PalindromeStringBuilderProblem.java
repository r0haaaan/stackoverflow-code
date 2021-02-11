package in.rohaan;

import java.util.Scanner;

/*
 * Code for https://stackoverflow.com/questions/66160542
 */ 
public class PalindromeStringBuilderProblem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        StringBuilder reverseWordBuilder = new StringBuilder(input);

        String reversedWord = reverseWordBuilder.reverse().toString();
        if(input.equals(reversedWord)) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }
}
