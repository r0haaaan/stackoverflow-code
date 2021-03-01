package in.rohaan;

/*
 * Code for https://stackoverflow.com/questions/66416930
 */ 
public class SelectionSortTest {
    public static void main(String[] args) {
        int[] arr = new int[] { 1, 10, 2, 20, 3, 30, 4, 50};
        print(arr);
        int nMovements = selectionSort(arr);
        System.out.printf("movements : %d\n", nMovements);
        print(arr);

        System.out.println();
        int[] arrSorted = new int[] {1, 2, 3, 4, 5, 6, 7};
        print(arrSorted);
        int nMovementsSorted = selectionSort(arrSorted);
        System.out.printf("movements : %d\n", nMovementsSorted);
        print(arrSorted);
    }

    public static void print(int[] arr) {
        for (int j : arr) System.out.printf(" %d ", j);
        System.out.println();
    }

    public static int selectionSort(int[] list) {
        int movements = 0;

        for(int i = 0; i < list.length - 1; i++) {
            int currentMin = list[i];
            int currentMinIndex = i;
            for(int j = i + 1; j < list.length; j++) {
                if(currentMin > list[j]) {
                    currentMin = list[j];
                    currentMinIndex = j;
                }
            }
            if(currentMinIndex != i) {
                list[currentMinIndex] = list[i];
                list[i] = currentMin;
                movements++;
            }
        }
        return movements;
    }
}
