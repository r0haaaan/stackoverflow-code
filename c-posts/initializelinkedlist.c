#include "stdio.h"
#include "stdlib.h"


struct ListNode
{
    int val;
    struct ListNode *next;
};

int main()
{
    int a[] = {1, 2, 3};
    struct ListNode *head = malloc(sizeof(struct ListNode));
    head->next = NULL;
    struct ListNode *rear = head;
for (int i = 0; i < 3; i++) {
    struct ListNode *s = malloc(sizeof(struct ListNode));
    s->val = a[i];
    s->next = rear->next;
    rear->next = s;
    rear = s;
}
    struct ListNode *tmp = head;
    head = head->next;
    free(tmp);


    //display
    while (head != NULL)
    {
        printf("%d ",(*head).val);
        head = head->next;
    }

    return 0;
}
