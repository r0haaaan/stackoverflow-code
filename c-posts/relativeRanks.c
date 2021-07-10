#include <stdio.h>
#include <stdlib.h>
#include <string.h>

/*
 * Code for https://stackoverflow.com/questions/68328826/
 */ 
typedef struct ValueToIndexPair {
    int value;
    int index;
} ValueToIndexPair;

int cmpfunc (const void * a, const void * b) {
   const ValueToIndexPair* i1 = (ValueToIndexPair*) a;
   const ValueToIndexPair* i2 = (ValueToIndexPair*) b; 

   return (i2->value - i1->value );
}

char *createRankString(int rank) {
  char firstRankStr[12] = "Gold Medal";
  char secondRankStr[13] = "Silver Medal";
  char thirdRankStr[15] = "Bronze Medal";

  char *rankStr;
  if (rank == 0) {
      rankStr = malloc(12 * sizeof(char));
      strcpy(rankStr, firstRankStr);
  } else if (rank == 1) {
      rankStr = malloc(13 * sizeof(char));
      strcpy(rankStr, secondRankStr);
  } else if (rank == 2) {
      rankStr = malloc(15 * sizeof(char));
      strcpy(rankStr, thirdRankStr);
  } else {
      rankStr = malloc(6 * sizeof(char));
      sprintf(rankStr, "%d", rank + 1);
  }
  return rankStr;
}

char **findRelativeRanks(int* score, int scoreSize, int* returnSize) {
  char **ranks = malloc(scoreSize * sizeof(char*));
  *returnSize = scoreSize;
  ValueToIndexPair scoreToIndexList[scoreSize];  
  for (int i = 0; i < scoreSize; i++) {
      scoreToIndexList[i].value = score[i];
      scoreToIndexList[i].index = i;
  }

  qsort(scoreToIndexList, scoreSize, sizeof(ValueToIndexPair), cmpfunc);
  
  for (int i = 0; i < scoreSize; i++) {
      char *rankStr = createRankString(i);
      int currentScoreOrignalIndex = scoreToIndexList[i].index;
      ranks[currentScoreOrignalIndex] = rankStr;
  }

  return ranks;
}


void test(int t[], int sz) {
    printf("[");
    for (int i = 0; i < sz; i++) 
        printf("%d, ", t[i]);
    printf("]\n");    

    int returnSize;
    char** result = findRelativeRanks(t, sz, &returnSize);
    for (int i = 0; i < returnSize; i++) {
        printf("%s, ", result[i]); 
    }
    printf("]\n");
}

int main() {
    int t1[] = {5, 4, 3, 2, 1};
    int t2[] = {10, 3, 8, 9, 4};

    test(t1, 5);
    test(t2, 5);
}

