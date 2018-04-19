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
    
    public List<Candidature> selectAll() throws SQLException {
        Connection con = Database.getConnection();
        List<Candidature> listeDesCandidatures = new ArrayList<Candidature>();
        Personne personne = new Personne();
        SessionFormation sessionFormation = new SessionFormation();
        Candidature candidature = null;
        
        String requete = "SELECT p.*, c.*, sf.*\n" +
"from personne p\n" +
"inner join candidature c on p.id_personne = c.id_personne\n" +
"inner join etat_candidature e on e.id_etat_candidature = c.id_etat_candidature\n" +
"inner join session_formation sf on c.id_session_formation = sf.id_session_formation\n" +
"\n" +
"ORDER BY date_effet ASC";
        
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(requete);
        
        while (rs.next()) {
            if (personne.getId() != rs.getInt("id_personne")) {
                personne = new Personne();
                personne.setId(rs.getInt("id_personne"));
                personne.setNom(rs.getString("nom"));
                personne.setPrenom(rs.getString("prenom"));
                personne.setMail(rs.getString("mail"));
                personne.setTel(rs.getString("tel"));
                personne.setAdresse(rs.getString("adresse"));
                personne.setCodePostal(rs.getString("code_postal"));
                personne.setVille(rs.getString("ville"));
                personne.setMotDePasse(rs.getString("mot_de_passe"));
            }
            
            if (sessionFormation.getIdSession() != rs.getInt("id_session_formation")) {
                sessionFormation = new SessionFormation();
                sessionFormation.setIdSession(rs.getInt("id_session_formation"));
                sessionFormation.setIdFormation(rs.getInt("id_formation"));
                sessionFormation.setDateDebut(rs.getTimestamp("date_debut").toLocalDateTime());
                sessionFormation.setDateFin(rs.getTimestamp("date_fin").toLocalDateTime());
                sessionFormation.setEstOuverte(rs.getBoolean("est_ouverte"));
            }
            
            candidature = new Candidature(personne, sessionFormation, rs.getInt("id_etat_candidature"), rs.getTimestamp("date_effet").toLocalDateTime());
            
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
        stmt.setInt(1,idEtatCandidature);
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
    
}
