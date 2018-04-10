/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.time.LocalDateTime;

/**
 *
 * @author Ferha
 */
public class Evaluation {
    private int idEvaluation;
    private int idModule;
    private int idSessionFormation;
    private int idFormateur;
    private LocalDateTime dateDebut;
    private int nbMinutes;
    private String titre;

    public Evaluation(int idEvaluation, int idModule, int idSessionFormation,
            int idFormateur, LocalDateTime dateDebut, int nbMinutes, String titre) {
        this.idEvaluation = idEvaluation;
        this.idModule = idModule;
        this.idSessionFormation = idSessionFormation;
        this.idFormateur = idFormateur;
        this.dateDebut = dateDebut;
        this.nbMinutes = nbMinutes;
        this.titre = titre;
    }

    public Evaluation(int aInt, int aInt0, int aInt1, int aInt2, LocalDateTime toLocalDateTime) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getIdEvaluation() {
        return idEvaluation;
    }

    public void setIdEvaluation(int idEvaluation) {
        this.idEvaluation = idEvaluation;
    }

    public int getIdModule() {
        return idModule;
    }

    public void setIdModule(int idModule) {
        this.idModule = idModule;
    }

    public int getIdSessionFormation() {
        return idSessionFormation;
    }

    public void setIdSessionFormation(int idSessionFormation) {
        this.idSessionFormation = idSessionFormation;
    }

    public int getIdFormateur() {
        return idFormateur;
    }

    public void setIdFormateur(int idFormateur) {
        this.idFormateur = idFormateur;
    }

    public LocalDateTime getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(LocalDateTime dateDebut) {
        this.dateDebut = dateDebut;
    }

    public int getNbMinutes() {
        return nbMinutes;
    }

    public void setNbMinutes(int nbMinutes) {
        this.nbMinutes = nbMinutes;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

   
   
   
    

    
    
    
}
