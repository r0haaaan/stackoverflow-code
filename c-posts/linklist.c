#include <stdlib.h>
#include <stdio.h>

typedef struct s_list t_list;
struct s_list {
    int arg;
    t_list *next;
};


int add(t_list **ref, int arg) {
    t_list *temp;
    temp = NULL;
    if(!(temp = (t_list*)malloc(sizeof(t_list))))
        return (0);
    temp->arg = arg;
    temp->next = (*ref);
    (*ref) = temp;
    return(1);
}

void print(t_list *list) {
    printf("&list inside print: %p\n", &list); // -> Address of print pointer variable

    while(list) {
        printf("arg: %i\n",list->arg);
        list = list->next;
    }
}

int main() {
    t_list *list;
    list = NULL;
    add(&list, 0);
    add(&list, 1);
    add(&list, 2);
    printf("&list: %p\n", &list); // -> Address of main pointer variable
    print(list); // work fine 
    printf("%p\n", list);
    print(list); // work fine it's possible te read a second time but why ?
    printf("%p\n", list);
  
    // that's way don't work a second time
    while(list) {
        printf("arg: %i\n",list->arg);
        list = list->next;
    }

    while(list) {
        printf("arg: %i\n",list->arg);
        list = list->next;
    }

    return (0);
}
