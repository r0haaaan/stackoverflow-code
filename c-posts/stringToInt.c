#include <stdio.h>

// Code for https://stackoverflow.com/questions/65266334
int ReturnInt(char str[]) {
  int i;
  int result;

  i = 0;
  result = 0;
  while (str[i] != '\0' && (str[i] >= '0' && str[i] <= '9'))
    {
      int currentDigit = str[i] - '0';
      result = result * 10 + currentDigit;
      i++;
    }

  return (result);
}

int main() {
    char *input1 = "99Hello";
    char *input2 = "123ab4c";
    printf("%d\n", ReturnInt(input1));
    printf("%d\n", ReturnInt(input2));
}
