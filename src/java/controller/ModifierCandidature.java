/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.CandidatureDao;
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
import model.Candidature;
import model.EtatCandidature;

/**
 *
 * @author Kiiaroto
 */
@WebServlet(name = "ModifierCandidature", urlPatterns = {"/ModifierCandidature"})
public class ModifierCandidature extends HttpServlet {

    private String VUE_OK = "/WEB-INF/modifierCandidature.jsp";
    private String VUE_ERREUR = "/WEB-INF/message.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String vue = VUE_OK;
        int numeroCandidature = Integer.parseInt(request.getParameter("Modifier"));
        try {
            CandidatureDao dao = new CandidatureDao();
            List<Candidature> candidatures = dao.selectAll();
            Candidature uneCandidature = candidatures.get(numeroCandidature);
            request.setAttribute("etatCandidature", new EtatCandidature());
            request.setAttribute("candidature", uneCandidature);
            request.setAttribute("numeroCandidature", numeroCandidature);

        } catch (SQLException exc) {
            exc.printStackTrace();
            request.setAttribute("message", "Pb de bases de données");
            vue = VUE_ERREUR;
        }
        getServletContext().getRequestDispatcher(vue).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(request.getParameter("Etat"));
        System.out.println(request.getParameter("Modifier"));
        try {
            
            CandidatureDao dao = new CandidatureDao();
            String personne = request.getParameter("Modifier");
            int idSessionFormation = Integer.parseInt(personne.substring(personne.lastIndexOf("-")+1));
            int idPersonne = Integer.parseInt(personne.substring(0, personne.lastIndexOf("-")));
            int idEtatCandidature = Integer.parseInt(request.getParameter("Etat"));
            //System.out.println("new Etat: " + uneCandidature.getEtatCandidature());
            System.out.println("idPersonne: " + idPersonne + " | idSessionFormation: " + idSessionFormation + " | idEtatCandidature: "+ idEtatCandidature);
            dao.updateById(idPersonne, idSessionFormation, idEtatCandidature);
        } catch (SQLException ex) {
            Logger.getLogger(ModifierCandidature.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
