#include <stdio.h>
#include <stdlib.h>

typedef char stackitem;

struct stack {
    stackitem  d;
    struct stack *next;
};

typedef  struct stack ELEMENT;
typedef  ELEMENT   *POINTER;

POINTER createNewStackNode(stackitem i) {
    POINTER newNode = (POINTER) malloc(sizeof(ELEMENT));
    newNode->d = i;
    newNode->next = NULL;
    return newNode;
}

void print_stack(POINTER Top) {
    POINTER temp = Top;

    printf("Start printing the stack ...\n");

    while (temp != NULL){
        printf("%c\n",temp->d);
        temp = temp->next;
        //pop(&temp);
    }
}

void pop(POINTER *Top) {
    POINTER Top1 = *Top;
    if (Top != NULL)
    {
        *Top = Top1->next;
        // printf("Remove element %c\n", Top1->d);
        free(Top1);
    }
    else
        printf("Empty stack.\n");
}

void push(POINTER *top, char item) {
    POINTER curr = createNewStackNode(item);
    curr->next = *top;
    *top = curr;
}

/*
 * Answer for https://stackoverflow.com/questions/66559345
 */ 
int main() {
    POINTER top;
    top= (POINTER) NULL;
    stackitem A='A';
    stackitem B='B';
    push(&top,A);
    push(&top,B);
    print_stack(top); // prints B A 
    push(&top, 'C');
    push(&top, 'D');
    push(&top, 'E');
    push(&top, 'F');
    print_stack(top);
}

