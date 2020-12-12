package in.rohaan;

import java.util.Arrays;
import java.util.List;

/*
 * Code for https://stackoverflow.com/questions/65246780
 */ 
public class CommaSeparatedStringsToArray {
    public static void main(String[] args) {
        List<String> input = Arrays.asList("aron, IA52, 20", "john, IA61, 23", "kleo, IA32, 42");
        String[][] array = new String[3][3];
        int row = 0;

        // Loop Over Comma Separated List and split each string to populate 2D array
        for (String commaSeparatedStr : input) {
            String[] parts = commaSeparatedStr.split(",");
            System.arraycopy(parts, 0, array[row], 0, parts.length);
            row++;
        }

        // Print array
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++)
                System.out.print(array[i][j]);
            System.out.println();
        }
    }

}
