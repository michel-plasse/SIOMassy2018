/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.DocumentsDao;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Document;
import model.Personne;

/**
 *
 * @author YohanMA
 */

@WebServlet(name = "DocumentServlet", urlPatterns = {"/document"})
public class DocumentServlet extends HttpServlet {
    
    private final String VUE_GESTION = "/WEB-INF/salonDocuments.jsp";
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String vue = VUE_GESTION;
        
        HttpSession session = request.getSession(true);
        //Personne p = (Personne) session.getAttribute("user");
        DocumentsDao dao = new DocumentsDao();
        
        Personne p = new Personne(1, "Callahan", "Quincy", "metus@odia.net", "0960458869", "Ap #649-4330 Suscipit Avenue", "70651", "Casablanca", "gravida", false, true);
        session.setAttribute("user", p);
        
        session.setAttribute("retour", "");
        
        try {
            ArrayList<Document> lesDocuments = dao.getAllDocumentByPersonne(p);
            session.setAttribute("lesDocuments", lesDocuments);
            vue = VUE_GESTION;
        } catch (SQLException ex) {
            Logger.getLogger(DocumentServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        request.getServletContext().getRequestDispatcher(vue).forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
}