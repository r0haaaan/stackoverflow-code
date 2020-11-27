#include <stdio.h>
#include <stdlib.h>

/*
 * Code for https://stackoverflow.com/questions/64943438
 */ 
int main() {
    char *value=NULL;
    double Training[401], Test[50];
    int i=0, j=0;
    double newvalue;
    double *a=NULL;
    double val1[10], val2[10], val3[10], val4[10], val5[10];
    size_t line_buf_size = 0;

    FILE *in_file  = fopen("turbine.txt", "r");
    if (in_file == NULL)
    {
        printf("Error! Could not open file\n");
        exit(-1);
    }

    char line[100];
    int nLines = 0;
    while (fgets(line, 100, in_file)) {
        sscanf(line, "%lf%lf%lf%lf%lf", &val1[nLines], &val2[nLines], &val3[nLines], &val4[nLines], &val5[nLines]);
        nLines++;
    }

    for (int i = 0; i < nLines; i++) {
        printf("%lf %lf %lf %lf %lf\n",  val1[i], val2[i], val3[i], val4[i], val5[i]);
    }

    fclose (in_file);
    return 0;
}
