#include <stdio.h>
#include <string.h>
#include <stdlib.h>

#define MAX_ARRAY_SIZE 5

typedef struct Book
{
    char BookName[50];
    int BookISBN;
    int Borrowed;
    char BorrowerName[50];
    char Field[50];
}Book;

Book book[MAX_ARRAY_SIZE];

int ReadFile(char* fileName);

/*
 * StackOverflow Post: https://stackoverflow.com/questions/65089483
 */ 
int main(int argc, char* argv[])
{
    char* fileName = "c1.txt";

    int nDocs = ReadFile(fileName);

    for (int i = 0; i < nDocs; i++)
    {
        printf("Book Name is : %s\n", book[i].BookName);
        printf("Book ISBN is : %d\n", book[i].BookISBN);
        printf("Borrowed is : %d\n", book[i].Borrowed);
        printf("Borrower Name is : %s\n", book[i].BorrowerName);
        printf("Field is : %s\n", book[i].Field);
        printf("\n");
    }
    exit(EXIT_SUCCESS);
}

int ReadFile(char* fileName)
{
    FILE* filePtr = NULL;
    int  i = 0;

    if ((filePtr = fopen(fileName, "r")) == NULL)
    {
        printf("Error : Unable to open %s for reading\n");
        exit(EXIT_FAILURE);
    }

    char input[100];
    char *result;
    while ((result = fgets(input, 100, filePtr)) != NULL) {
        // Book Name
        input[strlen(input) - 1] = '\0'; // Trim trailing \n
        strcpy(book[i].BookName, input);
        // Book ISBN
        result = fgets(input, 100, filePtr);
        if (result == NULL) break;
        sscanf(input, "%d", &book[i].BookISBN);
        // Book Borrowed
        result = fgets(input, 100, filePtr);
        if (result == NULL) break;
        sscanf(input, "%d", &book[i].Borrowed);
        // Book Borrower Name
        result = fgets(input, 100, filePtr);
        input[strlen(input) - 1] = '\0'; // Trim trailing \n
        if (result == NULL) break;
        strcpy(book[i].BorrowerName, input);
        // Book Field
        result = fgets(input, 100, filePtr);
        input[strlen(input) - 1] = '\0'; // Trim trailing \n
        if (result == NULL) break;
        strcpy(book[i].Field, input);

        i++;
    }

    fclose(filePtr);
    return i;
} 
