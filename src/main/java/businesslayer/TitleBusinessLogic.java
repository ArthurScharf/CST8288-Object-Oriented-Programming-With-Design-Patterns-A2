/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package businesslayer;

import dataaccesslayer.TitlesDA;
import java.sql.SQLException;
import java.util.ArrayList;
import transferableobjects.TitleTO;

/**
 *
 * @author User
 */
public class TitleBusinessLogic 
{
    /**
     * @return List of all Author Objects in the database
     * @throws SQLException 
     * 
     * @note For the sake of separation of concerns, this code is left here. In a real
     *       software project, it could be valuable to have this function here to do 
     *       more than just return the array. For now though, it's an exercise
     */
    public static ArrayList<TitleTO> getAll() throws SQLException
    {
        return TitlesDA.INSTANCE.getAll();
    }
    
    
    /**
     * 
     * @param isbn
     * @return TitleTO corresponding to title entity found. Null if record can't be found or doens't exist
     */
    public static TitleTO get(String isbn)
    {
       try {
           return TitlesDA.INSTANCE.get(isbn);
       } catch (SQLException e)
       {
           // TODO: Logger.log(...);
           e.printStackTrace();
           return null;
       }
    }
    
    public static ArrayList<TitleTO> create(TitleTO dto) throws SQLException
    {
        return TitlesDA.INSTANCE.create(dto);
    }
    
    
    public static ArrayList<TitleTO> update(TitleTO dto)
    {
        try {
            return TitlesDA.INSTANCE.update(dto);
        } catch (SQLException e)
        {
            return new ArrayList<>();
        }
    }
    
    
    public static ArrayList<TitleTO> delete(String isbn)
    {
        try {
            return TitlesDA.INSTANCE.delete(isbn);
        } catch (SQLException e)
        {
            return new ArrayList();
        }
    }    
}
