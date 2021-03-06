/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.time.LocalDateTime;
import java.time.Month;
import model.Candidature;
import model.Personne;
import model.SessionFormation;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Kiiaroto
 */
public class CandidatureDaoTest extends DaoTestCase {
    
    public CandidatureDaoTest() {
    }


    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        Candidature candidature = new Candidature(
                new Personne(22, "Lowery", "Mira", "mi.enim@eget.ca", "0623765886", "7126 Cras Rd.", "16920", "Çaldıran", "Etiam", false, false), 
                new SessionFormation(4, 2, "nom",LocalDateTime.of(2018, Month.SEPTEMBER, 3, 10, 0), LocalDateTime.of(2020, Month.MARCH, 3, 10, 0), true), 
                7,
                LocalDateTime.now());
        CandidatureDao instance = new CandidatureDao();
        instance.updateByCandidature(candidature);
        fail("The test case is a prototype.");
    }
    
}
