package in.rohaan;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class LeastFrequentDigitInArray {
    public static void main(String[] args) {
        int input1[] = new int[] {134,12634,124,5667};
        int input2[] = new int[] {11, 21, 31, 22};

        System.out.println(getLeastFrequentDigit(input1));
        System.out.println(getLeastFrequentDigit(input2));

    }

private static int getLeastFrequentDigit(int[] array) {
    Map<Integer, Integer> digitFrequencyMap = new HashMap<>();

    for (int j : array) {
        int key = j % 10;
        digitFrequencyMap.merge(key, 1, Integer::sum);
    }

    Map.Entry<Integer, Integer> minEntry = digitFrequencyMap.entrySet().stream()
            .min(Comparator.comparingInt(Map.Entry::getValue))
            .orElse(null);
    return minEntry != null ? minEntry.getKey() : -1;
}
}
