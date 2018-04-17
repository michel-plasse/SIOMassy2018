/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Ferha
 */
public class Note {
    
    Personne personne = new Personne();
    private int idEvaluation;
    private int idPersonne;
    private double  note;

    public Note(int idEvaluation, int idPersonne, double note) {
        this.idEvaluation = idEvaluation;
        this.idPersonne = idPersonne;
        this.note = note;
    }

    public Personne getPersonne() {
        return personne;
    }

    public void setPersonne(Personne personne) {
        this.personne = personne;
    }

    public int getIdEvaluation() {
        return idEvaluation;
    }

    public void setIdEvaluation(int idEvaluation) {
        this.idEvaluation = idEvaluation;
    }

    public int getIdPersonne() {
        return idPersonne;
    }

    public void setIdPersonne(int idPersonne) {
        this.idPersonne = idPersonne;
    }

    public double getNote() {
        return note;
    }

    public void setNote(double note) {
        this.note = note;
    }

   
    

   
    
    
    
    
}
