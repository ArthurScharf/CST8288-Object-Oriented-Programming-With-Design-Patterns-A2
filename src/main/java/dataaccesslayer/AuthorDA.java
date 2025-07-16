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
            // -- Constructing  Transfer Objects -- //
            while (results.next()) // Remember that index 0 is ignored. This is why we can do .next() instead of .hasNext()
            {
                AuthorTO dto = new AuthorTO(); 
                dto.setId(results.getInt("AuthorID"));
                dto.setFirstName(results.getString("FirstName"));
                dto.setLastName(results.getString("LastName"));
                dtos.add(dto);
            }//~ while(results.next())
        } catch (SQLException e) {
            throw new SQLException("Exception when retrieving all authors: " + e.getMessage(), e);
        }   
        return dtos;
    }

    @Override
    public ArrayList<AuthorTO> create(AuthorTO dto) throws SQLException 
    {        
        String query = "INSERT INTO authors (FirstName, LastName) VALUES(?, ?);";
        
        Connection connection = AuthorDS.INSTANCE.connection;
        
        try (PreparedStatement stmt = connection.prepareStatement(query))
        {
            stmt.setString(1, dto.getFirstName());
            stmt.setString(2, dto.getLastName());
            
            int affectedRows = stmt.executeUpdate();
            
            
            
            if (affectedRows > 0)
            {
                return getAll();
            }
            else return new ArrayList<>(); // Insert failed
        } catch (SQLException e)
        {
            throw e; // TODO
        }
    }

    @Override
    public AuthorTO get(int id) throws SQLException 
    {
        String query = "SELECT * FROM authors where AuthorID = ?";
        
        Connection connection = AuthorDS.INSTANCE.connection;
        
        try (PreparedStatement stmt = connection.prepareStatement(query))
        {
            stmt.setInt(1, id);
            
            try (ResultSet results = stmt.executeQuery())
            {
                if (results.next()) // Result was found
                {
                    AuthorTO to = new AuthorTO();
                    to.setId(results.getInt("AuthorID"));
                    to.setFirstName(results.getString("FirstName"));
                    to.setLastName(results.getString("LastName"));
                    return to;
                }
                else {
                    return null; // No result was found
                }
            }//~ try
        } catch (SQLException e)
        {
            throw new SQLException("Exception retreiving by id", e);
        } 
    }

    @Override
    public ArrayList<AuthorTO> update(AuthorTO dto) throws SQLException 
    {
        String query = "UPDATE authors SET FirstName = ?, LastName = ? WHERE AuthorID = ?";
        
        Connection connection = AuthorDS.INSTANCE.connection;
        
        try (PreparedStatement stmt = connection.prepareStatement(query))
        {
            stmt.setString(1, dto.getFirstName());
            stmt.setString(2, dto.getLastName());
            stmt.setInt(3, dto.getId());
            
            stmt.executeUpdate();
            
            return getAll();
            
        } catch (SQLException e)
        {
            throw new SQLException("Exception updating author", e);
        }
    }

    @Override
    public ArrayList<AuthorTO> delete(int id) throws SQLException 
    {
        String query1 = "DELETE FROM authorisbn WHERE AuthorID = ?";
        String query2 = "DELETE FROM authors WHERE AuthorID = ?";
        
        Connection connection = AuthorDS.INSTANCE.connection;
        
        try (
                PreparedStatement stmt1 = connection.prepareStatement(query1); 
                PreparedStatement stmt2 = connection.prepareStatement(query2))
        {
            stmt1.setInt(1, id);
            stmt1.executeUpdate();
            stmt2.setInt(1, id);
            stmt2.executeUpdate();
            return getAll();
        } catch (SQLException e)
        {
            throw new SQLException("Exception deleting author", e);
        }   
    }
    
    
    
}
