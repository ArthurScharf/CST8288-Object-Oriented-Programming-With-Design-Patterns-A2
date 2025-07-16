/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package viewlayer;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * @author Arthur Scharf
 */
public class FrontController extends HttpServlet 
{
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {  
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) 
        {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("    <title>Login & Actions</title>");
            out.println("</head>");
            out.println("<body style=\"background-color: powderblue\">");
            out.println("<center>");
            out.println("<p>Program by:  Arthur Scharf (040797015)</p>");
            out.println("<p>For: 25S CST8288 Section 010 Assignment 2</p>");
            out.println("<p>Things put after FrontController\'s include wouldn\'t render for some reason. I became tired of trying to fix it so"
                    + " I put my credentials here. Please forgive me :( </p>");
            out.println("<a href=\"http://localhost:8080/Arthur.Scharf.A2/controller/LoginView\">Home</a>");

            // This application doesn't use nested resources
            // Gets the Request dispatcher for the servlet associated with the path
            RequestDispatcher dispatcher = getServletContext().getNamedDispatcher(request.getPathInfo().split("/")[1]);
            if (dispatcher != null)  // Servlet found
            {
                dispatcher.include(request, response);
            } else {
                request.setAttribute("ErrorMessage", ErrorMessage.EM_BAD_PATH);
                getServletContext().getNamedDispatcher("ErrorView").include(request, response);
            }
            

            out.println("</center>");
            out.println("</body>");
            out.println("</html>");
        
        } catch (IOException e)
        {
            response.sendRedirect("localhost:8080/Arthur.Scharf.A2/WEB-INF/badlogin.html");
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
