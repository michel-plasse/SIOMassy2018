/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.Database;
import dao.PersonneDao;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Personne;
import tools.Upload;

/**
 *
 * @author Teixei_H https://javatutorial.net/java-servlet-file-upload
 */
@WebServlet(name = "GestionProfilServlet", urlPatterns = {"/gestion_profil"})
@MultipartConfig(fileSizeThreshold = 6291456, // 6 MB
        maxFileSize = 10485760L, // 10 MB    
        maxRequestSize = 20971520L // 20 MB
)
public class GestionProfilServlet extends HttpServlet {

    private final String VUE_UPLOAD = "/WEB-INF/gestionProfil.jsp";
    private final String VUE_MESSAGE = "/WEB-INF/message.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String vue = VUE_UPLOAD;
        HttpSession session = request.getSession(true);
        Personne user = (Personne) session.getAttribute("user");

        if (user == null) {
            vue = VUE_MESSAGE;
            request.setAttribute("message", "Vous devez être connecté");
        } else {

            PersonneDao pdao = new PersonneDao();

            if ("uploadphoto".equals(request.getParameter("action"))) {

                String nomPhoto = user.getPrenom() + "_" + user.getNom() + "_" + user.getId();
                String UPLOAD_DIR_PHOTO = getServletContext().getRealPath("/photos");
                boolean resultat = Upload.upload(request.getPart("photo"), UPLOAD_DIR_PHOTO, nomPhoto);

                if (resultat) {
                    System.out.println("Upload OK");
                    request.setAttribute("upload", "Image envoyée avec succès !");
                } else {
                    System.out.println("Upload NOK");
                    request.setAttribute("upload", "Erreur dans l'envoi de votre image.");
                }
            }

            if ("pwdchange".equals(request.getParameter("action"))) {

                boolean champsvalides = true;

                String pwdactuel = request.getParameter("pwdactuel");
                String newpwd = request.getParameter("newpwd");
                String pwdcheck = request.getParameter("pwdcheck");

                if (pwdactuel == null || pwdactuel.matches("^ *$")) {
                    champsvalides = false;
                    request.setAttribute("pwdactuel_message", "Veuillez entrer votre mot de passe actuel.");
                    vue = VUE_UPLOAD;
                }

                if (newpwd == null || newpwd.matches("^ *$")) {
                    champsvalides = false;
                    request.setAttribute("newpwd_message", "Veuillez entrer un nouveau mot de passe.");
                    vue = VUE_UPLOAD;
                }

                if (pwdcheck == null || pwdcheck.matches("^ *$")) {
                    champsvalides = false;
                    request.setAttribute("pwdcheck_message", "Veuillez confirmer votre mot de passe.");
                    vue = VUE_UPLOAD;
                } else if (!pwdcheck.equals(newpwd)) {
                    champsvalides = false;
                    request.setAttribute("pwdcheck_message", "Les deux mots de passes ne correspondent pas.");
                    vue = VUE_UPLOAD;
                }

                if (champsvalides) {
                    try {
                        Connection con = Database.getConnection();

                        if (pdao.checkPassword(pwdactuel, user.getId())) {
                            pdao.updatePassword(newpwd, user.getId());
                            request.setAttribute("message", "Mot de passe changé avec succès !");
                            vue = VUE_MESSAGE;
                        } else {
                            request.setAttribute("pwdactuel_message", "Ce n'est pas le bon mot de passe.");
                            vue = VUE_UPLOAD;
                        }

                    } catch (SQLException ex) {
                        Logger.getLogger(GestionProfilServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
        request.getRequestDispatcher(vue).forward(request, response);
    }

}
