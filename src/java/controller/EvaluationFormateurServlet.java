package controller;


import dao.EvaluationDao;
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
 * Servlet implementation class EvaluationFormateurServlet
 */
@WebServlet(name = "EvaluationFormateurServlet", urlPatterns = {"/evaluationsFormateur"})
public class EvaluationFormateurServlet extends HttpServlet {
    private final String VUE_OK = "/WEB-INF/evaluationsFormateur.jsp";
    private final String VUE_ERREUR = "/WEB-INF/message.jsp";
    Personne personne = new Personne();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String vue = VUE_OK;
        try {
            EvaluationDao dao = new EvaluationDao();
           //  List<Evaluation> evaluations = dao.getEvaluationByFormateur(personne.getId());
           List<Evaluation> evaluations = dao.getEvaluationByFormateur(23);
            request.setAttribute("evaluation", evaluations);
            
        } catch (SQLException exc) {
            exc.printStackTrace();
            request.setAttribute("message", "Probleme  de bases de données ");
            vue = VUE_ERREUR;
        }
        getServletContext().getRequestDispatcher(vue).forward(request, response);
    }
}
