package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Echange;

/**
 *
 * @author SANOGO
 */
public class EchangeDao {

    public List<Echange> getHistoriqueByPersonne(int idPersonne) throws SQLException {
        Connection con = Database.getConnection();
        List<Echange> result = new ArrayList();

        String requete = "SELECT * FROM echange WHERE id_personne=?";
        PreparedStatement canal = con.prepareStatement(requete);
        canal.setInt(1, idPersonne);
        ResultSet rs = canal.executeQuery();

        while (rs.next()) {
            Echange historiqueEchanges = new Echange(
                    rs.getInt("id_echange"),
                    rs.getInt("id_personne"),
                    rs.getString("id_type_echange"),
                    rs.getTimestamp("instant").toLocalDateTime(),
                    rs.getString("texte"));
            result.add(historiqueEchanges);
        }

        return result;

    }
}
