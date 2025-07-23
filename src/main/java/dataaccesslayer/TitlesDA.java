/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dataaccesslayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import transferableobjects.TitleTO;

/**
 *
 * @author User
 */
public enum TitlesDA implements TitlesDAOInterface
{
        
    // SINGLETON pattern. Threadsafe
    INSTANCE;

    @Override
    public ArrayList<TitleTO> getAll() throws SQLException 
    {
        String query = "SELECT * FROM titles";
        // This will always exist because of the enum implementation strategy for the connection
        Connection conn = DataSource.INSTANCE.connection;
        
        ArrayList<TitleTO> dtos = new ArrayList<>();
                
        try ( Statement stmt = conn.createStatement(); ResultSet results = stmt.executeQuery(query); )
        {
            // -- Constructing  Transfer Objects -- //
            while (results.next()) // Remember that index 0 is ignored. This is why we can do .next() instead of .hasNext()
            {
                TitleTO dto = new TitleTO(); 
                dto.setIsbn(results.getString("isbn"));
                dto.setTitle(results.getString("title"));
                dto.setEditionNumber(results.getInt("editionNumber"));
                dto.setCopyright(results.getString("copyright"));
                dtos.add(dto);
            }//~ while(results.next())
        } catch (SQLException e) {
            throw new SQLException("Exception when retrieving all authors: " + e.getMessage(), e);
        }   
        return dtos;
    }

    @Override
    public ArrayList<TitleTO> create(TitleTO dto) throws SQLException 
    {        
        String query = "INSERT INTO titles (ISBN, Title, EditionNumber, Copyright) VALUES(?, ?, ?, ?);";
        
        Connection connection = DataSource.INSTANCE.connection;
        
        try (PreparedStatement stmt = connection.prepareStatement(query))
        {
            stmt.setString(1, dto.getIsbn());
            stmt.setString(2, dto.getTitle());
            stmt.setInt(3, dto.getEditionNumber());
            stmt.setString(4, dto.getCopyright());
            
            int affectedRows = stmt.executeUpdate();
            
            if (affectedRows == 0)
            {
                throw new SQLException("Failed to create title");
            }
            else return new ArrayList<>(); // Insert failed
        } catch (SQLException e)
        {
            throw new SQLException("SQL Error: " + e.getSQLState(), e);
        }
    }

    @Override
    public TitleTO get(String isbn) throws SQLException 
    {
        String query = "SELECT * FROM titles where isbn = ?";
        
        Connection connection = DataSource.INSTANCE.connection;
        
        try (PreparedStatement stmt = connection.prepareStatement(query))
        {
            stmt.setString(1, isbn);
            
            try (ResultSet results = stmt.executeQuery())
            {
                if (results.next()) // Result was found
                {
                    TitleTO to = new TitleTO();
                    to.setIsbn(results.getString("ISBN"));
                    to.setTitle(results.getString("Title"));
                    to.setEditionNumber(results.getInt("EditionNumber"));
                    to.setCopyright(results.getString("Copyright"));
                    return to;
                }
                else {
                    return null; // No result was found
                }
            }//~ try
        } catch (SQLException e)
        {
            throw new SQLException("Exception retreiving by isbn", e);
        } 
    }

    @Override
    public ArrayList<TitleTO> update(TitleTO dto) throws SQLException 
    {
        String query = "UPDATE Titles SET "
                + "Title = ?, "
                + "EditionNumber = ?, "
                + "Copyright = ? "
                + "WHERE ISBN = ?";
        
        Connection connection = DataSource.INSTANCE.connection;
        
        try (PreparedStatement stmt = connection.prepareStatement(query))
        {
            stmt.setString(1, dto.getTitle());
            stmt.setInt(2, dto.getEditionNumber());
            stmt.setString(3, dto.getCopyright());
            stmt.setString(4, dto.getIsbn());
            
            
            int numRowsAffected = stmt.executeUpdate();
            if (numRowsAffected == 0)
            {
                throw new SQLException("Failed to update title");
            }
            
            return getAll();
            
        } catch (SQLException e)
        {
            throw new SQLException("Exception updating title", e);
        }
    }

    @Override
    public ArrayList<TitleTO> delete(String isbn) throws SQLException 
    {
        String query = "DELETE FROM Titles WHERE ISBN = ?";
        
        
        Connection connection = DataSource.INSTANCE.connection;
        
        try ( PreparedStatement stmt = connection.prepareStatement(query); )
        {
            stmt.setString(1, isbn);
            stmt.execute();
            return getAll(); // We'll see if it failed based on results returned
        } catch (SQLException e)
        {
            throw new SQLException("Exception deleting author", e);
        }   
    }
}
