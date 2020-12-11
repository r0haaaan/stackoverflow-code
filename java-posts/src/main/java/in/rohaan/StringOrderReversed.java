package in.rohaan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringOrderReversed {
public static void main(String[] args) {
System.out.println(rightShiftEachWordInSentence("abc defg xyz"));
System.out.println(rightShiftEachWordInSentence("This is the way"));
System.out.println(rightShiftEachWordInSentence("May the Force be with you"));
}

private static String rightShiftEachWordInSentence(String input) {
    String[] words = input.split(" ");
    List<String> rightShiftedWordsList = new ArrayList<>();
    Arrays.stream(words)
            .forEach(s -> rightShiftedWordsList.add(rightShiftWord(s)));

    return String.join(" ", rightShiftedWordsList);
}

private static String rightShiftWord(String word) {
    StringBuilder stringBuilder = new StringBuilder();

    stringBuilder.append(word.charAt(word.length() - 1));
    for (int i = 0; i < word.length() - 1; i++) {
        stringBuilder.append(word.charAt(i));
    }
    return stringBuilder.toString();
}
}
