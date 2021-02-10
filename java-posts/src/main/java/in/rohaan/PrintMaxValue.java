package in.rohaan;

import java.util.Scanner;

/*
 * Code for https://stackoverflow.com/questions/66137161
 */
public class PrintMaxValue {
    public static void main(String[] args) {
        // your code goes here
        try {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            int max = a[0];

            for (int i = 0; i < n; i++) {
                int sum = a[i];
                while (i + 1 < n && a[i + 1] > a[i]) {
                    sum = sum + a[i + 1];
                    i++;
                }
                if (sum > max) {
                    max = sum;

                }
            }
            System.out.println(max);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
