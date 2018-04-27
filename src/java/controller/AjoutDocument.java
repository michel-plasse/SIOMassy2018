/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.DocumentsDao;
import dao.SessionFormationDao;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Document;
import model.Personne;
import model.SessionFormation;
import tools.Upload;

/**
 *
 * @author stagiaire
 */
@WebServlet(name = "AjoutDocumentServlet", urlPatterns = {"/ajoutDocument"})
@MultipartConfig(fileSizeThreshold = 6291456, // 6 MB
        maxFileSize = 10485760L, // 10 MB    
        maxRequestSize = 20971520L // 20 MB
)

public class AjoutDocument extends HttpServlet {

    private final String VUE_UPLOAD = "/WEB-INF/ajoutDocument.jsp";
    private final String VUE_SALON_DOC = "/WEB-INF/salonDocument.jsp";
    //private final String REP_DST = "/agriotes2018/documents/";
    private final String REP_DST = "/home/yohan/Bureau/";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        String vue = VUE_UPLOAD;
        SessionFormationDao daoSession = new SessionFormationDao();

        try {
            List<SessionFormation> lesSession = daoSession.getOuvertes();
            session.setAttribute("lesSession", lesSession);
        } catch (SQLException ex) {
            Logger.getLogger(AjoutDocument.class.getName()).log(Level.SEVERE, null, ex);
        }

        request.getServletContext().getRequestDispatcher(vue).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        Personne p = (Personne) session.getAttribute("user");
        DocumentsDao daoDocument = new DocumentsDao();
        String vue = VUE_UPLOAD;

        if (request.getParameter("uploadphoto") != null) {

            String nomDocument = (String) request.getAttribute("nouveauNom");

            if (nomDocument.equals(null)) {
                nomDocument = request.getPart("doc").getName();
                nomDocument = nomDocument.substring(nomDocument.lastIndexOf('/') + 1);
                nomDocument = nomDocument.substring(nomDocument.lastIndexOf('\\') + 1);
            }

            String destination = REP_DST + nomDocument;

            if (Upload.upload(request.getPart("doc"), destination, nomDocument)) {
                Document document = new Document(0, p.getId(), REP_DST, null);
                ArrayList<Integer> listeSession = (ArrayList<Integer>) request.getAttribute("idSession[]");

                try {
                    daoDocument.ajouter(p, document, listeSession);
                } catch (SQLException ex) {
                    Logger.getLogger(AjoutDocument.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            vue = VUE_SALON_DOC;
        }
        
        request.getServletContext().getRequestDispatcher(vue).forward(request, response);
    }
}
