package Controller;

import Model.Logs;
import Model.User;
import View.Dialog;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

    

public class Secure {
    public Main main;
    public static Dialog DialogBox = new Dialog();
    public Helper helper = new Helper();
    private final int maxLoginAttempts = 10;
    DateTimeFormatter datetimeformatter = DateTimeFormatter.ofPattern(Logs.datetimeformatstring);
            
    public static boolean regIsEmpty(String username, String password, String confpass) {
        if(username.isEmpty() || password.isEmpty() || confpass.isEmpty()) {
            DialogBox.showErrorDialog("Registration error", "One of the fields is empty. Please try again.");
            return true;
        }
        else
            return false;
                
    }
    public static boolean  validUsername (String checkUsername) {
        // Check for length
        String username = checkUsername.trim();
        if(username.length() < 5 || username.length() > 15 || username.contains(" ")) {
            DialogBox.showErrorDialog("Registration error", "Username should not be less than 5 characters, more than 15 characters long, or contain spaces.");
            return false;
        }
        else
            return true;
    }
    
    public static boolean isValidPassword (String password) {
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
                    System.out.println("Password must have atleast one special character.");
                    isValid = false;
            }
            return isValid;
    }
    
    public static String getPassCriteria () {
        String criteria = "Consider the following when creating passwords: \n\n" 
                                  + "1.) Password must be more than 8 characters in length.\n"
                                  + "2.) Password must have atleast one uppercase character.\n"
                                  + "3.) Password must have atleast one lowercase character.\n"
                                  + "4.) Password must have atleast one number.\n"
                                  + "5.) Password must have atleast one special character.\n";
        return criteria;
    }
    // Checks a user 
    public void checkUserStatus(User user) {
        if (user != null) {
            int isLocked = user.getLocked();
            if (isLocked == 1) {
                
                checkIfUnlock(user);
            } else if (isLocked == 0) {
                checkIfResetFailedCounter(user);
            }
        } else {
            System.out.println("User does not exist");
        }
    }
    
    // Check if 15 minutes has passed to unlock account
    public void checkIfUnlock(User user) {
        // 15 minutes
        long timeToResetLocked = (long) 900000;
        String currTimestamp = helper.getCurrentTimestamp();
        String lastFailedStr = user.getLastFailed();
        
        if (currTimestamp != null && lastFailedStr != null) {
            Date currDateTime = helper.convertStringToDate(currTimestamp);
            Date lastFailed = helper.convertStringToDate(lastFailedStr);
            long difference = currDateTime.getTime() - lastFailed.getTime();
            long minutes = ((timeToResetLocked - difference)/1000)/60;

            if (difference >= timeToResetLocked) {
                System.out.println("Difference: " + difference);
                unlockUser(user);
            } else {
                 DialogBox.showErrorDialog("Authentication failed", "Account currently locked. Please try again in " + minutes +" minutes.");
            }
        }
    }
    
    // Check if 10 minutes has passed to unlock account
    public void checkIfResetFailedCounter(User user) {
        // 10 minutes
        long timeToResetFailedAttempts = (long) 600000;

        String currTimestamp = helper.getCurrentTimestamp();
        String lastFailedStr = user.getLastFailed();
        if(currTimestamp != null && lastFailedStr != null) {
            Date currDateTime = helper.convertStringToDate(currTimestamp);
            Date lastFailed = helper.convertStringToDate(lastFailedStr);
            long difference = currDateTime.getTime() - lastFailed.getTime();
            

            if (difference >= timeToResetFailedAttempts) {
                System.out.println("Difference: " + difference);
                unlockUser(user);
            } 
        }
       
    }
    
    public void unlockUser(User user) {
        user.setLocked(0);
        user.setFailedAttempts(0);
        user.setLastFailed(null);
        String uname = user.getUsername();
        switch (uname) {
                  case "admin":
                      user.setRole(5);
                      break;
                  case "manager":
                      user.setRole(4);
                      break;
                  case "staff":
                      user.setRole(3);
                      break;
                  default:
                      user.setRole(2);
                      break;
              }
    }
    
    
    public void recordFailAttempt(User user) {
        // If user exists
        if (user != null) {
            int failedAttempts = user.getFailedAttempts();
            
            // Create date
            String ts = helper.getCurrentTimestamp();
            
            // Increment failed attempts
            failedAttempts++;
            
            if (failedAttempts >= getMaxLoginAttempts()) {
                System.out.println("You have reached amount of login attempts. Try again later.");
                user.setLocked(1);
                user.setRole(1);
            } 
            System.out.println("attempts: " + failedAttempts);
            user.setFailedAttempts(failedAttempts);
            // Update timestamp
            user.setLastFailed(ts);
        }
    }
    
    public int getMaxLoginAttempts() {
        return this.maxLoginAttempts; 
    }
    
    
    public boolean checkIfValidPurchase(String input) {
        boolean result = false;
        String intValues = "^[1-9]\\d*$";
        
        if(input.matches(intValues))
            result = true;
        return result;
    }
    
}
