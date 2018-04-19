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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ferha
 */
@WebServlet(name = "ModifierNoteServlet", urlPatterns = {"/modifierNote"})
public class ModifierNoteServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idEvaluation = Integer.parseInt(request.getParameter("idEvaluation"));
        int idPersonne = Integer.parseInt(request.getParameter("idPersonne"));
        double note = Double.parseDouble(request.getParameter("note"));
        NoteDao dao = new NoteDao();

        System.out.println("idEvaluation : " + idEvaluation);
        System.out.println("idPersonne : " + idPersonne);
        try {
            dao.updateNote(idPersonne, idEvaluation, note);
            response.sendError(204);
        } catch (SQLException ex) {
            Logger.getLogger(SaisirNotesServlet.class.getName()).log(Level.SEVERE, null, ex);
            response.sendError(500, ex.getMessage());
        }

    }

}
