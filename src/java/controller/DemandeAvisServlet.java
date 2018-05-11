package controller;

import dao.AvisDao;
import dao.CandidatureDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Avis;
import model.Candidature;
import model.EtatCandidature;

@WebServlet(name = "DemandeAvisServlet", urlPatterns = {"/DemandeAvisServlet"})
public class DemandeAvisServlet extends HttpServlet {

    private final String VUE_AFFICHE_AVIS = "/WEB-INF/listerLesAvis.jsp";
    private final String VUE_ERREUR = "/WEB-INF/message.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet DemandeAvisServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet DemandeAvisServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String vue = VUE_ERREUR;
        try {
            ArrayList<Avis> listeDesAvis = AvisDao.afficher();
            request.setAttribute("listeDesAvis", listeDesAvis);
            vue = VUE_AFFICHE_AVIS;
        } catch (SQLException ex) {
            Logger.getLogger(DemandeAvisServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        getServletContext().getRequestDispatcher(vue).forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
