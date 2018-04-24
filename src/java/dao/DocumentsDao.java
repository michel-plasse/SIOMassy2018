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
import java.util.ArrayList;
import model.Document;
import model.Personne;
import model.SessionFormation;

/**
 *
 * @author YohanMA
 */

public class DocumentsDao {

    public Boolean isProprietaire(Personne p, int id_document) throws SQLException {
        Connection connection = Database.getConnection();

        String sql = "SELECT id_proprietaire"
                + " FROM document"
                + " WHERE id_document = ?";

        PreparedStatement stmt = connection.prepareCall(sql);
        stmt.setInt(1, id_document);

        ResultSet resultat = stmt.executeQuery();
        return resultat.getInt("id_proprietaire") == p.getId();
    }

    public Boolean isFormateur(Personne p) throws SQLException {
        Connection connection = Database.getConnection();

        String sql = "SELECT est_formateur"
                + " FROM personne"
                + " WHERE id_personne = ?";

        PreparedStatement stmt = connection.prepareCall(sql);
        stmt.setInt(1, p.getId());

        ResultSet resultat = stmt.executeQuery();
        return resultat.getBoolean("est_formateur");
    }

    public Boolean isAdmin(Personne p) throws SQLException {
        Connection connection = Database.getConnection();

        String sql = "SELECT est_administration"
                + " FROM personne"
                + " WHERE id_personne = ?";

        PreparedStatement stmt = connection.prepareCall(sql);
        stmt.setInt(1, p.getId());

        ResultSet resultat = stmt.executeQuery();
        return resultat.getBoolean("est_administration");
    }

    public void ajouter(Personne p, Document doc, ArrayList<Integer> listeSession) throws SQLException {

        if (isFormateur(p) || isAdmin(p)) {

            Connection connection = Database.getConnection();
            connection.setAutoCommit(false);

            try {
                String sql = "INSERT INTO document (id_document, id_proprietaire, nom, chemin, date_depot)"
                        + " VALUES (?, ?, ?, ?, NOW())";

                PreparedStatement stmt = connection.prepareStatement(sql);
                stmt.setInt(1, doc.getId());
                stmt.setInt(2, doc.getId_proprietaire());
                stmt.setString(3, doc.getNom());
                stmt.setString(4, doc.getChemin());

                stmt.executeUpdate();
                stmt.close();

                String droit = "INSERT INTO droit_sur_doc (id_document, id_session_formation)"
                        + " VALUES (?, ?)";

                for (Integer id_session : listeSession) {

                    PreparedStatement stmt2 = connection.prepareCall(droit);
                    stmt2.setInt(1, doc.getId());
                    stmt2.setInt(2, id_session);

                    stmt2.executeUpdate();
                    stmt2.close();

                }
                connection.commit();

            } catch (SQLException e) {
                connection.rollback();
            }

            connection.close();
        }
    }

    public ArrayList<SessionFormation> getSessionByDocument(int idDocument) throws SQLException{
        ArrayList<SessionFormation> lesSession = new ArrayList<>();
        Connection connection = Database.getConnection();
        
        String sql = "SELECT *"
                + " FROM session_formation sf"
                + " INNER JOIN"
                + " droit_sur_document dsd ON sf.id_session_formation = dsd.id_session_formation"
                + " WHERE dsd.id_document = ?";
        
        PreparedStatement stmt = connection.prepareCall(sql);
        stmt.setInt(1, idDocument);
        
        ResultSet resultat = stmt.executeQuery();
        
        while(resultat.next()){
            lesSession.add(new SessionFormation(
                        resultat.getInt("id_session_formation"),
                        resultat.getInt("id_formation"),
                        resultat.getTimestamp("date_debut").toLocalDateTime(),
                        resultat.getTimestamp("date_fin").toLocalDateTime(),
                        resultat.getBoolean("est_ouverte")
            ));
        }
        
        stmt.close();
        connection.close();
        
        return lesSession;
    }
    
    public ArrayList<Document> getDocumentBySession(int idSession) throws SQLException {
        ArrayList<Document> lesDocs = new ArrayList<>();
        Connection connection = Database.getConnection();

        String sql = "SELECT * FROM document"
                + " INNER JOIN"
                + " droit_sur_document dsd ON document.id_document = dsd.id_document"
                + " WHERE dsd.id_session = ?";

        PreparedStatement stmt = connection.prepareCall(sql);
        stmt.setInt(1, idSession);

        ResultSet resultat = stmt.executeQuery();

        while (resultat.next()) {
            lesDocs.add(new Document(
                    resultat.getInt("id_document"),
                    resultat.getInt("id_prorietaire"),
                    resultat.getString("nom"),
                    resultat.getString("chemin"),
                    resultat.getTimestamp("date_depot").toLocalDateTime())
            );
        }

        stmt.close();
        connection.close();
        return lesDocs;
    }

    public ArrayList<Document> getAllDocument(Personne p) throws SQLException {
        ArrayList<Document> lesDocs = new ArrayList<>();
        Connection connection = Database.getConnection();
        ResultSet resultat = null;
        String sql;

        if (isAdmin(p) || isFormateur(p)) {
            sql = "SELECT * FROM document";
            Statement stmt = connection.createStatement();
            resultat = stmt.executeQuery(sql);
            
        } else {
            sql = "SELECT * FROM document"
                    + " INNER JOIN"
                    + " droit_sur_document dsd ON document.id_document = dsd.id_document"
                    + " INNER JOIN"
                    + " session_formation sf ON dsd.id_session_formation = sf.id_session_formation"
                    + " INNER JOIN"
                    + " candidature c ON sf.id_session_formation = c.id_session_formation"
                    + " WHERE c.id_personne = ?";

            PreparedStatement stmt = connection.prepareCall(sql);
            stmt.setInt(1, p.getId());
            resultat = stmt.executeQuery(sql);
        }
        
        while (resultat.next()) {
            lesDocs.add(new Document(
                    resultat.getInt("id_document"),
                    resultat.getInt("id_prorietaire"),
                    resultat.getString("nom"),
                    resultat.getString("chemin"),
                    resultat.getTimestamp("date_depot").toLocalDateTime())
            );
        }
        return lesDocs;
    }

    public void supprimer(Personne p, int idDocument) throws SQLException {
        Connection connection = Database.getConnection();
        if (isProprietaire(p, idDocument) || isAdmin(p)) {

            String sql = "DELETE FROM document"
                    + " WHERE id_document = ?";

            PreparedStatement stmt = connection.prepareCall(sql);
            stmt.setInt(1, idDocument);

            stmt.executeUpdate();
            stmt.close();
            connection.close();
        }
    }

    public void modifierNomDocument(Personne p, int idDocument, String nouveauNom) throws SQLException {

        if (isProprietaire(p, idDocument) || isAdmin(p)) {

            Connection connection = Database.getConnection();
            String sql = "UPDATE document"
                    + " SET nom = ?"
                    + " WHERE id_document = ?";

            PreparedStatement stmt = connection.prepareCall(sql);
            stmt.setString(1, nouveauNom);
            stmt.setInt(2, idDocument);

            stmt.executeUpdate();
            stmt.close();
            connection.close();
        }
    }
}
