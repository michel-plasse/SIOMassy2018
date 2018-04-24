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
import java.util.List;
import model.Candidature;
import model.Personne;
import model.SessionFormation;

/**
 *
 * @author Kiiaroto
 */
public class CandidatureDao {

    private String sql;

    public List<Candidature> selectByFilter() throws SQLException {
        Connection con = Database.getConnection();
        List<Candidature> listeDesCandidatures = new ArrayList<Candidature>();
        SessionFormation sessionFormation = new SessionFormation();
        Candidature candidature = null;

        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        while (rs.next()) {
            Personne personne = new Personne(
                    rs.getInt("id_personne"),
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

            sessionFormation = new SessionFormation(
                    rs.getInt("id_session_formation"),
                    rs.getInt("id_formation"),
                    rs.getTimestamp("date_debut").toLocalDateTime(),
                    rs.getTimestamp("date_fin").toLocalDateTime(),
                    rs.getBoolean("est_ouverte"));

            candidature = new Candidature(
                    personne,
                    sessionFormation,
                    rs.getInt("id_etat_candidature"),
                    rs.getTimestamp("date_effet").toLocalDateTime());
            listeDesCandidatures.add(candidature);
        }
        stmt.close();
        con.close();
        return listeDesCandidatures;
    }

    public void updateById(int idPersonne, int idSessionFormation, int idEtatCandidature) throws SQLException {
        Connection con = Database.getConnection();
        String requete = "UPDATE candidature SET id_etat_candidature = ? WHERE id_personne = ? AND id_session_formation = ?";
        PreparedStatement stmt = con.prepareStatement(requete);
        stmt.setInt(1, idEtatCandidature);
        stmt.setInt(2, idPersonne);
        stmt.setInt(3, idSessionFormation);

        stmt.executeUpdate();
        stmt.close();
        con.close();
    }

    public void updateByCandidature(Candidature candidature) throws SQLException {
        Connection con = Database.getConnection();
        String requete = "UPDATE candidature SET id_etat_candidature = ? WHERE id_personne = ? AND id_session_formation = ?";

        PreparedStatement stmt = con.prepareStatement(requete);
        stmt.setInt(1, candidature.getEtatCandidature());
        stmt.setInt(2, candidature.getPersonne().getId());
        stmt.setInt(3, candidature.getSessionFormation().getIdSession());

        stmt.executeUpdate();
        stmt.close();
        con.close();
    }

    public void setTri(int idSessionFormation, int idEtatCandidature) {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT p.*, c.*, sf.*\n"
                + "from personne p\n"
                + "inner join candidature c on p.id_personne = c.id_personne\n"
                + "inner join etat_candidature e on e.id_etat_candidature = c.id_etat_candidature\n"
                + "inner join session_formation sf on c.id_session_formation = sf.id_session_formation\n"
                + "WHERE est_ouverte = true\n");

        if (idEtatCandidature > 0 && idSessionFormation == 0) {
            sb.append("AND c.id_etat_candidature = " + String.valueOf(idEtatCandidature) + "\n");
        } else if (idEtatCandidature == 0 && idSessionFormation > 0) {
            sb.append("AND c.id_session_formation = " + String.valueOf(idSessionFormation) + "\n");
        } else if (idEtatCandidature > 0 && idSessionFormation > 0) {
            sb.append("AND c.id_session_formation = " + String.valueOf(idSessionFormation) + " AND c.id_etat_candidature = " + String.valueOf(idEtatCandidature) + "\n");
        }

        sb.append("ORDER BY date_effet ASC");
        sql = sb.toString();
    }

}
