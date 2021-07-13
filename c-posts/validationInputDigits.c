#include <stdio.h>
#include <stdlib.h> 
#include <ctype.h>
#include <stdbool.h>
#include <string.h>
/* 
 * Code for https://stackoverflow.com/questions/68357754
 */ 
bool validate(char name[]) {
    int len = strlen(name);
    for (int i = 0; i < len; i++) {
        if (isalpha(name[i]) == 0)
            return false;
    }
    return true;
}

int main()
{
char name[100];
bool isValid;
do {
   printf("\nFull Name: ");
   fgets(name, 100, stdin);
   name[strcspn(name, "\n")] = 0;
   
   isValid = validate(name);
   if (!isValid) {
       printf("\nPlease enter your Full Name correctly!");
   } else {
       printf("Good\n");
   }
} while (!isValid);
   printf("NEXT\n");
   return 0;
}
