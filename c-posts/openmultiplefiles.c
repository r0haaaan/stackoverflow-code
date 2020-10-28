#include <stdio.h>
#include <string.h>
#include <stdbool.h>

bool searchInFile(FILE *pFile, char *str) {
  char temp[512];
  bool bFound = false;
  
  while (fgets(temp, 512, pFile) != NULL) {
    if (strstr(temp, str) != NULL) {
      bFound = true;
      break;
    }
  }
  return bFound;
}

int main() {
char fileNames[3][10] = { "file1.txt", "file2.txt", "file3.txt"};
char searchStr[] = "StackOverflow";

for (int i = 0; i < 3; i++) {
  FILE *pFile = fopen(fileNames[i], "r");
  bool bExists = searchInFile(pFile, searchStr);
  if (bExists) {
    printf("%s contains %s\n", fileNames[i], searchStr);
  }
  fclose(pFile);
}
}
