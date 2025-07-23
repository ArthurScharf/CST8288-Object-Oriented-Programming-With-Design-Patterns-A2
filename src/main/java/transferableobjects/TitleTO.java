/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package transferableobjects;

/**
 * @author Arthur Scharf
 */
public class TitleTO 
{
    private String isbn; // Primary key
    private String title;
    private int editionNumber;
    private String copyright;

 
    public TitleTO()
    {
        isbn = "";
        title = "";
        editionNumber = -1;
        copyright = "";
    }
    
    
    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public int getEditionNumber() {
        return editionNumber;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setEditionNumber(int editionNumber) {
        this.editionNumber = editionNumber;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

}