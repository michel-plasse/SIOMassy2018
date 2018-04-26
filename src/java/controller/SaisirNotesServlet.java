/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.NoteDao;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Note;

/**
 *
 * @author Ferha
 */
@WebServlet(name = "NoteServlet", urlPatterns = {"/saisirNotes"})
public class SaisirNotesServlet extends HttpServlet {

    private final String VUE_FORM = "/WEB-INF/notes.jsp"; 
    private final String VUE_MESSAGE = "/WEB-INF/message.jsp";
    String vue = VUE_FORM;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idEvaluation = 1; // d'abord en dur
        try {
            NoteDao dao = new NoteDao();
            
            List<Note> notes = dao.getByIdEvaluation(idEvaluation);
            request.setAttribute("titre",notes.get(idEvaluation).getTitre());
            request.setAttribute("notes", notes);
        } catch (SQLException ex) {
            Logger.getLogger(SaisirNotesServlet.class.getName()).log(Level.SEVERE, null, ex);
            request.setAttribute("message", "Problème de bases de données à " + (new Date()));
            vue = VUE_MESSAGE;
        }
        request.getRequestDispatcher(vue).forward(request, response);
    }

 }
