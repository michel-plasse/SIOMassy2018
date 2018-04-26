/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.NoteDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.View;

/**
 *
 * @author Ferha
 */
@WebServlet(name = "ModifierNoteServlet", urlPatterns = {"/modifierNote"})
public class ModifierNoteServlet extends HttpServlet {

    public Boolean verifierSynthaxNote(String noteAverifier) {
        Boolean b = false;
        for (int x = 0; x < noteAverifier.length(); x++) {
            if (noteAverifier.substring(x) == ".") {
                b = true;
            } else {
                b = false;
            }
        }
        return b;

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        boolean champsValides = true;
        int idEvaluation = 0;
        try {
            idEvaluation = Integer.parseInt(request.getParameter("idEvaluation"));
        } catch (NumberFormatException ex) {
            champsValides = false;
            Logger.getLogger(SaisirNotesServlet.class.getName()).log(Level.SEVERE, null, ex);
            response.sendError(500, "idEvaluation non entier");
        }
        int idPersonne = 0;
        try {
            idPersonne = Integer.parseInt(request.getParameter("idPersonne"));
        } catch (NumberFormatException ex) {
            champsValides = false;
            Logger.getLogger(SaisirNotesServlet.class.getName()).log(Level.SEVERE, null, ex);
            response.sendError(500, "idPersonne non entier");
        }
        double note = 0;
        try {
            String noteAverifier = request.getParameter("note");
            NumberFormat format = NumberFormat.getInstance(Locale.ENGLISH);
            note = format.parse(request.getParameter("note")).doubleValue();
            System.out.println(note);
            if (note < 0 || note > 20) {
                champsValides = false;
                response.setStatus(400);
                response.getWriter().print("note doit etre entre 0 et 20 inclus");
            }
        } catch (ParseException ex) {
            champsValides = false;
            Logger.getLogger(SaisirNotesServlet.class.getName()).log(Level.SEVERE, null, ex);
            response.setStatus(400);
            response.getWriter().print("Entrez une note decimale (ex : 11.5)");
        }
        if (champsValides) {
            try {
                NoteDao dao = new NoteDao();
                dao.updateNote(idPersonne, idEvaluation, note);
                System.out.println(note);
                response.sendError(204);
            } catch (SQLException ex) {
                Logger.getLogger(SaisirNotesServlet.class
                        .getName()).log(Level.SEVERE, null, ex);
                response.sendError(500, ex.getMessage());
            }
        }
    }
}
