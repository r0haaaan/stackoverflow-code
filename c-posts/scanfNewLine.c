#include <stdio.h>

/*
 * Code for https://stackoverflow.com/questions/64853307/c-language-programs-about-input-output-do-not-run-properly/
 */ 
int main(){
    FILE *fptr;
    int n;
    char text[100];
    char input[10];

    fptr=fopen("sample.txt","w");

    printf("Number of line? ");
    //scanf("%d",&n);
    //getchar();
    fgets(input, 10, stdin);
    sscanf(input, "%d", &n);

    for(int i = 1; i <= n; i++){
        printf("Line %d: ", i);
        fgets(text, sizeof(text), stdin);
        fputs(text, fptr);
    }
    fclose(fptr);

    return 0;
}

