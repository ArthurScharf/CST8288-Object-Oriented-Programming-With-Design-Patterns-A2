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

import businesslayer.UserAuthentication;
import javax.servlet.RequestDispatcher;


/**
 *
 * @author Arthur Scharf
 * @description Controller servlet for Authentication
 */
public class AuthController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {            
        
        // -- Authenticate User -- //
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        
        if ( username == null || password == null || !UserAuthentication.authenticateUser(username, password) )
        {
            request.setAttribute("ErrorMessage", ErrorMessage.EM_BAD_CREDENTIALS);
            getServletContext().getNamedDispatcher("ErrorView").include(request, response);
        }

        //  -- Dispatch to next servlet -- //
        RequestDispatcher dispatcher = getServletContext().getNamedDispatcher(request.getParameter("action"));
        if (dispatcher != null)  // Servlet found
        {
            dispatcher.include(request, response);
        } else {
            request.setAttribute("ErrorMessage", ErrorMessage.EM_BAD_PATH);
            getServletContext().getNamedDispatcher("ErrorView").include(request, response);
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
