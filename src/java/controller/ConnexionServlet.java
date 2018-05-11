package controller;

import dao.PersonneDao;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Personne;

@WebServlet(name = "ConnexionServlet", urlPatterns = {"/connexion"})
public class ConnexionServlet extends HttpServlet {

    private final String VUE_INDEX = "/index.jsp";
    private final String VUE_FORM = "/WEB-INF/login.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //request.setAttribute("nbFoi", 0);
        request.getRequestDispatcher(VUE_FORM).forward(request, response);
    }

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
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        PersonneDao dao = new PersonneDao();
        Personne user = null;
        try {
            user = dao.getByLoginPassword(login, password);
        } catch (SQLException ex) {
            Logger.getLogger(ConnexionServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (user != null) {
            // Ajouter en session
            //request.setAttribute("nbFoi", 0);
            
            HttpSession maSession = request.getSession();
            maSession.setAttribute("user", user);
            // Passer la main à la bonne JSP
            request.getRequestDispatcher(VUE_INDEX).forward(request, response);
        } else {
//            if (request.getParameter("nbFoi") != null) {
//                int nbFoi = Integer.parseInt(request.getParameter("nbFoi"));
//                nbFoi++;
//                request.setAttribute("nbFoi", nbFoi);
//            }
//            else {
//                request.setAttribute("nbFoi", 1);
//            }

            request.getRequestDispatcher(VUE_FORM).forward(request, response);
            //}
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
