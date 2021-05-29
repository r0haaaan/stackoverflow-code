#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <math.h>
/*
 * Code for https://stackoverflow.com/questions/67752844/
 */ 

int getRandomDigit() {
    return rand() % 10;
}

void generateCardNumber(char cardNumber[], int size) {
    for (int i = 0; i < size; i++) {
        cardNumber[i] = '0' + getRandomDigit();
    }
    cardNumber[size] = '\0';
}

int main() {
    srand(time(NULL));
    const int size = 16;
    char card1[size + 1], card2[size + 1];

    generateCardNumber(card1, size);
    generateCardNumber(card2, size);

    printf("%s\n", card1);
    printf("%s\n", card2);
}
