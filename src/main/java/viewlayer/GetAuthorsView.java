/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package viewlayer;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.SQLException;

import java.util.ArrayList;


import dataaccesslayer.AuthorDA;
import transferableobjects.AuthorTO;

/**
 *
 * @author Arthur Scharf
 */
public class GetAuthorsView extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws SQLException if an error occurs when retrieving the information
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            out.println("<body>");
            // -- Authors Access -- //
            AuthorDA dao = AuthorDA.INSTANCE;
            ArrayList<AuthorTO> dtos;
            try {
                dtos = dao.getAll();
                out.println("<p>Size of query: " + dtos.size() + "</p>");
                out.println("<table border=\"1\">");
                out.println("<tr>");
                out.println("<td>AuthorID</td>");
                out.println("<td>First Name</td>");
                out.println("<td>Last Name</td>");
                out.println("</tr>");
                for(AuthorTO dto : dtos){
                    out.printf("<tr><td>%d</td><td>%s</td><td>%s</td></tr>",
                        dto.getId(), dto.getFirstName(), dto.getLastName());
                }
                out.println("</table>");
            } catch (SQLException e) {
                out.println("   <p>" + e.getMessage() + "</p>");
            }
            out.println("</body>");
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
