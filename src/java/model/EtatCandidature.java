/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Kiiaroto
 */
public class EtatCandidature {

    private static Map<Integer, String> values;

    public EtatCandidature() {
    }

    public static Map<Integer, String> getValues() {
        return values;
    }

    static {
        values = new HashMap<Integer, String>();
    }
}