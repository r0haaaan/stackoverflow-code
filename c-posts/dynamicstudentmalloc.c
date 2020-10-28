#include <stdio.h>
#include <stdlib.h>

struct students {
    int studentNumber;
    char studentName[50];
    char studentSurname[50];
};

int main() {
    int number_of_elements = 10;
    struct students* studentArr = malloc(number_of_elements * sizeof(struct students));
}
