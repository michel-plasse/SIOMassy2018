/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.Database;
import dao.EvaluationDao;
import dao.ModuleDao;
import dao.SessionFormationDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Evaluation;
import model.SessionFormation;

@WebServlet(name = "EvaluationServlet", urlPatterns = {"/creerEvaluation"})
public class EvaluationServlet extends HttpServlet {

    private final String VUE_FORM = "/WEB-INF/creerEvaluation.jsp";
    private final String VUE_MESSAGE = "/WEB-INF/message.jsp";
    boolean valider = false;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            setSessionsEtModules(request);
            request.getRequestDispatcher(VUE_FORM).forward(request, response);
        } catch (SQLException exc) {
            if (exc.getErrorCode() == Database.DOUBLON) {
                request.setAttribute("message", "l'evaluation existe déja ");
            }
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

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
        String vue = VUE_FORM;
        try {
            Connection con = Database.getConnection();

            EvaluationDao eval = new EvaluationDao();
            Evaluation evaluation = new Evaluation(8, 1, 2, 23, LocalDateTime.now(), 50, "français");
            eval.insert(evaluation);
            // verifier les params
            // si ok
//            request.setAttribute("message", "votre evaluation a bien été ajouter ");
//            vue = VUE_MESSAGE;
            response.sendRedirect("evaluationsFormateur");
            // sinon
            setSessionsEtModules(request);
            vue = VUE_FORM;
            // reafficher le form
        } catch (SQLException ex) {
            if (ex.getErrorCode() == Database.FOREIGN_KEY_NOT_FOUND) {
                request.setAttribute("message", "Module ou session introuvable");
                vue = VUE_MESSAGE;
            } else if (ex.getErrorCode() == Database.DOUBLON) {
                request.setAttribute("message", "Evaluation de mêmes nom, module et date déjà créée");
                vue = VUE_MESSAGE;
            } 
            else {
                Logger.getLogger(EvaluationServlet.class.getName()).log(Level.SEVERE, null, ex);
                request.setAttribute("message", "Problème avec la base de données à " + (new Date()));
                vue = VUE_MESSAGE;
            }
            request.getRequestDispatcher(vue).forward(request, response);
        }
    }

    /**
     * Met en attributs de la requete les modules et sessions a afficher dans
     * des selecr
     */
    private void setSessionsEtModules(HttpServletRequest request) throws SQLException {
        SessionFormationDao daoSF = new SessionFormationDao();
        List<SessionFormation> sessions = daoSF.getOuvertes();
        ModuleDao daoM = new ModuleDao();
        // appel methode ecrite dans dao 
        request.setAttribute("modules", daoM.getAll());
        request.setAttribute("sessions", sessions);
    }
}
