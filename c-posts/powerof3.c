#include <stdio.h>

/*
 * Code for https://stackoverflow.com/questions/66851559
 */ 
int main ()
{
    int product = 3;

    while ( product <= 100 )
    {
        printf ("%d\n" , product);
        product = 3 * product;
    }
}
