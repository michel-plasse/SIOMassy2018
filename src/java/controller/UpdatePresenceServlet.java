/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package controller;

import dao.PresenceDao;
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
import model.Presence;

/**
 *
 * @author tonyd_wl3
 */
@WebServlet(name = "UpdatePresenceServlet", urlPatterns = {"/update_presence"})
public class UpdatePresenceServlet extends HttpServlet {
    
    Presence pres = new Presence();
    private final String VUE_OK = "/WEB-INF/updatePresence.jsp";
    private final String VUE_ERREUR = "/WEB-INF/message.jsp";
    
    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String vue = VUE_OK;
        System.out.println("Je suis dans UpdatePresenceServlet");
        int idSeance = 1;
        try {
            PresenceDao dao = new PresenceDao();
            List<Presence> presences = dao.getByIdSeance(idSeance);
            request.setAttribute("presences", presences);
        } catch (SQLException e) {
            request.setAttribute("message", "Erreur !");
            vue = VUE_ERREUR;
        }
        request.setAttribute("idSeance", idSeance);
        request.getRequestDispatcher(vue).forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PresenceDao dao = new PresenceDao();
        int idSeance = 0;
        try {
            idSeance = Integer.parseInt(request.getParameter("idSeance"));
        } catch (NumberFormatException ex) {
            response.sendError(400, "idSeance doit être entier");
        }
        int idPersonne = 0;
        try {
            idPersonne = Integer.parseInt(request.getParameter("idPersonne"));
        } catch (NumberFormatException ex) {
            response.sendError(400, "idPersonne doit être entier");
        }
        String value = request.getParameter("estPresent");
        Boolean estPresent = null;
        switch (value) {
            case "true":
                estPresent = true;
                break;
            case "false":
                estPresent = false;
                break;
            case "null":
                break;
            default:
                response.sendError(400, "estPresent doit être true, false ou null");
        }
        try {
            dao.updatePresence(idSeance, idPersonne, estPresent);
        } catch (SQLException ex) {
            Logger.getLogger(UpdatePresenceServlet.class.getName()).log(Level.SEVERE, null, ex);
            response.sendError(500, ex.getMessage());
        }
    }
    
}
