#include<stdio.h>

/*
              1
           1  2  1
        1  2  3  2  1
     1  2  3  4  3  2  1
  1  2  3  4  5  4  3  2  1
* Code for https://stackoverflow.com/questions/68268740/
*/  

void addSpaces(int N, int currentIndex, int padding) {
  for (int index = currentIndex; index < N; index++)
      for (int spaces = 0; spaces < padding; spaces++)
         printf(" ");
}

int main()
{
  int n ;
  printf("Input the number of rows: ");
  scanf("%d", &n);

  for(int i = 1; i <= n ; i++)
    {
      addSpaces(n, i, 3);
      for(int j = 1 ; j <= i ; j++)
        {
          if(j == i + 1)
            {
              break;
            }

          printf("%3d", j);
    
        }
      for(int  j = i - 1 ; j > 0; j--)
        {
          if(j == 0)
            {
              break;
            }
          printf("%3d", j);
        }
      printf("\n");
            
    }
}

