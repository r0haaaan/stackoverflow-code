#include <stdio.h>
#include <string.h>

void printStars(int numStar) {
    for (int i = 0; i < numStar; i++)
        printf("*");
}

void printVowelResult(char ch, int occurences) {
    printf("%c:", ch);
    printStars(occurences);
    printf("\n");
}

int main() {
    char input[100];
    // Input
    fgets(input, 100, stdin);
    input[strlen(input) - 1] = '\0';

    // Array of vowel occurences
    int occurences[5];
    memset(occurences, 0, 5);

    // Iterate over input string to count vowels
    int inputLen = strlen(input);
    for (int i = 0; i < inputLen; i++) {
        switch (input[i]) {
            case 'a':
              occurences[0]++;
              break;
            case 'e':
              occurences[1]++;
              break;
            case 'i':
              occurences[2]++;
              break;
            case 'o':
              occurences[3]++;
              break;
            case 'u':
              occurences[4]++;
              break;
        }
    }

    // Print result
    printVowelResult('a', occurences[0]);
    printVowelResult('e', occurences[1]);
    printVowelResult('i', occurences[2]);
    printVowelResult('o', occurences[3]);
    printVowelResult('u', occurences[4]);
    return 0;
}
