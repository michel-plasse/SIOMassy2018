/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.SQLException;
import java.util.List;
import model.Presence;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author tonyd_wl3
 */
public class PresenceDaoTest extends DaoTestCase {

    @Test
    public void testAjoutPresence() throws SQLException {
        System.out.println("updatePresence");
        PresenceDao instance = new PresenceDao();
        Presence presence = instance.getByIdSeance(1).get(0);
        assertTrue(presence.isEstPresent());
        presence.setEstPresent(false);
        instance.updatePresence(presence.getIdSeance(), presence.getPersonne().getId(), presence.isEstPresent());
        presence = instance.getByIdSeance(1).get(0);
        assertFalse(presence.isEstPresent());
    }

    @Test
    public void testGetByIdSeancePasTrouve() throws SQLException {
        System.out.println("updatePresence");
        PresenceDao instance = new PresenceDao();
        List<Presence> result = instance.getByIdSeance(100);
        assertTrue(result.isEmpty());
    }
}
