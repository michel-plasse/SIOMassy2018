package dao;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import model.Evaluation;

public class EvaluationDao {

    public List<Evaluation> getEvaluationByStagiaire(int idStagiaire) throws SQLException {
        Connection con = Database.getConnection();
        List<Evaluation> result = new ArrayList<>();

        String requete = "SELECT * FROM evaluation WHERE id_session_formation IN "
                + "( SELECT id_session_formation FROM stagiaire"
                + " WHERE est_ouverte=1 AND id_personne=?"
                + "); ";

        PreparedStatement canal = con.prepareStatement(requete);
        canal.setInt(1, idStagiaire);
        ResultSet rs = canal.executeQuery();

        while (rs.next()) {
            Evaluation evaluation = new Evaluation(
                    rs.getInt("id_evaluation"),
                    rs.getInt("id_module"),
                    rs.getInt("id_session_formation"),
                    rs.getInt("id_formateur"),
                    rs.getTimestamp("date_debut").toLocalDateTime(),
                    rs.getInt("nb_minutes"),
                    rs.getString("titre"));
            result.add(evaluation);
        }

        return result;
    }

    public List<Evaluation> getEvaluationByFormateur(int idFormateur) throws SQLException {
        Connection con = Database.getConnection();
        List<Evaluation> result = new ArrayList();
        String requete = "SELECT * FROM evaluation WHERE id_formateur=?";
        PreparedStatement canal = con.prepareStatement(requete);
        canal.setInt(1, idFormateur);
        ResultSet rs = canal.executeQuery();
        while (rs.next()) {
            Evaluation evaluation = new Evaluation(
                    rs.getInt("id_evaluation"), 
                    rs.getInt("id_module"), 
                    rs.getInt("id_session_formation"), 
                    rs.getInt("id_formateur"),
                    rs.getTimestamp("date_debut").toLocalDateTime(), 
                    rs.getInt("nb_minutes"),
                    rs.getString("titre"));
            result.add(evaluation);
        }
        return result;
    }

    public void insert(Evaluation evaluation) throws SQLException {
        Connection connection = Database.getConnection();
        String sql = "INSERT INTO evaluation (id_evaluation, id_module, id_session_formation,id_formateur,  date_debut, nb_minutes, titre)"
                + " VALUES (?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, evaluation.getIdEvaluation());
        stmt.setInt(2, evaluation.getIdModule());
        stmt.setInt(3, evaluation.getIdSessionFormation());
        stmt.setInt(4, evaluation.getIdFormateur());
        stmt.setTimestamp(5, Timestamp.valueOf(evaluation.getDateDebut()));
        stmt.setInt(6, evaluation.getNbMinutes());
        stmt.setString(7, evaluation.getTitre());
        stmt.executeUpdate();
    }

}
