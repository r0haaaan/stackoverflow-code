#include <stdio.h>

/*
 * Code for https://stackoverflow.com/questions/67601916
 */ 
int main()
{
    char Operator;

    int num1, num2, result, nReadScanf;
    char input[100], *ret;


    printf("Enter first and second value: ");
    if (fgets(input, 100, stdin) == NULL) {
        printf("No input provided!\n");
        return -1;
    }
    if (sscanf(input, "%d %d", &num1, &num2) != 2) {
        printf("Error in reading characters\n");
        return -1;
    }

    printf("Enter operator: ");
    if (fgets(input, 100, stdin) == NULL) {
        printf("No input provided!\n");
        return -1;
    }
    if (sscanf(input, "%c", &Operator) != 1) {
        printf("Error in reading characters\n");
        return -1;
    }

    if(Operator == '+')
    {
        result = num1 + num2;
        printf("%d\n", result);
    }
    else if(Operator == '-')
    {
        result = num1 - num2;
        printf("%d\n", result);
    }

    return 0;
}

