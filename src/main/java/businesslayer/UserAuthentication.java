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
     */
    public static boolean authenticateUser(String username, String password)
    {
        // logger.warning("\n\n\n" + username + " " + password + "\n\n\n");
        return username.equals("cst8288") && password.equals("cst8288");
    }
}
