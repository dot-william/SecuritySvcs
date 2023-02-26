/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import View.Dialog;

/**
 *
 * @author william
 */
public class Secure {

    public Dialog DialogBox = new Dialog();
    
    public boolean regIsEmpty(String username, String password, String confpass) {
        if(username.isEmpty() || password.isEmpty() || confpass.isEmpty()) {
            DialogBox.showErrorDialog("Registration error", "One of the fields is empty. Please try again.");
            return true;
        }
        else
            return false;
                
    }
    public boolean  validUsername (String username) {
        // Check for length
        if(username.length() < 5 || username.length() > 15) {
            DialogBox.showErrorDialog("Registration error", "Username should not be less than 5 characters or more than 15 characters long.");
            return false;
        }
        else
            return true;
    }
    
    public boolean isValidPassword (String password) {
        boolean isValid = true;
            if (password.length() < 8)
            {
                    System.out.println("Password must be less than 20 and more than 8 characters in length.");
                    isValid = false;
            }
            String upperCaseChars = "(.*[A-Z].*)";
            if (!password.matches(upperCaseChars ))
            {
                    System.out.println("Password must have atleast one uppercase character");
                    isValid = false;
            }
            String lowerCaseChars = "(.*[a-z].*)";
            if (!password.matches(lowerCaseChars ))
            {
                    System.out.println("Password must have atleast one lowercase character");
                    isValid = false;
            }
            String numbers = "(.*[0-9].*)";
            if (!password.matches(numbers ))
            {
                    System.out.println("Password must have atleast one number");
                    isValid = false;
            }
            String specialChars = "(.*[-._!\"`'#%&,:;<>=@{}~\\$\\(\\)\\*\\+\\/\\\\\\?\\[\\]\\^\\|].*$)";
            if (!password.matches(specialChars ))
            {
                    System.out.println("Password must have atleast one special character among @#$%");
                    isValid = false;
            }
            
            if (!isValid) {
                String message = "Invalid password. Consider the following when createing passwords: \n\n" 
                                  + "1.) Password must be more than 8 characters in length.\n"
                                  + "2.) Password must have atleast one uppercase character.\n"
                                  + "3.) Password must have atleast one lowercase character.\n"
                                  + "4.) Password must have atleast one number.\n"
                                  + "5.) Password must have atleast one special character.\n";
                DialogBox.showErrorDialog("Registration error", message);
            }
            return isValid;
    }
//    public boolean validPassword (String password) {
//    
//    }
    
}
