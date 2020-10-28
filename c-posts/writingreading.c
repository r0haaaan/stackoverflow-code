#include <stdio.h>

int main(void) {
    int i=0;
    float xe;
    float x[8],y[8];
    float fx = 1 / (1 + 25*xe*xe);
    FILE *fptr = NULL;
    FILE *fread;
    fptr = fopen("pointinterpol.dat","w");
    xe = -1;
    while( i++ < 8 ) {
        fprintf(fptr,"%.3f  %.3f\n",xe,1/(1+25*xe*xe));
        xe += 0.25;
    }
    fclose(fptr);
    i=0;
    fread = fopen("pointinterpol.dat","r");
    while(fscanf(fread,"%f %f",&x[i],&y[i]) == 2) {
        i++;
    }
    i=0;
    while( i < 8 ) {
        printf("\nx[%d] = %.2f *** y[%d] = %.2f\n",i,x[i],i,y[i]);
        i++;
    }
    fclose(fread);
    return 0;
}
