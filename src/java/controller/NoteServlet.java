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
@WebServlet(name = "NoteServlet", urlPatterns = {"/modifierNote"})
public class NoteServlet extends HttpServlet {

    private final String VUE_FORM = "/WEB-INF/note.jsp";
    private final String VUE_MESSAGE = "/WEB-INF/message.jsp";
    String vue = VUE_FORM;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        try {
          //  int idEvaluation = Integer.parseInt(request.getParameter("idEvaluation"));
           // int idPersonne = Integer.parseInt(request.getParameter("idPersonne"));
           // double note = Double.parseDouble(request.getParameter("note"));
            NoteDao dao = new NoteDao();
             List<Note> LesNotes = dao.getNotes(1);
            request.setAttribute("evaluation", LesNotes);
            System.out.println("je suis dans la servlet " +LesNotes.get(1).getIdPersonne());
            
            //dao.updateNote(idPersonne, idEvaluation, note);
            //response.sendError(204);
        } catch (SQLException ex) {
            Logger.getLogger(NoteServlet.class.getName()).log(Level.SEVERE, null, ex);
            request.setAttribute("message", "Problème de bases de données à " + (new Date()));
            vue = VUE_MESSAGE;
        }
        
        request.getRequestDispatcher(vue).forward(request, response);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPut(req, resp); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
