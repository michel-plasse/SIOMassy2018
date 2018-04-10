package controller;

import dao.EvaluationStagiaireDao;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Evaluation;
import model.Personne;

/**
 * Servlet implementation class EvaluationStagiaireServlet
 */
@WebServlet(name = "EvaluationStagiaireServlet", urlPatterns = {"/evaluationsStagiaire"})
public class EvaluationStagiaireServlet extends HttpServlet {
    private final String VUE_OK = "/WEB-INF/evaluationsStagiaire.jsp";
    private final String VUE_ERREUR = "/WEB-INF/message.jsp";
    Personne personne = new Personne();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String vue = VUE_OK;
        try {
            EvaluationStagiaireDao dao = new EvaluationStagiaireDao();
            // List<Evaluation> evaluations = dao.getEvaluationByStagiaire();
            List<Evaluation> evaluations = dao.getEvaluationByStagiaire(18);
            request.setAttribute("evaluation", evaluations);
            
        } catch (SQLException exc) {
            exc.printStackTrace();
            request.setAttribute("message", "Probleme  de bases de données ");
            vue = VUE_ERREUR;
        }
        getServletContext().getRequestDispatcher(vue).forward(request, response);
    }
}
