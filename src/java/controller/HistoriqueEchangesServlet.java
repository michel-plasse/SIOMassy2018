package controller;

import dao.PersonneDao;
import dao.EchangeDao;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Personne;
import model.Echange;

/**
 * Servlet implementation class EchangeServlet
 */
@WebServlet(name = "HistoriqueEchangesServlet", urlPatterns = {"/historiqueEchanges"})
public class HistoriqueEchangesServlet extends HttpServlet {

    private final String VUE_OK = "/WEB-INF/historiqueEchanges.jsp";

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
        // Controler que idContact est present dans les parametres de l'url, et entier 
        int idPersonne = 2;//Integer.parseInt(request.getParameter("idContact"));
        // Aller chercher dans PersonneDao ... getById la personne
        EchangeDao dao = new EchangeDao();
        try {
            List<Echange> listeDesEchanges = dao.getHistoriqueByPersonne(idPersonne);
            // Recuperer via Echange Dao la liste des echanges
            // Les mettre en attributs de request
            request.setAttribute("listeDesEchanges", listeDesEchanges);
        } catch (SQLException ex) {
            Logger.getLogger(HistoriqueEchangesServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
      
        request.setAttribute("idContact", idPersonne);
        request.getRequestDispatcher(VUE_OK).forward(request, response);
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
        request.getRequestDispatcher(VUE_OK).forward(request, response);
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
