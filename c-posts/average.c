#include <stdio.h>

// Code for https://stackoverflow.com/questions/65170153

/*
 * Takes an array and get input for N items specified 
 */ 
void getUserInputForArray(int array[], int N) {
    printf("insert %d numbers\n", N);

    for (int i = 0; i < N; ++i) {
        printf("insert digit no %d: ", i + 1);
        scanf("%d", &array[i]);
    }
}

/*
 * Calculate average for a given array of size N
 */ 
float getAverage(int array[], int N) {
    // Initialize sum to 0
    float sum = 0.0f;
    // Iterate through array adding values to sum
    for (int i = 0; i < N; i++)
        sum += array[i];

    // Calculate average 
    return sum / N;
}

int main() {
    int n = 10, array1[10];
    // Pass array to method, since arrays in C are passed by pointers.
    // So Even if you modify it in method it would get reflected in 
    // main's array1 too
    getUserInputForArray(array1, n);

    // Calculate Average by delegating average calculation to getAverage(...) method
    float average = getAverage(array1, n);

    printf("average = %.2f", average);
    return 0;
}
