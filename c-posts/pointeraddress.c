#include <stdio.h>

int multiplyByTen(int* pVar) {
    printf("inside multiplyByTen, pVar: %p\n", pVar);
    printf("inside multiplyByTen, &pVar: %p\n", &pVar);
}


int main() {
    int var1 = 4;
    int* pVar1 = &var1;
    printf("pVar1: %p\n", pVar1);
    printf("&pVar1: %p\n", &pVar1);
    multiplyByTen(pVar1);
}
