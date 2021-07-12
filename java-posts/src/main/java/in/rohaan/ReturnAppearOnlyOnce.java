package in.rohaan;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*
 * Code for https://stackoverflow.com/questions/68338704/
 */ 
public class ReturnAppearOnlyOnce {
    public static void main(String[] args) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        int [] arr = {2, 5, 14, 14, 2, 7, 5};

        for (int j : arr)
            frequencyMap.merge(j, 1, Integer::sum);

        for (Map.Entry<Integer, Integer> intToFrequency : frequencyMap.entrySet()) {
            if (intToFrequency.getValue() == 1) {
                list.add(intToFrequency.getKey());
            }
        }
        System.out.println(list);
    }
}
