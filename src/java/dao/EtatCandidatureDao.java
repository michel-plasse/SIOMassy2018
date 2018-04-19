/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import model.EtatCandidature;

/**
 *
 * @author Kiiaroto
 */
public class EtatCandidatureDao {
    
    public void select() throws SQLException {
        Connection con = Database.getConnection();
        String requete = "SELECT * FROM agriotes2018.etat_candidature";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(requete);
        
        while (rs.next()) {            
            EtatCandidature.getValues().put(rs.getInt("id_etat_candidature"), rs.getString("libelle"));
        }
    }
    
}
