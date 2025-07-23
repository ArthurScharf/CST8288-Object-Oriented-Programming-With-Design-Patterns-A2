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
import businesslayer.TitleBusinessLogic;
import transferableobjects.AuthorTO;
import transferableobjects.TitleTO;

/**
 *
 * @author Arthur Scharf
 */
public class GetTitleByISBNAction extends HttpServlet 
{

    /* 
    * Helper function to simplify the construction of the body.
    * Having the ability to return control to outer function makes
    * the control structure cleaner, and easier to follow
    */
    private void constructBody(HttpServletRequest request, PrintWriter out)
    {
        String paramStr = request.getParameter("ISBN");
        if (paramStr == null)
        {
            out.println("<p>ERROR: ISBN not set</p>");
            return;
        }
        
        if (paramStr.equals(""))
        {
            out.println("<p>ERROR: ISBN is empty string</p>");
            return;
        }

        String ISBN = request.getParameter("ISBN");
        
        TitleTO title = TitleBusinessLogic.get(ISBN);
        if (title == null)
        {
            out.println("<p>ISBN: " + ISBN + " doesn't exist</p>");
            return;
        }
        
        out.println("<p>ISBN           : " + title.getIsbn() + "</p>");
        out.println("<p>Title          : " + title.getTitle() + "</p>");
        out.println("<p>Edition Number : " + title.getEditionNumber() + "</p>");
        out.println("<p>Copyright      : " + title.getCopyright() + "</p>");
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
