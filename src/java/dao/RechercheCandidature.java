/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import java.util.List;
import model.Candidature;

/**
 *
 * @author Kiiaroto
 */
public class RechercheCandidature {
    
    int idEtatCandidature;
    int IdSessionFormation;
    
    public void setTri(int IdSessionFormation, int idEtatCandidature) {
        this.idEtatCandidature = idEtatCandidature;
        this.idEtatCandidature = idEtatCandidature;
    }
    
    public List<Candidature> getResult() {
        List<Candidature> listeDesCandidatures = new ArrayList<>();
        
        
        return listeDesCandidatures;
    }
}
