package in.rohaan;

import java.util.Arrays;
import java.util.Scanner;

public class Code7 {
    public static void main(String[] args) {
        Process nu = new Process();
        nu.e();
    }
}

class Process {
    Scanner in = new Scanner(System.in);
    int choice1 = 0;
    int limit1;
    int[] array;

    public void m() {
        System.out.println("                   ARRAY OPERATION");
        System.out.println("                        menu");
        System.out.println("                 [1] Create Array");
        System.out.println("                 [2] Insert Element");
        System.out.println("                 [3] Search");
        System.out.println("                 [4] Display");
        System.out.println("                 [5] Delete");
        System.out.println("                 [0] Stop");
        System.out.print("                 Enter choice:");
    }

    public void e() {
        do {
            m();
            choice1 = in.nextInt();

            cls();
            if (choice1 > 0) {
                processChoice();
            }
        } while (choice1 > 0);
    }

    private void processChoice() {
        switch (choice1) {
            case 1:
                if (array == null) {
                    System.out.println("Create Array");
                    System.out.println("Enter the limit of your array: ");
                    limit1 = in.nextInt();


                    if (limit1 < 5) {
                        System.out.println("Error: Minimum limit exceeded");
                        System.out.println("Going back to main menu");
                        System.out.println("Press Any Key To Continue...");
                        new Scanner(System.in).nextLine();
                        System.out.print('\u000C');
                    } else if (limit1 > 20) {
                        System.out.println("Error: Maximum limit exceeded");
                        System.out.println("Going back to main menu");
                        System.out.println("Press Any Key To Continue...");
                        new Scanner(System.in).nextLine();
                        System.out.print('\u000C');
                    } else if (limit1 >= 5 || limit1 <= 20) {
                        System.out.println("An array with a limit of " + limit1 + " has been created");
                        array = new int[limit1];
                        System.out.println("Press Any Key To Continue...");
                        new Scanner(System.in).nextLine();
                        System.out.print('\u000C');
                    }
                } else {
                    System.out.println("Error: Array Already Created");
                    System.out.println("Press Any Key To Continue...");
                    new Scanner(System.in).nextLine();
                    System.out.print('\u000C');
                }
                break;

            case 2:
                System.out.println("Enter the " + array.length + " numbers now. Or enter -1 to exit");
                int i = 0;
                while (i < array.length) {
                    int currentInput = in.nextInt();
                    boolean dups = false;
                    if (array[i] != -1) {
                        for (int k = 0; k < i; k++)
                            if (array[k] == currentInput) {
                                System.out.println("Error: Duplicate Element");
                                System.out.println("Please Enter Another Value");
                                dups = true;
                                break;
                            }
                        if (!dups) {
                            array[i] = currentInput;
                            i++;
                        }
                    } else {
                        array[i] = 0;
                        System.out.println("Exit Confirmed");
                        System.out.println("Press Any Key To Continue...");
                        new Scanner(System.in).nextLine();
                        System.out.print('\u000C');
                        break;
                    }
                }
                System.out.println("You have entered the " + limit1 + " numbers");
                System.out.println("Press Any Key To Continue...");
                new Scanner(System.in).nextLine();
                System.out.print('\u000C');
                break;

            case 3:
                int x, flag = 0, index = 0;
                if (limit1 < 5 || limit1 > 20) {
                    System.out.println("Error: Invalid Array Limit");
                    System.out.println("Press Any Key To Continue...");
                    new Scanner(System.in).nextLine();
                    System.out.print('\u000C');
                } else {
                    System.out.print("Enter the element you want to find:");
                    x = in.nextInt();
                    for (index = 0; index < array.length; index++) {
                        if (array[index] == x) {
                            flag = 1;
                            break;
                        } else {
                            flag = 0;
                        }
                    }
                    if (flag == 1) {
                        System.out.println("Element found at position:" + (index + 1));
                    } else {
                        System.out.println("Element not found");
                    }
                    System.out.println("Press Any Key To Continue...");
                    new Scanner(System.in).nextLine();
                    System.out.print('\u000C');
                }
                break;


            case 4:
                if (limit1 < 5 || limit1 > 20) {
                    System.out.println("Error: Invalid Array Limit");
                    System.out.println("Press Any Key To Continue...");
                    new Scanner(System.in).nextLine();
                    System.out.print('\u000C');
                } else {
                    for (int indexArr = 0; indexArr < array.length; indexArr++) {
                        if (indexArr % 5 == 0) {
                            System.out.println(" ");
                        }
                        System.out.print(array[indexArr] + "\t");
                    }
                    System.out.println("");
                    System.out.println("Press Any Key To Continue...");
                    new Scanner(System.in).nextLine();
                    System.out.print('\u000C');

                }
                break;

            case 5:
                System.out.println("Error: You are deleting beyond the array limit");
                System.out.println("Press Any Key To Continue...");
                new Scanner(System.in).nextLine();
                System.out.print('\u000C');
                System.out.println("Original Array: " + Arrays.toString(array));
                System.out.println("Enter the index number to be removed: ");
                int deletionIndex = in.nextInt();
                if (deletionIndex == -1)
                    break;

                array = removeTheElement(array, deletionIndex);
                limit1--;
                System.out.println("Resultant Array: "
                        + Arrays.toString(array));
                System.out.println("Press Any Key To Continue...");
                new Scanner(System.in).nextLine();
                System.out.print('\u000C');
                break;

            default:
                System.out.println("Invalid Input provided.. Please try again");
        }
    }

    public static int[] removeTheElement(int[] arr,
                                         int index) {

        // If the array is empty
        // or the index is not in array range
        // return the original array
        if (arr == null
                || index < 0
                || index >= arr.length) {

            return arr;
        }

        // Create another array of size one less
        int[] anotherArray = new int[arr.length - 1];

        // Copy the elements except the index
        // from original array to the other array
        for (int i = 0, k = 0; i < arr.length; i++) {

            // if the index is
            // the removal element index
            if (i == index) {
                continue;
            }

            // if the index is not
            // the removal element index
            anotherArray[k++] = arr[i];
        }

        // return the resultant array
        return anotherArray;
    }

    private void cls() { //clear screen method
        System.out.print('\u000C');
    }
}