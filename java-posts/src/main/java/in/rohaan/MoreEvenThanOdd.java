package in.rohaan;

import java.util.Arrays;

/*
 * Code for https://stackoverflow.com/questions/66125521
 */
public class MoreEvenThanOdd {
    public static void main(String[] args) {
        int[] array = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 14};
        int[] array1 = new int[] {11, 22, 33, 44, 55, 66, 77, 79, 81, 83, 84};

        System.out.println("ContainsMoreEvenThanOdd : " + containsMoreEvenThanOdd(array));
        System.out.println("ContainsMoreEvenThanOdd : " + containsMoreEvenThanOdd(array1));
    }

    public static boolean containsMoreEvenThanOdd(int[] array) {
        long nEven = Arrays.stream(array).filter(i -> i%2 == 0).count();
        long nOdd = Arrays.stream(array).filter(i -> i%2 != 0).count();

        return nEven > nOdd;
    }
}
