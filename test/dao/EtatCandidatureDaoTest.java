/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.EtatCandidature;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Kiiaroto
 */
public class EtatCandidatureDaoTest {
    
    public EtatCandidatureDaoTest() {
    }

    @Test
    public void testSelect() throws Exception {
        System.out.println("select");
        EtatCandidatureDao instance = new EtatCandidatureDao();
        instance.select();
        assertEquals(7, EtatCandidature.getValues().size());
    }
    
}
