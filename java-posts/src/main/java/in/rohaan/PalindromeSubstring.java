package in.rohaan;

/*
 * Code for https://stackoverflow.com/questions/64898401 
 */ 
public class PalindromeSubstring {
    public static void main(String[] args) {
        System.out.printf("isPalindrome(%s) : %s\n", "j", isPalindrome("j"));
        System.out.printf("isPalindrome(%s) : %s\n", "mom", isPalindrome("mom"));
        System.out.printf("isPalindrome(%s) : %s\n", "madam", isPalindrome("madam"));
        System.out.printf("isPalindrome(%s) : %s\n", "ab1ba", isPalindrome("ab1ba"));
        System.out.printf("isPalindrome(%s) : %s\n", "12321", isPalindrome("12321"));
        System.out.printf("isPalindrome(%s) : %s\n", "123212", isPalindrome("123212"));
        System.out.printf("isPalindrome(%s) : %s\n", "535", isPalindrome("535"));
        System.out.printf("isPalindrome(%s) : %s\n", "454", isPalindrome("454"));
    }

    private static boolean isPalindrome(final String input) {
        int length = input.length();
        int middleIndex = (length % 2 == 0 ) ?
                (length / 2 ) : (length / 2 + 1);
        String left = input.substring(0, length / 2);
        String right = input.substring(middleIndex, length);

        // Compare left string with reverse(right)
        return left.equals(new StringBuilder(right).reverse().toString());
    }
}
