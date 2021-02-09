package in.rohaan;

import java.util.Scanner;

public class FactorialUsingMethod {
    static class MethodFactorial {
        int fact = 1;
        void factorial(int n) {
            for (int i = 1; i <= n; i++) {
                fact = fact * i;
            }
            System.out.println("The factorial of your number is " + fact);
        }
    }

    public static void main(String[] args) {
        Scanner v = new Scanner(System.in);
        System.out.println("enter your number");
        int s = v.nextInt();
        MethodFactorial obj = new MethodFactorial();
        obj.factorial(s);
    }
}
