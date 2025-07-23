/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package viewlayer;

import businesslayer.TitleBusinessLogic; // Assuming this class exists for title operations
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import transferableobjects.TitleTO; // Import the TitleTO class

/**
 * @author Arthur Scharf
 */
@WebServlet("/CreateTitleAction") // Maps this servlet to the /CreateTitleAction URL
public class CreateTitleAction extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods. This method is responsible for receiving and processing the
     * title creation data.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8"); // Set the content type for the response

        String isbn          = request.getParameter("ISBN");
        String title         = request.getParameter("Title");
        int editionNumber = Integer.parseInt(request.getParameter("EditionNumber"));
        String copyright     = request.getParameter("Copyright");
        
        if (isbn == null || title == null || editionNumber == -1 || copyright == null)
        {   
            request.setAttribute(
                    "ErrorMessage", 
                    String.format("Invalid Credentials: ISBN: %s\nTitle: %s\nEditionNumber: %s\nCopyright: %s", isbn, title, editionNumber, copyright)
            );
            getServletContext().getNamedDispatcher("ErrorView").include(request, response);
            return;
        }
        
        TitleTO dto = new TitleTO();
        dto.setIsbn(isbn); 
        dto.setTitle(title); 
        dto.setEditionNumber(editionNumber); 
        dto.setCopyright(copyright); 

        try{
            TitleBusinessLogic.create(dto);
            getServletContext().getNamedDispatcher("GetTitlesView").include(request, response);
            return;
        } catch (SQLException e)
        {
            request.setAttribute(
                    "ErrorMessage", 
                    String.format("Failed to create Title\n" + e.getMessage())
            );
            getServletContext().getNamedDispatcher("ErrorView").include(request, response);
            return;
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     * Delegates to {@link #processRequest(HttpServletRequest request, HttpServletResponse response) processRequest}
     * for unified handling of GET and POST requests.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     * Delegates to {@link #processRequest(HttpServletRequest request, HttpServletResponse response) processRequest}
     * for unified handling of GET and POST requests. This servlet is primarily
     * intended to receive POST requests from the creation form.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Servlet for handling the creation of Title entities.";
    }// </editor-fold>

}


