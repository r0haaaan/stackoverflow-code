#include<stdio.h>
#include<stdlib.h>

/*
 * Code for https://stackoverflow.com/questions/66257152/
 */ 
int main()
{
    char info[100];
    FILE *ptr;
    int n;
    int count1 =0; //count for even
    int count2= 0; //count for odd
    int count3=0; //count for prime
    int flag=0;
    char line[10];
    ptr=fopen("trial.txt","r");
    while(fscanf(ptr, "%d", &n) != EOF)
    {
        printf("%d\n", n);
        if(n%2==0)
        count1++;
        else
        count2++;
        
        if(n>1)
        {
            for(int i=2;i<n/2;i++)
            {
                if(n%i==0)
                flag=1;                
            }
            if(flag==0)
                count3++;                       
        }
        flag=0;
    }
    fclose(ptr);
    printf("this file has %d even %d odd and %d prime numbers",count1,count2,count3);
    return 0;
}
