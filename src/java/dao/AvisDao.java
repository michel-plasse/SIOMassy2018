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
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import model.Avis;

/**
 *
 * @author Ronan
 */
public class AvisDao {

    public static void insert(Avis avis) throws SQLException {

        Connection connection = Database.getConnection();
        String sql = "INSERT INTO avis ( fonctionnalite, ergonomie,beaute, commentaire, date_effet)"
                + " VALUES (?, ?, ?, ?, ?)";
        PreparedStatement stmt = connection.prepareStatement(sql);

        stmt.setInt(1, avis.getFonctionnalite());
        stmt.setInt(2, avis.getErgonomie());
        stmt.setInt(3, avis.getBeaute());
        stmt.setString(4, avis.getCommentaire());
        stmt.setTimestamp(5, Timestamp.valueOf(avis.getDate()));
        stmt.executeUpdate();
        stmt.close();
        connection.close();

    }

    public static ArrayList<Avis> afficher() throws SQLException {

        ArrayList<Avis> listeDesAvis = new ArrayList<>();

        Connection connection = Database.getConnection();
        String sql = "SELECT * FROM avis ORDER BY date_effet DESC";
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        while (rs.next()) {
            Avis avis = new Avis(
                    rs.getInt("id_personne"),
                    rs.getInt("fonctionnalite"),
                    rs.getInt("ergonomie"),
                    rs.getInt("beaute"),
                    rs.getString("commentaire"),
                    rs.getTimestamp("date_effet").toLocalDateTime());

            listeDesAvis.add(avis);
        }

        stmt.close();
        connection.close();
        return listeDesAvis;
    }

}
