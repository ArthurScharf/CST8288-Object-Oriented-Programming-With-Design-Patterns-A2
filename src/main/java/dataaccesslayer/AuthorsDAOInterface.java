/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dataaccesslayer;

import transferableobjects.AuthorTO;

import java.util.ArrayList;

import java.sql.SQLException;


/**
 * @author Arthur Scharf
 */
public interface AuthorsDAOInterface 
{    
    public ArrayList<AuthorTO> getAll() throws SQLException;
    
    public ArrayList<AuthorTO> create(AuthorTO dto) throws SQLException;
    
    public AuthorTO get(int id) throws SQLException;
    
    public ArrayList<AuthorTO> update(AuthorTO dto) throws SQLException;
    
    public ArrayList<AuthorTO> delete(int id) throws SQLException;
}


