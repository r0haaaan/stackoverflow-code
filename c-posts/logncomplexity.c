#include <stdio.h>
#include <math.h>

double getLog2(double n) {  
    return log(n) / log(2);  
} 

int main() {
    int n = 64;
    int nIterations = 0;
    for (int i = n; i > 0; i /= 2) {
        printf("%d\n", i);
        nIterations++;
    }

    printf("nIterations = %d, getLog2(%d) = %d", nIterations, n, getLog2(n));
}
