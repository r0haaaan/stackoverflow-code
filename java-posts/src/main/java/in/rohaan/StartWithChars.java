package in.rohaan;

import java.util.regex.Pattern;

/*
 * Code for https://stackoverflow.com/questions/66795486/
 */  
public class StartWithChars {
    public static void main(String[] args) {
        System.out.println("matches(_FooBar) : " + match("_FooBar"));
        System.out.println("matches(1FooBar) : " + match("1FooBar"));
        System.out.println("matches(12FooBar12) : " + match("12FooBar12"));
        System.out.println("matches(aFooBar) : " + match("aFooBar"));
        System.out.println("matches($FooBar) : " + match("$FooBar"));
        System.out.println("matches(-FooBar) : " + match("-FooBar"));
        System.out.println("matches($$$FooBar) : " + match("$$$FooBar"));
        System.out.println("matches(12FooBar) : " + match("12FooBar"));
        System.out.println("matches(12FooBar------) : " + match("12FooBar------"));
        System.out.println("matches($FooBar_) : " + match("$FooBar_"));
    }

    private static boolean match(String input) {
        Pattern p = Pattern.compile("^(\\d|[a-zA-Z$_]).([\\da-zA-Z_])*");
        return p.matcher(input).matches();
    }
}
