#include<stdio.h>
#include<string.h>

int main(){
    char plaintext[50], key[15]; 
    char input[10];
    char encrypt[50];
    int EncryptOp = 1, DecryptOp = 2, choice;

    printf("Enter 1 for Encryption or 2 For Decryption: ");
    fgets(input, 10, stdin);
    sscanf(input, "%d", &choice);
    if(choice ==EncryptOp){
        printf("Enter Plaintext for Encryption: ");
        fgets(plaintext,50,stdin);
        printf("Enter Keyword:");
        scanf("%s", &key);
        printf("Plaintext:%s\n Keyword:%s\n", plaintext, key);
    }else if(choice ==DecryptOp){
        printf("Enter Encrypted Message for Decryption: ");
        scanf("%s", &encrypt);
    }        

    return 0;   
}
