#include <stdio.h>
#include <string.h>
#include <ctype.h>

int main() {
    int tentative=5,i = 0,j;
    char reponce[3];

while (i<=tentative) {
    i++;
    do {
        printf("Are you hungry ?");
        scanf("%3s",reponce);

        printf("%s",reponce);
    } while (!((strcasecmp(reponce, "YES") == 0) || (strcasecmp(reponce, "NOT") == 0)));
}
}
