package dao;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Note;

public class NoteDao {

    // requete SQL en static pour eviter de l'instancier a chaque fois 'constante)
    private static final String NOTES_BY_SESSION;
    private static final String UPDATE_NOTES;
    

    // bloc d'initialisation des attributs static
    static {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT note.id_evaluation,note.id_personne,nom,prenom,note.note ");
        sb.append("FROM note INNER JOIN personne ON note.id_personne=personne.id_personne ");
        sb.append("WHERE note.id_evaluation=?; ");
        NOTES_BY_SESSION = sb.toString();
        sb = new StringBuilder();
        sb.append("UPDATE note SET note=? WHERE id_personne=? and id_evaluation = ?;");
        UPDATE_NOTES=sb.toString();
    }

    public List<Note> getByIdEvaluation(int idEvaluation) throws SQLException {
        List<Note> result = new ArrayList<>();
        Connection con = Database.getConnection();
        PreparedStatement stmt = con.prepareStatement(NOTES_BY_SESSION);
        stmt.setInt(1, idEvaluation);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Note uneNote = new Note(
                    rs.getInt("note.id_evaluation"),
                    rs.getInt("note.id_personne"),
                    rs.getString("nom"),
                    rs.getString("prenom"),
                    rs.getDouble("note.note"));
            result.add(uneNote);
        }
        return result;
    }

    public void updateNote(int idPersonne, int idEvaluation, double note) throws SQLException {
           Connection connection = Database.getConnection();
        PreparedStatement stmt = connection.prepareStatement(UPDATE_NOTES);
        stmt.setDouble(1, note);
        stmt.setInt(2, idPersonne);
        stmt.setInt(3, idEvaluation);
        stmt.executeUpdate();
        stmt.close();
        connection.close();
    }
}
