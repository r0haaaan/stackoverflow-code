package in.rohaan;

import java.util.Arrays;

/**
 * Code for https://stackoverflow.com/questions/64906854
 */
public class TwoDimensionalArraySort {
    public static void main(String[] args) {
        String a[][] = new String[3][4];
        a[0][0] = "John";a[0][1] = "Doe"; a[0][2] ="B"; a[0][3] ="999";
        a[1][0] ="Bob";a[1][1] ="Smith";a[1][2] ="Q"; a[1][3] ="420";
        a[2][0] ="Name";a[2][1] ="Here";a[2][2] ="T";a[2][3] ="123";

        Arrays.sort(a, (o1, o2) -> {
            String firstO1Element = o1[0];
            String firstO2Element = o2[0];
            return firstO1Element.compareTo(firstO2Element);
        });

        for (String[] strings : a) {
            for (String string : strings) {
                System.out.print(string + " ");
            }
            System.out.println();
        }
    }
}
