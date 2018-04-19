/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Kiiaroto
 */
public class Candidature {

    private Personne personne;
    private SessionFormation sessionFormation;
    private int etatCandidature;
    private LocalDateTime dateEffet;

    public Personne getPersonne() {
        return personne;
    }

    public void setPersonne(Personne personne) {
        this.personne = personne;
    }

    public SessionFormation getSessionFormation() {
        return sessionFormation;
    }

    public void setSessionFormation(SessionFormation sessionFormation) {
        this.sessionFormation = sessionFormation;
    }

    public int getEtatCandidature() {
        return etatCandidature;
    }

    public void setDateEffet(LocalDateTime dateEffet) {
        this.dateEffet = dateEffet;
    }

    public LocalDateTime getDateEffet() {
        return dateEffet;
    }

    public String getDateEffetToString() {
        return String.valueOf(dateEffet.getDayOfMonth()) + "/" + String.valueOf(dateEffet.getMonthValue()) + "/" + String.valueOf(dateEffet.getYear());
    }

    public void setEtatCandidature(int etatCandidature) {
        this.etatCandidature = etatCandidature;
    }

    public Candidature(Personne personne, SessionFormation sessionFormation, int etatCandidature, LocalDateTime dateEffet) {
        this.personne = personne;
        this.sessionFormation = sessionFormation;
        this.etatCandidature = etatCandidature;
        this.dateEffet = dateEffet;
    }

    public Candidature() {
    }
}
