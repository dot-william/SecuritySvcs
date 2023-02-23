/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

/**
 *
 * @author william
 */
public class Secure {
//    public boolean validPassword(String password) {
//    
//    }
//  
    public boolean regIsEmpty(String username, String password, String confpass) {
        if(username.isEmpty() || password.isEmpty() || confpass.isEmpty())
            return true;
        else
            return false;
                
    }
    public boolean  validUsername (String username) {
        // Check for length
        if(username.length() < 5 || username.length() > 15)
            return false;
        else
            return true;
    }
    
//    public boolean validPassword (String password) {
//    
//    }
}
