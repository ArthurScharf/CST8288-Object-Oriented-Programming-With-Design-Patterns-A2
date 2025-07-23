/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package viewlayer;

import businesslayer.AuthorBusinessLogic;
import businesslayer.TitleBusinessLogic;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import transferableobjects.AuthorTO;
import transferableobjects.TitleTO;

/**
 *
 * @author Arthur Scharf
 */
public class UpdateTitleAction extends HttpServlet {

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
            throws ServletException, IOException 
    {
        
        String isbn = request.getParameter("ISBN");
        String title = request.getParameter("Title");
        int editionNumber = Integer.parseInt(request.getParameter("EditionNumber"));
        String copyright = request.getParameter("Copyright");
        
        if (isbn == null || title == null || editionNumber == -1 || copyright == null)
        {
            request.setAttribute("ErrorMessage", ErrorMessage.EM_BAD_INFO);
            getServletContext().getNamedDispatcher("ErrorView").include(request, response);
        }
        
        TitleTO dto = new TitleTO();
        dto.setIsbn(isbn);
        dto.setTitle(title);
        dto.setEditionNumber(editionNumber);
        dto.setCopyright(copyright);
        TitleBusinessLogic.update(dto);
       
        getServletContext().getNamedDispatcher("GetTitlesView").include(request, response);
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
