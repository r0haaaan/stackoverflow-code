#include <stdio.h>
#include <stdlib.h>
#include <malloc.h>
#include <string.h>

/*
 * Code for https://stackoverflow.com/questions/67758860/
 */ 
//my variables
typedef struct
{
    char fName[100];
    char lName[100];
    double salary;
} employee;

// list of employees
typedef struct list
{
    employee e;
    struct list *next;
} list;

list* createNewNode(char firstName[], char lastName[], double salary) {
    list* newNode = (list *) malloc(sizeof(list));
    if (newNode == NULL) {
        printf("Node Memory allocation failed\n");
        return NULL;
    }

    strcpy(newNode->e.fName, firstName);
    strcpy(newNode->e.lName, lastName);
    newNode->e.salary = salary;
    newNode->next = NULL;
}

list* load_list(FILE *f)
{
    list *head = NULL, *prevNode = NULL;
    char firstName[100], lastName[100];
    double salary;

    while (fscanf(f, "%10s%10s%lf", firstName, lastName, &salary) == 3) {
        list *currentNode = createNewNode(firstName, lastName, salary);
        if (currentNode == NULL) {
            printf("memory allocation failed\n");
            break;
        }

        if (head == NULL) {
            head = currentNode;
            prevNode = currentNode;
        } else {
            prevNode->next = currentNode;
            prevNode = currentNode;
        }
    }
    return head;
}

void display(list *node)
{
    while (node != NULL)
    {
        printf("%s | %s | %.2lf\n", node->e.fName, node->e.lName, node->e.salary);
        node = node->next;
    }
}

void freeList(list *head)
{
    list *tmp;

    while (head != NULL)
    {
        tmp = head;
        head = head->next;
        free(tmp);
    }
}

int main()
{
    FILE *file = fopen("file.txt", "r");

    list* listhead = load_list(file);
    display(listhead);
    freeList(listhead);
    fclose(file);
    return 0;
}
