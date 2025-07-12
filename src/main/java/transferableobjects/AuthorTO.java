/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package transferableobjects;

/**
 * @author Arthur Scharf
 */
public class AuthorTO 
{


    private int id;
    private String firstName;
    private String lastName;
    
    
    public AuthorTO()
    {
        id = -1;
        firstName = null;
        lastName = null;
    }
    
    
    public int getId() 
    {
        return id;
    }

    public String getFirstName() 
    {
        return firstName;
    }

    public String getLastName() 
    {
        return lastName;
    }

    public void setId(int id) 
    {
        this.id = id;
    }

    public void setFirstName(String firstName) 
    {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) 
    {
        this.lastName = lastName;
    }
}
