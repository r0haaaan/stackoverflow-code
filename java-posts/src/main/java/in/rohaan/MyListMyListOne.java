package in.rohaan;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * Code for https://stackoverflow.com/questions/66203376
 */ 
public class MyListMyListOne {
    public static void main(String[] args) {
        List<String> myList = new ArrayList<>();
        myList.add("aaa 111");
        myList.add("bbb 222");
        myList.add("aaa 333");

        List<String> distincAAA = createDistinctSymbolList(myList);
        distincAAA.forEach(System.out::println);
    }

    private static List<String> createDistinctSymbolList(List<String> myList) {
        List<String> result = new ArrayList<>();
        Set<String> addedSymbols = new HashSet<>();

        for (String s : myList) {
            String currentSymbol = getSymbol(s);
            if (!addedSymbols.contains(currentSymbol)) {
                result.add(s);
            }
            addedSymbols.add(getSymbol(s));
        }
        return result;
    }

    private static String getSymbol(String str) {
        String[] parts = str.split(" ");
        return parts[0];
    }
}
