/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Personne;

/**
 *
 * @author YVES D'OR
 */
/**
 * *
 */
public class StagiaireDao {

    private Personne Personne;

    public List<Personne> getByIdSession(int idSession) throws SQLException {
        ArrayList<Personne> result = new ArrayList();
        Connection connection = Database.getConnection();
        String sql = "SELECT * FROM stagiaire WHERE id_session_formation=?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, idSession);
        ResultSet rs = stmt.executeQuery();

//        while (rs.next()) {
//            Personne pers = new Personne(
//                    rs.getInt("id_personne"),
//                    rs.getString("nom"),
//                    rs.getString("prenom"),
//                    rs.getString("mail"),
//                    rs.getString("tel"),
//                    rs.getString("adresse"),
//                    rs.getString("ville"),
//                    rs.getString("code_postal"),
//                    rs.getString("mot_de_passe"));
//            result.add(pers);
//        }
        return result;
    }

}
