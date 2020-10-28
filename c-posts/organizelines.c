#include <stdio.h>
#include <string.h>
#include <stdlib.h>

int main(){
        FILE *pInput;
        FILE *pOutput;
        pInput  = fopen("file.txt","r");
        pOutput = fopen("result.txt","w");
        char fileText[1000];
// Maintains number of Characters written for a heading        
int nHeadingCharsWritten = 0;
while(fgets(fileText,1000,pInput) != NULL) {
    if (strlen(fileText) > 1) { // Ignore empty lines
        if (fileText[0] == '#') { // Case for Heading 
            fputc('\n', pOutput);
            fprintf(pOutput, fileText);
            nHeadingCharsWritten = 0; // reset number of characters for new heading
        } else {
            int nLen = strlen(fileText);
            for (int i = 0; i < nLen - 1; i++) {
                // Go to new line if number of characters written reach multiple of ten
                if (nHeadingCharsWritten > 0 && nHeadingCharsWritten % 10 == 0) {
                    fputc('\n', pOutput);
                }
                // write other characters as usual
                fputc(fileText[i], pOutput);
                nHeadingCharsWritten++;
            }
        }
    }
}

        fclose(pInput);
        fclose(pOutput);
        return 0;
}

