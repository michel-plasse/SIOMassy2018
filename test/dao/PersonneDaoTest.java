/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.Personne;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tchju
 */
public class PersonneDaoTest {
    @Test
    public void testInsert() throws Exception {
        System.out.println("insert");
        Personne personne = new Personne(1, "palete", "martin", "paleteM@yahoo.fr", "0145253698", "3 rue des aulnes", "93600", "aulney", "greta2017", false, false);
        PersonneDao instance = new PersonneDao();
        instance.insert(personne);
        
    }
    
    @Test
    public void testupdatePassword() throws Exception {
        System.out.println("update");
        String password = "Integer";
        int id = 19;
        PersonneDao instance = new PersonneDao();
        instance.updatePassword(password, id);
    }
    
    @Test
    public void testcheckPassword() throws Exception {
        System.out.println("check");
        String password = "Integer";
        int id = 19;
        PersonneDao instance = new PersonneDao();
        instance.checkPassword(password, id);
    }
    
}
