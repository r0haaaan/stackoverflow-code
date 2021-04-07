#include <stdio.h>

#define ROWS 4
#define COLUMNS 4

typedef struct Location {
    int row;
    int column;
} Location;

void maxValue(int array[ROWS][COLUMNS]){
    int maxNum = array[0][0];
    // Array of locations to store max locations
    Location maxLocations[ROWS * COLUMNS];
    // Index of max locations array
    int maxLocationIndex = 0;

    // First pass; Get Max value
    for(int c = 0; c < ROWS; c++) {
        for(int d = 0; d < COLUMNS; d++) {
            if(maxNum < array[c][d]) {
                maxNum = array[c][d];
                // Reset Max locations index
                maxLocationIndex = 0;
            }

            if (array[c][d] == maxNum) {
                maxLocations[maxLocationIndex].row = c;
                maxLocations[maxLocationIndex].column = d;
                maxLocationIndex++;
            }
        }
    }

    printf("Largest value in the array is %d\n", maxNum);
    for (int i = 0; i < maxLocationIndex; i++) {
        printf("[%d][%d] \n", maxLocations[i].row, maxLocations[i].column);
    }
}

/*
 * Code for https://stackoverflow.com/questions/66980386
 */ 
int main() {
    int arr[4][4] = { {1, 2, 3}, {2, 3, 4}, {4, 5, 6}, {8, 7, 8}};
    maxValue(arr);

}
