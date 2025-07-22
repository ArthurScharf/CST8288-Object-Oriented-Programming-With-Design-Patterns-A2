/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package businesslayer;


import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author Arthur Scharf
 * 
 * @description While this class could've just been a single function,
 * I decide to enforce my learning by writing this anyway
 */
public class UserAuthentication 
{
    private static final Logger logger = Logger.getLogger(UserAuthentication.class.getName());
    /**
     * @param username
     * @param password
     * @return true if username and password are legal
     * 
     * This is obviously not how you'd do really authentication. Given this project
     * required only a single valid user, I decided to simulate a login system with
     * this function. I'd normally query the database for credentials like this.
     * Upon finding a valid match, I'd return true, false otherwise
     * 
     * Additionally, I would normally want a UserValidation Class to clean and 
     * check format for input. Again, the limited nature of this project lead
     * me allocate my time to what was in the requirements
     */
    public static boolean authenticateUser(String username, String password)
    {
        // logger.warning("\n\n\n" + username + " " + password + "\n\n\n");
        return username.equals("cst8288") && password.equals("cst8288");
    }
}
