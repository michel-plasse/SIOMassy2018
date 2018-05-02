/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Personne;
import model.Presence;

/**
 *
 * @author tonyd_wl3
 */
public class PresenceDao {

    public void updatePresence(int idSeance, int idPersonne, Boolean estPresent) throws SQLException {
        Connection con = Database.getConnection();
        String req = "UPDATE presence SET est_present=? WHERE id_personne=? AND id_seance=?";
        PreparedStatement canal = con.prepareStatement(req);
        if (estPresent == null) {
            canal.setNull(1, java.sql.Types.BOOLEAN);
        } else {
            canal.setBoolean(1, estPresent);
        }
        canal.setInt(2, idPersonne);
        canal.setInt(3, idSeance);
        canal.executeUpdate();
        canal.close();
        con.close();

    }

    public List<Presence> getByIdSeance(int idSeance) throws SQLException {
        List<Presence> result = new ArrayList<Presence>();
        Connection con = Database.getConnection();
        String req = "SELECT * FROM presence INNER JOIN personne ON personne.id_personne = presence.id_personne "
                + "WHERE id_seance=?";
        PreparedStatement stmt = con.prepareStatement(req);
        stmt.setInt(1, idSeance);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Personne personne = new Personne(
                    rs.getInt("personne.id_personne"),
                    rs.getString("nom"),
                    rs.getString("prenom"),
                    rs.getString("mail"),
                    rs.getString("tel"),
                    rs.getString("adresse"),
                    rs.getString("code_postal"),
                    rs.getString("ville"),
                    rs.getString("mot_de_passe"),
                    false,
                    false);
            Presence presence = new Presence(
                    rs.getInt("id_seance"),
                    personne,
                    rs.getBoolean("est_present")
            );
            result.add(presence);
        }
        return result;
    }

}
