package dao;

import java.sql.*;

import model.Personne;

public class PersonneDao {

    public void insert(Personne personne) throws SQLException {
        Connection connection = Database.getConnection();
        String sql = "INSERT INTO personne (id_personne, nom, prenom, mail ,tel ,adresse,code_postal,ville,mot_de_passe)"
                + " VALUES (?, ?, ?, ?, ?, ?, ?, ?,?)";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, personne.getId());
        stmt.setString(2, personne.getNom());
        stmt.setString(3, personne.getPrenom());
        stmt.setString(4, personne.getMail());
        stmt.setString(5, personne.getTel());
        stmt.setString(6, personne.getAdresse());
        stmt.setString(7, personne.getCodePostal());
        stmt.setString(8, personne.getVille());
        stmt.setString(9, personne.getMotDePasse());
        stmt.executeUpdate();
        stmt.close();
        connection.close();
    }
    public void evaluationFormateur(String idFormateur){
        Statement canal = null;
        try {
              Connection con = Database.getConnection();
              canal = con.createStatement();
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					System.out.println("le statement ne marche pas ");
				}
				
					try {
						ResultSet resultat =canal.executeQuery("SELECT * FROM agriotes2018.evaluation WHERE id_formateur == "+ idFormateur );
						while(resultat.next()) {
                                                    String id_evaluation;
                                                    String id_module;
                                                    String id_formateur;
                                                    String date_debut;
                                                    String nb_minute;
                                                    String titre;
						}}catch (SQLException e) { System.out.println("la Selection de Bases de données dans My sql ne foctionne pas");}
					
					
    
    }

}
