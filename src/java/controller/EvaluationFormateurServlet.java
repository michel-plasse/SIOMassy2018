package controller;


import dao.EvaluationDaoFormateurDao;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Evaluation;

/**
 * Servlet implementation class EvaluationFormateurServlet
 */
@WebServlet(name = "EvaluationFormateurServlet", urlPatterns = {"/evaluationsFormateur"})
public class EvaluationFormateurServlet extends HttpServlet {
    private final String VUE_OK = "/WEB-INF/evaluationsFormateur.jsp";
    private final String VUE_ERREUR = "/WEB-INF/message.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String vue = VUE_OK;
        try {
            EvaluationDaoFormateurDao dao = new EvaluationDaoFormateurDao();
            List<Evaluation> evaluations = dao.getOuvertes();
            request.setAttribute("evaluation", evaluations);
            
        } catch (SQLException exc) {
            exc.printStackTrace();
            request.setAttribute("message", "Probleme  de bases de données ");
            vue = VUE_ERREUR;
        }
        getServletContext().getRequestDispatcher(vue).forward(request, response);
    }
}
