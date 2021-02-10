package in.rohaan;

/*
 * Code for https://stackoverflow.com/questions/66010913/
 */
public class NextSumIterativeAndRecursive {
    public static void main(String[] args) {
        System.out.println("Recursive:");
        printResult(-1, calculateRecursively(-1));
        printResult(0, calculateRecursively(0));
        printResult(1, calculateRecursively(1));
        printResult(2, calculateRecursively(2));
        printResult(3, calculateRecursively(3));
        printResult(4, calculateRecursively(4));
        printResult(5, calculateRecursively(5));
        printResult(6, calculateRecursively(6));

        System.out.println("Iterative:");
        printResult(-1, calculateIteratively(-1));
        printResult(0, calculateIteratively(0));
        printResult(1, calculateIteratively(1));
        printResult(2, calculateIteratively(2));
        printResult(3, calculateIteratively(3));
        printResult(4, calculateIteratively(4));
        printResult(5, calculateIteratively(5));
        printResult(6, calculateIteratively(6));
    }

    public static int calculateRecursively(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }

        return calculateRecursively(n-1) + calculateRecursively(n-3);
    }

    private static int calculateIteratively(int n) {
        if (n <= 0) {
            return 0;
        }

        int size = n >= 3 ? n + 1 : 3;
        int[] values = new int[size];
        values[0] = 0;
        values[1] = 1;
        values[2] = 2;
        if (n >= 3) {
            for (int i = 3; i < n+1; i++) {
                values[i] = values[i-1] + values[i-3];
            }
        }
        return values[n];
    }

    private static void printResult(int n, int result) {
        System.out.printf("%d %d (n(%d) = n(%d) + n(%d))\n", n, result, n, n-1, n-3);
    }
}
