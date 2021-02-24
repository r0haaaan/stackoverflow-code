#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void trimTrailingNewline(char input[]) {
    input[strcspn(input, "\n")] = 0;    
}

/*
 * Code for https://stackoverflow.com/questions/66345063/
 */ 
int main() {
    FILE *fp;
    fp = fopen("log.txt", "w+");
    if(fp == NULL)
    {
        printf("Could not open file 31");
        exit(0);
    }

    char domainNames[3][20] = {"www.google.com\n", "www.yahoo.com\n", "www.xyz.com"}; 
    char timestamps[3][20] = {"feb17202101", "feb17202102", "feb17202103"};

    for (int i = 0; i < 3; i++) {
        trimTrailingNewline(domainNames[i]);
        trimTrailingNewline(timestamps[i]);
        fprintf(fp,"%s %s\n", domainNames[i], timestamps[i]);
    }
}
