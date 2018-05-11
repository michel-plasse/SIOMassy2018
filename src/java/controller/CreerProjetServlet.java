/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ProjetDao;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Personne;
import model.Projet;

/**
 *
 * @author YVES D'OR
 */
@WebServlet(name = "CreerProjetServlet", urlPatterns = {"/creerProjet"})
public class CreerProjetServlet extends HttpServlet {

    private final String VUE_FORM = "/WEB-INF/creerProjet.jsp";

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher(VUE_FORM).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String vue = VUE_FORM;
        boolean ok = false;
        try {
            boolean champsrempli = true;
            Personne user = (Personne) request.getSession(true).getAttribute("user");
            if (user == null) {
                request.setAttribute("message", "Vous devez vous connecter");
                vue = "WEB-INF/message.jsp";
            } else {
                int idSessionFormation = Integer.parseInt(request.getParameter("idSessionFormation"));
                String titre = request.getParameter("titre");
                if (titre == null) {
                    champsrempli = false;
                    request.setAttribute("titre", "enter a title");
                }
                if (champsrempli) {
                    try {
                        Projet projetAjoute = new Projet(0, user.getId(), idSessionFormation, titre);
                        ProjetDao dao = new ProjetDao();
                        dao.insert(projetAjoute);
                        request.setAttribute("message", "Le projet a été ajouté, sous le id " + projetAjoute.getId());
                        ok = true;
                    } catch (SQLException ex) {
                        request.setAttribute("message", "Pb de bases de données " + ex.getMessage());
                        Logger.getLogger(HistoriqueEchangesServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        } catch (NumberFormatException exc) {
            request.setAttribute("message", "entrez un idSessionFormation entier");
        }
        if (ok) {
            response.sendRedirect("projets");
        } else {
            request.getRequestDispatcher(VUE_FORM).forward(request, response);
        }
    }
}
