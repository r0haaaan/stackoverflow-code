#include <stdio.h>
#include <string.h>
#include <stdlib.h>

struct profile {
    char name[30];
    int age, phoneNo;
};

int main()
{
    char search[50];
    char record[50];
struct profile profiles[2];

FILE* fPtr;
if (fPtr = fopen("profile.txt", "r")) {
    int index = 0;
    while (fgets(record, 50, fPtr) != NULL) {
        // Extract name
        char *pStr = strtok(record, ",");
        if (pStr != NULL) {
            strcpy(profiles[index].name, pStr);
        }
        // Extract Age
        pStr = strtok(NULL, ",");
        if (pStr != NULL) {
            profiles[index].age = atoi(pStr);
        }
        // Extract Phone No
        pStr = strtok(NULL, ",");
        if (pStr != NULL) {
            profiles[index].phoneNo = atoi(pStr);
        }
        index++;
    }

    for (int i = 0; i < 2; i++) {
        printf("%s %d %d\n", profiles[i].name, profiles[i].age, profiles[i].phoneNo);
    }
     
    fclose(fPtr);
}
    else
    {
        printf("File cannot be opened\n");
    }
}
