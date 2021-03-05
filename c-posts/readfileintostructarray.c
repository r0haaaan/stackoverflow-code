#include <stdio.h>
#include <stdlib.h>

void readFile(FILE* pf);
struct University
{
    char name[30];
    int quantityOfStudents;
    int quantityOfFaculties;
    int quantityOfDepartments;
};

/*
 * Code for https://stackoverflow.com/questions/66479056
 */ 
int main()
{
    FILE* pf = fopen("info.txt", "rb");

    readFile(pf);
    return 1;
}

void readFile(FILE* pf)
{
    if ((pf == NULL)) { printf("Error!"); exit(1); }

    struct University *u = (struct University *)malloc(4 * sizeof(struct University));

    for (int i = 0; i < 4; i++)
    {
        fscanf(pf, "%s %d %d %d", &u[i].name, &u[i].quantityOfStudents, &u[i].quantityOfFaculties, &u[i].quantityOfDepartments);
    }

    for (int i = 0; i < 4; i++) {
        printf("%s %d %d %d\n", u[i].name, u[i].quantityOfStudents, u[i].quantityOfFaculties, u[i].quantityOfDepartments);
    }
}
