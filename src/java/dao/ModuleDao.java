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
import java.util.Map;
import model.Module;
import model.SessionFormation;

/**
 *
 * @author tchju
 */
public class ModuleDao {

    public Map<Integer, String> getAll() throws SQLException {
        Map<Integer, String> result = new HashMap<>();
        Connection con = Database.getConnection();
        String requete = "SELECT * FROM module ORDER BY nom ASC";
        Statement canal = con.createStatement();
        ResultSet rs = canal.executeQuery(requete);
        while (rs.next()) {
            result.put(rs.getInt("id_module"), rs.getString("nom"));
        }
        return result;
    }
}