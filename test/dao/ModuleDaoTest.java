/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.Map;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tchju
 */
public class ModuleDaoTest {
    
    public ModuleDaoTest() {
    }

    @Test
    public void testGetAll() throws Exception {
        System.out.println("getAll");
        ModuleDao instance = new ModuleDao();
        Map<Integer, String> expResult = null;
        Map<Integer, String> result = instance.getAll();
        assertEquals(expResult, result);
    }
    
}
