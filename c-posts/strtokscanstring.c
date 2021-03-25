#include <stdio.h>
#include <string.h>

/*
 * Code for https://stackoverflow.com/questions/66800535
 */ 
int main() {
    char input[100];
    const char delimiter[2] = " ";
    fgets(input, 100, stdin);
    input[strcspn(input, "\n")] = 0;

    char first[100];
    char args[100][100];
    int nArgs = 0;

    char *token = strtok(input, delimiter);
    strcpy(first, token);

    while (token != NULL) {
        token = strtok(NULL, delimiter);
        if (token != NULL) {
            strcpy(args[nArgs], token);
            nArgs++;
        }
    }
    printf("first: %s\n", first);
    printf("nArgs: %d\n", nArgs);
    for (int i = 0; i < nArgs; i++) {
        printf("arg[%d] = %s\n", i, args[i]);
    }
}
