/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dataaccesslayer;

import java.sql.SQLException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import java.util.ArrayList;

import transferableobjects.AuthorTO;

/**
 *
 * @author Arthur Scharf
 */
public enum AuthorDA implements DAOInterface
{
    
    // SINGLETON pattern. Threadsafe
    INSTANCE;

    @Override
    public ArrayList<AuthorTO> getAll() throws SQLException 
    {
       String query = "SELECT * FROM authors";
        // This will always exist because of the enum implementation strategy for the connection
        Connection conn = AuthorDS.INSTANCE.connection;
        
        ArrayList<AuthorTO> dtos = new ArrayList<>();
                
        try ( Statement stmt = conn.createStatement(); ResultSet results = stmt.executeQuery(query); )
        {
            // -- Constructing Transfer Objects -- //
            while (results.next()) // Remember that index 0 is ignored. This is why we can do .next() instead of .hasNext()
            {
                AuthorTO dto = new AuthorTO(); 
                dto.setId(results.getInt("id"));
                dto.setFirstName(results.getString("firstName"));
                dto.setLastName(results.getString("lastName"));
                dtos.add(dto);
            }//~ while(results.next())
        } catch (SQLException e) {
            throw new SQLException("Exception when retrieving all authors", e);
        }   
        return dtos;
    }

    @Override
    public AuthorTO create(AuthorTO dto) throws SQLException 
    {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public AuthorTO getByIndex(int index) throws SQLException 
    {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public AuthorTO updateByIndex(int index, AuthorTO dto) throws SQLException 
    {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public AuthorTO deleteByIndex(int index) throws SQLException 
    {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
