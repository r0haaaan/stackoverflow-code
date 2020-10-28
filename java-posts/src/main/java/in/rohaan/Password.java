package in.rohaan;

import java.util.Scanner;

public class Password {

    public static void main(String[] args) {
        String username = "JohnPaul";
        int password = 11062223;
        int passwordInput = 0;
        System.out.println("PLEASE INSERT YOUR CARD TO LOGIN");
        System.out.println("Username : ");
        Scanner scan = new Scanner (System.in);
        String usernameInput = scan.nextLine();
        
        if(usernameInput.equals(username) ) {
            System.out.println("Password : ");
            passwordInput = scan.nextInt();
            scan.nextLine();
        }
        else {
            System.out.println("User not found.");
        }
        
        if((passwordInput == password) && usernameInput.equals(username)) {
            System.out.println("Log in Success");
        }
        else {
            System.out.println("Incorrect Password");
        }
        
        
    }

}