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

  public void updatePassword(String pwd, int id) throws SQLException {
    Connection con = Database.getConnection();
    String sql = "UPDATE personne SET mot_de_passe = ? WHERE id_personne = ?";
    PreparedStatement stmt = con.prepareStatement(sql);
    stmt.setString(1, pwd);
    stmt.setInt(2, id);
    stmt.executeUpdate();
    stmt.close();
    con.close();
  }

  public boolean checkPassword(String pwd, int id) throws SQLException {
    Connection con = Database.getConnection();
    String sql = "SELECT mot_de_passe FROM personne WHERE id_personne = ? AND mot_de_passe =?";
    PreparedStatement stmt = con.prepareStatement(sql);
    stmt.setInt(1, id);
    stmt.setString(2, pwd);
    ResultSet resultat = stmt.executeQuery();
    return resultat.next();
  }

  /**
   * Personne de login et mot de passe passés en paramètre, ou null si pas
   * trouvée. Le mot de passe est pour l'instant passé en clair, mais il devra
   * être crypté quand il sera crypté dans la table personne (ce qu'il faut pour
   * des raisons de sécurité).
   *
   * @param login
   * @param password
   * @return
   */
  public Personne getByLoginPassword(String login, String password) throws SQLException {
    Connection con = Database.getConnection();
    Personne result = null;
    // Nous cherchons dans la vue membre, qui ajoute a personne le booleen est_formateur
    String sql = "SELECT * FROM membre WHERE mail=? AND mot_de_passe=?";
    PreparedStatement stmt = con.prepareStatement(sql);
    stmt.setString(1, login);
    stmt.setString(2, password);
    ResultSet rs = stmt.executeQuery();
    if (rs.next()) {
      result = new Personne(
              rs.getInt("id_personne"),
              rs.getString("nom"),
              rs.getString("prenom"),
              rs.getString("mail"),
              rs.getString("tel"),
              rs.getString("adresse"),
              rs.getString("code_postal"),
              rs.getString("ville"),
              rs.getString("mot_de_passe"),
              rs.getBoolean("est_administration"),
              rs.getBoolean("est_formateur"));
    }
    stmt.close();
    con.close();
    return result;
  }
}
