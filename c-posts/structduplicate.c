#include <stdio.h>
#include <stdbool.h>
#include "simplemap.h" // <- Naive implementation of SimpleMap

typedef struct{
  int row;
  int col;
  int val;
}tup;

int main() {
    int MAX_SIZE = 4;
    // Given Input
    int TUPLE_LIST_SIZE = 6;
    tup t1 = {0, 0, 10};
    tup t2 = {0, 1, 20};
    tup t3 = {1, 0, 30};
    tup t4 = {1, 1, 40};
    tup t5 = {0, 0, 10};
    tup t6 = {0, 1, 20};
    tup tupList[6] = {t1, t2, t3, t4, t5, t6};

    // Initializing SimpleMap
    SimpleMap map[MAX_SIZE];
    simplemap_initialize(map, MAX_SIZE);
    // Iterating via tuple list and putting values in map
    for (int i = 0; i < TUPLE_LIST_SIZE; i++) {
        tup currentTuple = tupList[i];
        Key k = {currentTuple.row, currentTuple.col};
        simplemap_put(map, MAX_SIZE, k, currentTuple.val); 
    }

    // Printing values of map
    for (int i = 0; i < MAX_SIZE; i++) {
        printf("(%d, %d) : %d\n", map[i].k.row, map[i].k.col, map[i].value);
    }
    return 0;
}
