#include<stdio.h>
#include<string.h>
#define MAX 100 
#define product_limit 50

typedef struct {
        int p_id;
        char p_name[product_limit + 1];
        int p_quantity; 
        int unit_price; 
        char type_product[50]; 
} product;

int display_products();
int change_product(); 
int display_menu();
int add_product(); 
int product_exists(int id);

int main() 
 { 
        int ok = 1, menu;
        do 
            {
            menu = display_menu();
            if(menu < 1 || menu > 7) 
             {
            printf("Invaid option.\n");
             } 
            else 
                 {
           switch(menu)
                 {
            case 1:
            add_product();
            break;
            case 2:
            change_product();
            break;
            case 3:
            display_products();
            break;
        }
        }
        } 
        while(ok);
        printf("Exiting Program.\n");
        return 0;
}
int display_menu()
 {
        int menu;
        printf("Choose option from below.\n");
        printf("1. Add new product.\n");
        printf("2. Update product.\n");
        printf("3. Display products.\n");
        printf(". Exit.\n");
        scanf("%d", &menu);
        return menu;
}
product products[MAX];
int c_p = 0;
int product_exists(int id)
 {
        int x;
        for(x=0;x<c_p;x++) 
    {
        if(products[x].p_id == id) 
    {
        return x;
    }
    }
        return -1; 
}
int add_product() 
{
        int price,id,quantity,type;
        char name[product_limit + 1];
        printf("Product ID: ");
        scanf("%d", &id);
        if(product_exists(id) != -1) 
        {
            printf("ID: %d already exists.\n", id);
            return -1;
        }
        printf("Enter Product Name: ");
        scanf("%s", name);
        printf("Enter Quantity: ");
        scanf("%d", &quantity);
        printf("Enter Price: ");
        scanf("%d", &price);
        printf("Enter Product Type:");
        scanf("%s",type);
        products[c_p].p_id = id;
        strcpy(products[c_p].p_name, name);
        products[c_p].p_quantity = quantity;

        products[c_p].unit_price = price;
        c_p++;
        printf("Product added Successfully\n");
        return c_p;
}
int change_product() 
{
        int id, exists;
        char z[2];
        char newName[product_limit + 1];

        printf("Product ID: ");
        scanf("%d", &id);
        exists = change_product(id);
        if(exists == -1) {
        printf("ID: %d not exists.\n", id);
        printf("Type Y to try once more or N back to menu: ");
        scanf("%s", z);
        if(strcmp(z, "Y") == 0) 
        {
        change_product();
        }
        } else {
            printf("Product found successfully\n");
            printf("Product Name: %s\n", products[exists].p_name);
            printf("Type new name: ");
            scanf("%s", newName);
            //strcat(products[exists].p_name, newName);
            strcpy(products[exists].p_name, newName);
            printf("Successfully updated.\n");
        }
}

int display_products() 
{
        int x;
        if(c_p == 0) 
      {
            printf("No products were added\n");
            return 0;
      }
        printf("Products\n\n");
        for(x = 0; x < c_p; x++) 
      {
        printf("Product ID: %d\n", products[x].p_id);
        printf("Product Name: %s\n", products[x].p_name);
        printf("Quantity: %d\n", products[x].p_quantity);
        printf("Product price: %d\n", products[x].unit_price);
        printf("Product type:%s\n",products[x].p_name);
        printf("\n");
        break;
      }
      return x;
}

