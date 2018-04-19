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
@WebServlet(name = "ListerCandidatures", urlPatterns = {"/ListerCandidatures"})
public class ListerCandidatures extends HttpServlet {

    private final String VUE_OK = "/WEB-INF/listerCandidatures.jsp";
    private final String VUE_ERREUR = "/WEB-INF/message.jsp";
    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String vue = VUE_OK;
        try {
            CandidatureDao dao = new CandidatureDao();
            List<Candidature> candidatures = dao.selectAll();
            request.setAttribute("listeCandidature", candidatures);
            request.setAttribute("etatCandidature", new EtatCandidature());
            
        } catch (SQLException exc) {
            exc.printStackTrace();
            request.setAttribute("message", "Pb de bases de données");
            vue = VUE_ERREUR;
        }
        getServletContext().getRequestDispatcher(vue).forward(request, response);
    }
}
