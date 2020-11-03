#include <stdio.h>

int M;

void s(int v[], int i)
{
    int j;
    printf("s(v, %d)\n", i);
    if(i>0 && i<M){
        for(j=0;j<i;j++) {
            printf("\tv[%d] +=(%d)\n", i, v[j]);
            v[i]+=v[j];
        }
        s(v,i-1);
    }
}
/*
 * StackOverflow Post: https://stackoverflow.com/questions/64668612
 */ 
int main() {
    M = 10;
    int arr[10] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    s(arr, 9);
    for (int i = 0; i < 10; i++) {
        printf("%d ", arr[i]);
    }
    printf("\n");
}
