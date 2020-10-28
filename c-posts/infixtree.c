 #include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>

#define SIZE 200 //The number digit limitation


typedef struct _btnode {
    int item;
    struct _btnode* left;
    struct _btnode* right;
} BTNode;   // You should not change the definition of BTNode



int main()
{
    char prefix[SIZE];
    BTNode* root = NULL;

    //printf("Enter an prefix expression:\n");
    gets(prefix);

    createExpTree(&root, prefix);

    // printf("The Infix Expression:\n");
    printTree(root);
    printf("\n");
 
    return 0;
}



void createExpTree(BTNode** root, char* prefix)
{

    if (*prefix) {

        printf("%c\n", *prefix);
        if (!isdigit(*prefix)) {
            *root = malloc(sizeof(BTNode));
            (*root)->item = *prefix;
            (*root)->left = NULL;
            (*root)->right = NULL;

        }
        else {
            *root = malloc(sizeof(BTNode));
            (*root)->item = *prefix;
            (*root)->left = NULL;
            (*root)->right = NULL;
            return;
        }
    }

    createExpTree(&(*root)->left, ++prefix);
    createExpTree(&(*root)->right, ++prefix);

   

}

void printTree(BTNode* node) {
    
    if (node == NULL)
        return;
    printTree(node->left);
    printf("%c", node->item);
    printTree(node->right);

}
