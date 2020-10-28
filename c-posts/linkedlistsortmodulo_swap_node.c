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
void reorderBasedOnFrequency(Node **head); 
Node* swap(struct Node *a, struct Node *b); 

int main() {
  Employee employees[10] = { {47, "Max", "Clark"}, {37, "Amy", "Jhinar"},
                            {89, "Bob", "Davis"}, {25, "Jackson", "Adams"},
                            {29, "Jackie", "Kitcher"},{27, "Karen", "Robinson"},
                            {11, "Rohan", "Kumar"}, {21, "Robert", "Dicosta"},
                            {31, "Jessie", "Wilson"}, {41, "Bill", "Wayne"}};

  Node *head = NULL;
  Node *tail = NULL;
  for (int i = 0; i < 10; i++) {
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
  reorderBasedOnFrequency(&head);
  printf("After Sorting: \n");
  printList(head);
}

void reorderBasedOnFrequency(Node **head) {
  int frequencyMap[10] = { 0 };
    
  // Build array of frequencies for id mod 10`
  Node *currentNode = *head;
  int nCount = 0;
  while (currentNode != NULL) {
    frequencyMap[currentNode->employee.id % 10]++;
    currentNode = currentNode->next;
    nCount++;
  }

  // Perform Standard Bubble Sort
  bool swapped = true;
  Node **h;

  for (int i = 0; i <= nCount && swapped; i++) {
    h = head;
    swapped = false;
    for (int j = 0; j < nCount - i - 1; j++) {
      Node *p1 = *h;
      Node *p2 = p1->next;
      // Check for frequencies while sorting
      if (frequencyMap[p1->employee.id % 10] < frequencyMap[p2->employee.id % 10]) {
        // Swap
        *h = swap(p1, p2);
        swapped = true;
      }

      h = &(*h)->next;
    }
  }
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

Node* swap(struct Node *a, struct Node *b) { 
  Node *tmp = b->next;
  b->next = a;
  a->next = tmp;
  return b;
} 
