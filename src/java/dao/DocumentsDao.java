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

    public int getIdDocumentByName(Document doc) throws SQLException {
        int idDocument = 0;
        Connection connection = Database.getConnection();
        String sql = "SELECT id_document FROM document WHERE nom = ?";

        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, doc.getNom());

        ResultSet resultat = stmt.executeQuery();
        while(resultat.next()){
            idDocument = resultat.getInt("id_document");
        }

        stmt.close();
        connection.close();

        return idDocument;
    }

    public void ajouterDocument(Personne p, Document doc) throws SQLException {

        if (p.isEstAdministration() || p.isEstFormateur()) {

            Connection connection = Database.getConnection();

            String sql = "INSERT INTO document (id_proprietaire, nom, chemin, date_depot)"
                    + " VALUES (?, ?, ?, NOW())";

            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, doc.getIdProprietaire());
            stmt.setString(2, doc.getNom());
            stmt.setString(3, doc.getChemin());

            stmt.executeUpdate();
            stmt.close();
            connection.close();
        }
    }

    public void ajouterDroitDocument(int idDocument, ArrayList<Integer> listeSessions) throws SQLException {
        Connection connection = Database.getConnection();

        for (Integer idSession : listeSessions) {

            String droit = "INSERT INTO droit_sur_document (id_document, id_session_formation)"
                    + " VALUES (?, ?)";

            PreparedStatement stmt = connection.prepareCall(droit);
            stmt.setInt(1, idDocument);
            stmt.setInt(2, idSession);

            stmt.executeUpdate();
            stmt.close();
        }
        connection.close();
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
                    resultat.getTimestamp("date_depot").toLocalDateTime())
            );
        }

        stmt.close();
        connection.close();
        return lesDocs;
    }

    public ArrayList<Document> getAllDocumentByPersonne(Personne p) throws SQLException {
        ArrayList<Document> lesDocs = new ArrayList<>();
        Connection connection = Database.getConnection();
        String sql;

        if (p.isEstAdministration() || p.isEstFormateur()) {
            sql = "SELECT * FROM document ORDER BY date_depot DESC";
        } else {
            sql = "SELECT DISTINCT d.id_document, d.id_proprietaire, d.nom, d.chemin, d.date_depot FROM document d"
                    + " INNER JOIN"
                    + " droit_sur_document dsd ON d.id_document = dsd.id_document"
                    + " INNER JOIN"
                    + " session_formation sf ON dsd.id_session_formation = sf.id_session_formation"
                    + " INNER JOIN"
                    + " candidature c ON sf.id_session_formation = c.id_session_formation"
                    + " WHERE c.id_personne = " + p.getId() + " AND c.id_etat_candidature = 6 ORDER BY d.date_depot DESC";
        }

        Statement stmt = connection.createStatement();
        ResultSet resultat = stmt.executeQuery(sql);

        while (resultat.next()) {
            lesDocs.add(new Document(
                    resultat.getInt("id_document"),
                    resultat.getInt("id_proprietaire"),
                    resultat.getString("nom"),
                    resultat.getTimestamp("date_depot").toLocalDateTime())
            );
        }

        connection.close();
        return lesDocs;
    }

    public void supprimer(Personne p, int idDocument) throws SQLException {
        Connection connection = Database.getConnection();
        if (p.isEstAdministration() || p.isEstFormateur()) {

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

        if (p.isEstAdministration() || p.isEstFormateur()) {

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
