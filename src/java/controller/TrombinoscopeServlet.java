/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Personne;
import dao.StagiaireDao;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author YVES D'OR
 */
@WebServlet(name = "TrombinoscopeServlet", urlPatterns = {"/trombinoscope"})
public class TrombinoscopeServlet extends HttpServlet {
    private final String VUE_TROMBINOSCOPE = "/WEB-INF/trombinoscope.jsp";
    private final String VUE_MESSAGE = "/WEB-INF/message.jsp";

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String vue = VUE_TROMBINOSCOPE;
        try {
            int idSession = Integer.parseInt(request.getParameter("idSession"));
            StagiaireDao dao = new StagiaireDao();
            List<Personne> stagiaires = dao.getByIdSession(idSession);
            System.out.println("nb " + stagiaires.size());
            request.setAttribute("stagiaires", stagiaires);
        } catch (NumberFormatException exc) {
            request.setAttribute("message", "Le paramètre idSession doit etre entier");
            vue = VUE_MESSAGE;
        } catch (SQLException ex) {
            Logger.getLogger(TrombinoscopeServlet.class.getName()).log(Level.SEVERE, null, ex);
            request.setAttribute("message", ex.getMessage());
            vue = VUE_MESSAGE;
        }
        request.getRequestDispatcher(vue).forward(request, response);
    }
}
