#include <stdio.h>
#define INDI 3
#define INDJ 4

int main ()
{
   int a [INDI] [INDJ] = {
     {1, 8, 11, 3},
     {9, 5, 0, 7},
     {5, 10, 4, 6},
   };
   int n;
   int i;
   int yoko;
   int tate;
   int result;
   int count = 0;;
   /* Add variabledeclaration as needed */

   printf ("Enter a number:");
   scanf ("%d", &n);

   for (tate = 0; tate <3; tate ++) {
     for (yoko = 0; yoko <4; yoko ++) {
       if (n == a [tate] [yoko]) {
     count ++;
     printf ("a [%d] [%d] is %d \n", tate, yoko, n);
     printf ("There were %d occurences of %d in the element of 2D array a \n", count, n);
       }


     }}


   if (count == 0) {
   printf ("There is no %d in the element of 2D array a \n", n);
   }





   return 0;

}
