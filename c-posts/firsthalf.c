#include <stdio.h>
#include <math.h>

int getLength(int n);

int main() {
    int num = 130592;
    int numLen = getLength(130592);
    int result = num/pow(10, numLen/2);
    printf("%d\n", result);
}

int getLength(int n) {
    int len = 0;
    do {
        n = n/10;
        len++;
    } while (n > 0);
    return len;
}
