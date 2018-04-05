package dao;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Evaluation;




public class EvaluationDao {

  
    public List<Evaluation> getOuvertes() throws SQLException {
        Connection con = Database.getConnection();
        List<Evaluation> result = new ArrayList();

        String requete = "SELECT * FROM agriotes2018.evaluation ";

        Statement canal = con.createStatement();
        ResultSet rs = canal.executeQuery(requete);

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

}

