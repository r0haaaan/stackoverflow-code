package in.rohaan;

import java.util.Scanner;

public class MinMaxNumUpdate {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long currentNum = 0;
        long maxNum=0;
        long minNum=0;
        int count = 0;

        while(sc.hasNextDouble()) {
            System.out.println("Please enter a double number, or 'q' to quit");
            currentNum = sc.nextLong();
            count++;
            if(count ==1) {
                minNum = currentNum;
                maxNum = currentNum;
            }
            else if(count!=1){
    if (currentNum > maxNum) {
        System.out.printf("You are in currentNum(%d) > maxNum(%d)", currentNum, maxNum);
        //currentNum = maxNum;
        maxNum = currentNum;
    }
    else if (currentNum < minNum) {
        System.out.printf("You are in currentNum(%d) < minNum(%d)", currentNum, minNum);
        //currentNum = minNum;
        minNum = currentNum;
    }
            }
        }
        System.out.println("Min num " + minNum);
        System.out.println("Max num " + maxNum);
    }
}
