#include <stdio.h>
#include <string.h>

int main() {
    char infix[10];
    fgets(infix, 10, stdin);
    infix[strlen(infix)-1] = '\0';

    char *pArr = infix;

    while (*pArr != '\0') {
        int temp = (int) (*pArr - '0');
        printf("%d\n", temp);
        pArr++;
    }
}
