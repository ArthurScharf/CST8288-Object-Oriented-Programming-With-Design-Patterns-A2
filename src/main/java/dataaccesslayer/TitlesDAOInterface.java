/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dataaccesslayer;

import transferableobjects.TitleTO;

import java.util.ArrayList;

import java.sql.SQLException;


/**
 * @author Arthur Scharf
 */
public interface TitlesDAOInterface 
{    
    public ArrayList<TitleTO> getAll() throws SQLException;
    
    public ArrayList<TitleTO> create(TitleTO dto) throws SQLException;
    
    public TitleTO get(String isbn) throws SQLException;
    
    public ArrayList<TitleTO> update(TitleTO dto) throws SQLException;
    
    public ArrayList<TitleTO> delete(String isbn) throws SQLException;
}


