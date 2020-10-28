package in.rohaan;

import java.util.Arrays;

public class ArraysToMethod {
    public static void main(String[] args) {
        int[] inputArr = {1, 2, 4, 5, 6, 56, 33, 5, 64, 0, 0, 22, 44};
        int[] result = getEvenElementsArray(inputArr);
        System.out.println(Arrays.toString(result));
    }

    private static int[] getEvenElementsArray(int[] inputArr) {
        // 1. Count number of Even Elements
        int nEvens = getNumberOfEvenElements(inputArr);
        // 2. Create result array with size = number of even elements
        int[] resultArr = new int[nEvens];

        // 3. Iterate over input array to copy even values
        //    to result array
        int resultIndex = 0;
        for (int j : inputArr) {
            // 4. Check fields which are even and not zero
            if (isEvenAndNotZero(j)) {
                resultArr[resultIndex] = j;
                resultIndex++;
            }
        }
        return resultArr;
    }

    private static int getNumberOfEvenElements(final int[] inputArr) {
        return (int) Arrays.stream(inputArr)
                .filter(ArraysToMethod::isEvenAndNotZero)
                .count();
    }

    private static boolean isEvenAndNotZero(int num) {
        return (num != 0) && (num % 2 == 0);
    }
}
