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
public interface DAOInterface 
{    
    public ArrayList<AuthorTO> getAll() throws SQLException;
    
    public AuthorTO create(AuthorTO dto) throws SQLException;
    
    public AuthorTO getByIndex(int index) throws SQLException;
    
    public AuthorTO updateByIndex(int index, AuthorTO dto) throws SQLException;
    
    public AuthorTO deleteByIndex(int index) throws SQLException;
}


