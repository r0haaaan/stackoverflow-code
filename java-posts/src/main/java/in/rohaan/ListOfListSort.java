package in.rohaan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListOfListSort {
    public static void main(String[] args) {
        List<String> l1 = new ArrayList<>(Arrays.asList("Foo", "B", "Bar"));
        List<String> l2 = new ArrayList<>(Arrays.asList("Foooo", "C", "Baaar"));
        List<String> l3 = new ArrayList<>(Arrays.asList("Fooooooo", "A", "Baaaaar"));


        List<List<String>> listOfList = new ArrayList<>(Arrays.asList(l1, l2, l3));

        listOfList.sort((o1, o2) -> {
            String o1SecondElement = o1.get(1);
            String o2SecondElement = o2.get(1);

            return o1SecondElement.compareTo(o2SecondElement);
        });

        for (List<String> list : listOfList) {
            for (String item : list) {
                System.out.print(item + "  ");
            }
            System.out.println();
        }
    }
}
