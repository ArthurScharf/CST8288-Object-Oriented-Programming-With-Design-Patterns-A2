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

/**
 *
 * @author Arthur Scharf
 */
public class LoginView extends HttpServlet {

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
                
        try (PrintWriter out = response.getWriter()) 
        {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Login View</title>");       
            out.println("</head>");
            out.println("<body>");
            out.println("    <h2>Login</h2>");
            out.println("    <form action=\"AuthController\" method=\"POST\">");
            out.println("        <label for=\"username\">Username:</label><br>");
            out.println("        <input type=\"text\" id=\"username\" name=\"username\" required><br><br>");
            out.println("        <label for=\"password\">Password:</label><br>");
            out.println("        <input type=\"password\" id=\"password\" name=\"password\" required><br><br>");
            
            // -- Action Types -- //
            out.println("        <button type=\"submit\" name=\"action\" value=\"GetAuthorsView\">Get All Authors</button>");
            out.println("        <button type=\"submit\" name=\"action\" value=\"GetAuthorByIDView\">Get Author by ID</button>");
            out.println("        <button type=\"submit\" name=\"action\" value=\"CreateAuthorView\">Create</button>");
            out.println("        <button type=\"submit\" name=\"action\" value=\"UpdateAuthorView\">Update</button>");
            out.println("        <button type=\"submit\" name=\"action\" value=\"DeleteAuthorView\">Delete</button>");
            
            out.println("        <br><br>");
            
            out.println("        <button type=\"submit\" name=\"action\" value=\"GetTitlesView\">Get All Titles</button>");
            out.println("        <button type=\"submit\" name=\"action\" value=\"GetTitleByISBNView\">Get Title by ISBN</button>");
            out.println("        <button type=\"submit\" name=\"action\" value=\"CreateTitleView\">Create</button>");
            out.println("        <button type=\"submit\" name=\"action\" value=\"UpdateTitleView\">Update</button>");
            out.println("        <button type=\"submit\" name=\"action\" value=\"DeleteTitleView\">Delete</button>");
            
            /*
                // Delete Title
            */
            
            out.println("    </form>");
            out.println("</body>");
            out.println("</html>");
        } catch (IOException e)
        {
            request.setAttribute("ErrorMessage", ErrorMessage.EM_BAD_CREDENTIALS);
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
