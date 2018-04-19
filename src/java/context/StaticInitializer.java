/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package context;

import dao.EtatCandidatureDao;
import java.sql.SQLException;

/**
 *
 * @author Kiiaroto
 */
public class StaticInitializer {

    public static void initializeStaticData() throws SQLException {
        EtatCandidatureDao etatCandidatureDao = new EtatCandidatureDao();
        etatCandidatureDao.select();
    }
}
