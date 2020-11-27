#include <stdio.h>
#include <stdlib.h>

struct LLNode
{
    char name;
    struct LLNode *left;
    struct LLNode *right;
};

struct LLNode * createNode (char data)
{
    struct LLNode *temp; temp = (struct LLNode *)malloc(sizeof(struct LLNode));
    temp->name = data;
    temp->left = NULL;
    temp->right = NULL;
    return(temp);
};

/*
 * Code for https://stackoverflow.com/questions/64917831
 */
int main() {
    struct LLNode *curr=NULL;
    struct LLNode *head = curr;
    struct LLNode *prev = NULL;

    // Insert first Element
    head = curr = createNode ('A') ;
    printf ("curr->name = %c\n", curr->name) ;

    // Insert Second Element
    curr->right = createNode('B');
    printf ("curr->right->name = %c\n", curr->right->name) ;

    prev = curr;
    curr = curr->right;
    printf ( "curr = %c\n" , curr->name) ;

    // Insert Third Element
    curr->right = createNode('C');
    curr->left = prev;
    printf("curr->right->name = %c\n",curr->right->name);

    prev = curr;
    curr = curr->right;
    curr->left = prev;
    printf("curr->name= %c\n",curr->name);

    printf ("\nLinked list from head to tail: ");
    while (1) {
        // Print nodes from beginning to end.
        printf("%c ", head->name);
        if (head->right == NULL)
            break;
        head = head->right;
    }

    printf ("\nLinked list in reverse: ");
    while (1) {
        // Print nodes from beginning to end.
        printf("%c ", head->name);
        if (head->left == NULL)
            break;
        head = head->left;
    }

    return 0;
}
