/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.AvisDao;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Avis;
import model.Personne;

/**
 *
 * @author Ronan
 */
@WebServlet(name = "AvisServlet", urlPatterns = {"/AvisServlet"})
public class AvisServlet extends HttpServlet {

    private final String VUE_AVIS = "/WEB-INF/donnerAvis.jsp";
    private final String VUE_ERREUR = "/WEB-INF/message.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("-------------------------------------------------------------------------VUE_AVIS");
        request.getRequestDispatcher(VUE_AVIS).forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 System.out.println("+++++++++++++++++++++++++++++++++++---------VUE_AVIS");
        String avisFonctionnel = request.getParameter("avisFonctionnalite");
        String avisErgonomique = request.getParameter("avisErgonomie");
        String avisBeaute = request.getParameter("avisEsthetisme");
        String commentaire = request.getParameter("avisCommentaire");
        LocalDateTime avisDate = null;
        int avisFonction = -1;
        int avisErgo = -1;
        int avisBeau = -1;

        String vue = VUE_AVIS;

        try {
            avisDate = LocalDateTime.now();
        } catch (Exception e) {
            System.out.println("pb date");
            vue = VUE_ERREUR;
        }

        try {
            avisFonction = Integer.parseInt(avisFonctionnel);
        } catch (Exception e) {
            System.out.println("pb parse int1");
            vue = VUE_ERREUR;

        }

        try {
            avisErgo = Integer.parseInt(avisErgonomique);
        } catch (Exception e) {
            System.out.println("pb parse int2");
            vue = VUE_ERREUR;

        }

        try {
            avisBeau = Integer.parseInt(avisBeaute);
        } catch (Exception e) {
            System.out.println("pb parse int3");
            vue = VUE_ERREUR;
        }
        
        
        HttpSession maSession = request.getSession();
        Personne user = (Personne) maSession.getAttribute("user");
        Avis avis = new Avis(user.getId(), avisFonction, avisErgo, avisBeau, commentaire, avisDate);

        try {
            
            AvisDao.insert(avis);
        } catch (SQLException ex) {
            Logger.getLogger(AvisServlet.class.getName()).log(Level.SEVERE, null, ex);
            vue = VUE_ERREUR;

        }

        request.setAttribute("message", "Votre avis est pris en compte !");
        request.getRequestDispatcher(vue).forward(request, response);
    }
    
    

}
