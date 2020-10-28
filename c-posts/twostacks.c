#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

bool isOperator(char op) {
    return op == '+' ||
           op == '-' ||
           op == '*' ||
           op == '/' ||
           op == '(' ||
           op == ')';
}

bool isDigit(char op) {
    return op >= '0' && op <= '9';
}

char operatorStack[100];
int operatorStackIndex;
int operandStack[100];
int operandStackIndex;

long convertStringToLong(char* pStart, char** pEnd, int base) {
    long num = 0;
    while (isDigit(*pStart)) {
        num = num * base + (*pStart - '0');
        pStart++;
    }
    *pEnd = pStart;
    return num;
}

int main() {
    char input[30] = "99+(88-77)*(66/(55-44)+33)";
    // Initialize Stack Indices
    operandStackIndex = 0;
    operatorStackIndex = 0;

    // Our markers for strtol()
    char *pStart = input;
    char *pEnd;
    long ret;

    while ((ret = convertStringToLong(pStart, &pEnd, 10)) > 0) {
        operandStack[operandStackIndex++] = ret;
        pStart = pEnd;
        while (isOperator(*pStart)) { // Check whether character it '+','-','/','(',')','*'..
          operatorStack[operatorStackIndex++] = *pStart;
          pStart++;
        }
    }

    printf("Operand Stack:\n");
    for (int i = operandStackIndex - 1; i >= 0; i--) 
        printf("%d\n", operandStack[i]);

    printf("Operator Stack:\n");
    for (int i = operatorStackIndex - 1; i >= 0; i--)
        printf("%c\n", operatorStack[i]);
}
