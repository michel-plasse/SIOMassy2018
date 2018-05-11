package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.SessionFormation;

public class SessionFormationDao {

    /** Sessions de formation actuellement ouvertes (sur la base du champ est_ouverte de la table 
     * session_formation), triées de la plus ancienne  la plus récente.
     * @return
     * @throws SQLException 
     */
    public List<SessionFormation> getOuvertes() throws SQLException {
        Connection con = Database.getConnection();
        List<SessionFormation> listeDesSessionsOuvertes = new ArrayList<SessionFormation>();

        String requete = "SELECT sf.id_session_formation, sf.id_formation, sf.date_debut, sf.date_fin, sf.est_ouverte, f.nom AS nom_formation"
                + " FROM session_formation sf"
                + " INNER JOIN"
                + " formation f ON sf.id_formation = f.id_formation"
                + " WHERE sf.est_ouverte = true ORDER BY sf.date_debut ASC";

        Statement canal = con.createStatement();
        ResultSet rs = canal.executeQuery(requete);

        while (rs.next()) {
            SessionFormation session = new SessionFormation();
            session.setIdSession(rs.getInt("id_session_formation"));
            session.setIdFormation(rs.getInt("id_formation"));
            session.setNomFormation(rs.getString("nom_formation"));
            session.setDateDebut(rs.getTimestamp("date_debut").toLocalDateTime());
            session.setDateFin(rs.getTimestamp("date_fin").toLocalDateTime());
            session.setEstOuverte(rs.getBoolean("est_ouverte"));
            listeDesSessionsOuvertes.add(session);
        }

        return listeDesSessionsOuvertes;
    }

}
