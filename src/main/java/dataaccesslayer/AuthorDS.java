/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dataaccesslayer;

import java.io.InputStream;
import java.io.IOException;

import java.sql.Connection;
import java.util.Properties;
import java.sql.DriverManager;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLException;

/**
 * @author User
 */
public enum AuthorDS 
{
    // SINGLETON Pattern. Threadsafe
    INSTANCE;
    
    
    public Connection connection;
    
    private String[] info;
    
    
    private AuthorDS() throws ExceptionInInitializerError
    {
        info = new String[3];
        try {
            openPropertyFile(info);
            connection = DriverManager.getConnection(info[0], info[1], info[2]);
        } catch (SQLException e) {
            throw new ExceptionInInitializerError("Critical failure establishing database connection: " + e.getMessage());
        } catch (IOException e) {
            throw new ExceptionInInitializerError("Critical failure opening `property` file: " + e.getMessage());
        }
    }
    
    
    /* This code was heavily inspired by the code from the lectures */
    private static void openPropertyFile(String[] info) throws IOException
    {
        Properties properties = new Properties();
        
        try (InputStream in = Files.newInputStream(Paths.get("src/main/java/database.properties")))
        {
            properties.load(in);
        } catch (IOException e)
        {
            throw e;
        }
        
        String url = properties.getProperty("jdbc.url");
        String username = properties.getProperty("jdbc.username");
        String password = properties.getProperty("jdbc.password");
        
        info[0] = url;
        info[1] = username;
        info[2] = password;
    }
}
