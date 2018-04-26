/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import context.StaticInitializer;
import java.sql.SQLException;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;

/**
 *
 * @author Kiiaroto
 */
public class EtatCandidatureTest {
    
     @BeforeClass
     public static void doBeforeClass() throws SQLException {
         StaticInitializer.initializeStaticData();
     }
     
     @Test
     public void testMap() {
         assertEquals("accepté", EtatCandidature.getValues().get(5));
     }
}
