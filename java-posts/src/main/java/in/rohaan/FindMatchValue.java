package in.rohaan;

import java.util.Arrays;

/*
 * Code for https://stackoverflow.com/questions/64897444
 */
public class FindMatchValue {
    public static void main(String[] args) {
        int[] input1 = {2, 1, 2, 2};
        int matchValue1 = 2;
        int[] input2 = {0, 0, 0, 0};
        int matchValue2 = 0;
        int[] input3 = {20, 50, 70, 100};
        int matchValue3 = 10;

        System.out.println("matchValue: " + matchValue1 + ", numMatches: " + getNumMatches(input1, matchValue1));
        System.out.println("matchValue: " + matchValue2 + ", numMatches: " + getNumMatches(input2, matchValue2));
        System.out.println("matchValue: " + matchValue3 + ", numMatches: " + getNumMatches(input3, matchValue3));
    }

    private static long getNumMatches(final int[] arr, final int matchValue) {
        return  Arrays.stream(arr)
                .filter(i -> i == matchValue)
                .count();
    }
}
