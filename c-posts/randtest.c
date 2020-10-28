#include <stdio.h>
#include <stdlib.h>
int main(){
    int n;
    int arrayName[5];
    for(int i= 0;i < 5; i++ ){
      arrayName[i] = rand();
      printf("array[%d] = %d\n",i,arrayName[i]);
    }
    return 0;
}
