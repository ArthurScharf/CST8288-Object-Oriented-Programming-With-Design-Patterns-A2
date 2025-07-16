/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package businesslayer;

import java.sql.SQLException;

import java.util.ArrayList;

import dataaccesslayer.AuthorDA;
import transferableobjects.AuthorTO;


/**
 *
 * @author Arthur Scharf
 * @description business logic layer. While this application is small, I felt it was
 *              still important to exercise separation of concerns.
 *              This class is the business logic intermediary between the servlets,
 *              and the database. 
 * 
 *              At the time of writing, I feel this class is unnecessary. The code
 *              reads as extra abstraction without adding anything. Bc of the 
 *              assignment instructions, I've left it in
 */
public class AuthorBusinessLogic 
{
    /**
     * @return List of all Author Objects in the database
     * @throws SQLException 
     * 
     * @note For the sake of separation of concerns, this code is left here. In a real
     *       software project, it could be valuable to have this function here to do 
     *       more than just return the array. For now though, it's an exercise
     */
    public static ArrayList<AuthorTO> getAll() throws SQLException
    {
        return AuthorDA.INSTANCE.getAll();
    }
    
    public static AuthorTO get(int id)
    {
       try {
           return AuthorDA.INSTANCE.get(id);
       } catch (SQLException e)
       {
           // TODO: Logger.log(...);
           e.printStackTrace();
           return null;
       }
    }
    
    public static ArrayList<AuthorTO> create(AuthorTO dto)
    {
        try {
            return AuthorDA.INSTANCE.create(dto);
        } catch (SQLException e)
        {
            return new ArrayList<>();
        }
    }
    
    
    public static ArrayList<AuthorTO> update(AuthorTO dto)
    {
        try {
            return AuthorDA.INSTANCE.update(dto);
        } catch (SQLException e)
        {
            return new ArrayList<>();
        }
    }
    
    
    public static ArrayList<AuthorTO> delete(int id)
    {
        try {
            return AuthorDA.INSTANCE.delete(id);
        } catch (SQLException e)
        {
            return new ArrayList();
        }
    }
}
