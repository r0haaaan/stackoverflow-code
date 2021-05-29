package in.rohaan;

import java.util.HashSet;
import java.util.Set;

/**
 * Code for https://stackoverflow.com/questions/67617176
 */
public class CountingDifferentChars {

    public static int noOfLetters(String str) {
        Set<Character> distinctChars = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            boolean isUpperCaseChar = str.charAt(i) >= 'A' && str.charAt(i) <= 'Z';
            boolean isLowerCaseChar = str.charAt(i) >= 'a' && str.charAt(i) <= 'z';
            if (isUpperCaseChar || isLowerCaseChar) {
                char convertedLowerCaseChar = str.charAt(i);
                if (isUpperCaseChar) {
                    convertedLowerCaseChar = (char) (str.charAt(i) - 'A' + 'a');
                }
                distinctChars.add(convertedLowerCaseChar);
            }
        }

        return distinctChars.size();
    }

    public static void main(String[] args) {
        System.out.println(noOfLetters("rohankumar"));
        System.out.println(noOfLetters("rohankumarROHAN"));
        System.out.println(noOfLetters("rohankumarROHAN-$"));
        System.out.println(noOfLetters("cd$aD"));
    }
}
