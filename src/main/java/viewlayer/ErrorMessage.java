/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewlayer;

/**
 *
 * @author Arthur Scharf
 * @description A custom enum class for controlling the types of error messages that are returned by 
 *              ErrorView. 
 */
public enum ErrorMessage 
{
    EM_BAD_CREDENTIALS, // Invalid login credentials
    EM_BAD_PATH, // Bad path was requested from server
    EM_BAD_INFO, // Incorrect/Incomplete/Illegal form data was sent to server
}
