#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

typedef struct Employee {
    int id;
    char name[100];
    char surname[100];
} Employee;

typedef struct Node {
    Employee employee;
    struct Node *next;
} Node;

void printList(Node *head);
void reorderBasedOnFrequency(Node *head); 
void swap(struct Node *a, struct Node *b); 

int main() {
    Employee employees[6] = { {47, "Max", "Clark"}, {37, "Amy", "Jhinar"}, {89, "Bob", "Davis"}, {25, "Jackson", "Adams"},
      {29, "Jackie", "Kitcher"},{27, "Karen", "Robinson"}};

    Node *head = NULL;
    Node *tail = NULL;
    for (int i = 0; i < 6; i++) {
        Node *newNode = (Node *)malloc(sizeof(Node));
        newNode->employee = employees[i];
        newNode->next = NULL;
        if (i == 0) {
            head = newNode;
            tail = newNode;
        } else {
            tail->next = newNode;
            tail = newNode;
        }
    }

    printf("Initial List: \n");
    printList(head);
    reorderBasedOnFrequency(head);
    printf("After Sorting: \n");
    printList(head);
}

void reorderBasedOnFrequency(Node *head) {
    int frequencyMap[10] = { 0 };
    
    // Build array of frequencies for id mod 10`
    Node *currentNode = head;
    while (currentNode != NULL) {
        frequencyMap[currentNode->employee.id % 10]++;
        currentNode = currentNode->next;
    }

    // Perform Standard Bubble Sort
    bool swapped = true;
    Node *ptr1;
    Node *lptr = NULL;

    do {
        swapped = false;
        ptr1 = head;

        while (ptr1->next != lptr) {
            // Check for frequencies while sorting
            if (frequencyMap[(ptr1)->employee.id % 10] < frequencyMap[(ptr1->next)->employee.id % 10]) {
                // Swap
                swap(ptr1, ptr1->next);
                swapped = true;
            }
            ptr1 = ptr1->next;
        }
        lptr = ptr1;
    } while (swapped);
}

void printList(Node *head) {
    while (head != NULL) {
        printf("%d %s %s ", head->employee.id, head->employee.name, head->employee.surname);
        head = head->next;
        if (head != NULL)
            printf(" => ");
    }
    printf("\n");
}

void swap(struct Node *a, struct Node *b) { 
    Employee temp = a->employee; 
    a->employee = b->employee; 
    b->employee = temp; 
} 
