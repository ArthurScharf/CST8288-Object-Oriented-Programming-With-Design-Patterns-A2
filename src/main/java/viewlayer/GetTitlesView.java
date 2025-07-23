/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package viewlayer;

import dataaccesslayer.AuthorDA;
import dataaccesslayer.TitlesDA;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
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
 * @author User
 */
public class GetTitlesView extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) 
        {
            out.println("<body>");
            // -- Authors Access -- //
            TitlesDA dao = TitlesDA.INSTANCE;
            ArrayList<TitleTO> dtos;
            try {
                dtos = dao.getAll();
                out.println("<p>Size of query: " + dtos.size() + "</p>");
                out.println("<table border=\"1\">");
                out.println("<tr>");
                out.println("<td>ISBN</td>");
                out.println("<td>Title</td>");
                out.println("<td>Edition Number</td>");
                out.println("<td>Copyright</td>");
                out.println("</tr>");
                for(TitleTO dto : dtos)
                {
                    out.printf("<tr><td>%s</td><td>%s</td><td>%s</td><td>%s</td></tr>",
                        dto.getIsbn(), dto.getTitle(), dto.getEditionNumber(), dto.getCopyright());
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
