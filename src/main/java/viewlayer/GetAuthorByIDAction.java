/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package viewlayer;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import businesslayer.AuthorBusinessLogic;
import transferableobjects.AuthorTO;

/**
 *
 * @author User
 */
@WebServlet(name = "GetAuthorByIDAction", urlPatterns = {"/GetAuthorByIDAction"})
public class GetAuthorByIDAction extends HttpServlet 
{

    /* 
    * Helper function to simplify the construction of the body.
    * Having the ability to return control to outer function makes
    * the control structure cleaner, and easier to follow
    */
    private void constructBody(HttpServletRequest request, PrintWriter out)
    {
        String paramStr = request.getParameter("AuthorID");
        if (paramStr == null)
        {
            out.println("<p>ERROR: AuthorID not set</p>");
            return;
        }
        
        if (paramStr.equals(""))
        {
            out.println("<p>ERROR: AuthorID is empty string</p>");
            return;
        }

        int AuthorID = -1; 
        try {
            AuthorID = Integer.parseInt(request.getParameter("AuthorID"));        
        } catch (NumberFormatException e) {
            out.println("<p>" + e.getMessage() + "</p>");
            return;
        }
        
        if (AuthorID < 0)
        {
            out.println("<p>Invalid parameter value for: AuthorID. Must be greater than 0</p>");
            return;
        }
        
        AuthorTO author = AuthorBusinessLogic.get(AuthorID);
        if (author == null)
        {
            out.println("<p>ID: " + AuthorID + " doesn't exist</p>");
        }
        
        out.println("<p>ID        : " + author.getId() + "</p>");
        out.println("<p>First Name: " + author.getFirstName() + "</p>");
        out.println("<p>Last  Name: " + author.getLastName() + "</p>");
    }//~ constructBody(...);
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet GetAuthorByIDAction</title>");
            out.println("</head>");
            out.println("<body>");
            constructBody(request, out);
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
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
        return "Short description";
    }// </editor-fold>

}
