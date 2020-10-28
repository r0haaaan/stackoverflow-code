#include <stdio.h>
#include <string.h>

int sumSqDigits1(char input[], int size);

int main()
{
 int num, result;
 char input[100];
 while (1) {
     printf("Enter a number: ");
     // Take whole line as input using fgets()
     fgets(input, 100, stdin);

     // If user presses '\n', terminate program
     if (input[0] == '\n') {
         printf("Exiting...\n");
         break;
     }

     input[strlen(input) - 1] = '\0'; // trim trailing '\n'
     
     printf("sumSqDigits1(): %d\n", sumSqDigits1(input, 100));
 }
}

int sumSqDigits1(char input[], int size) {
    int sum = 0;
    for (int i = 0; input[i] != '\0' && i < size; i++) {
        // Get integer value of digit by subtracting from '0'. Checkout their
        // ASCII values: https://asciichart.com/
        int digitFromChar = input[i] - '0';
        sum += (digitFromChar * digitFromChar);
    }

    return sum;
}
