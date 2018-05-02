/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Objects;

/**
 *
 * @author tonyd_wl3
 */
public class Presence {
    private int idSeance;
    private Personne personne;
    private boolean estPresent;

    public Presence() {
        
    }

    public Presence(int idSeance, Personne personne, boolean estPresent) {
        this.idSeance = idSeance;
        this.personne = personne;
        this.estPresent = estPresent;
    }

    public int getIdSeance() {
        return idSeance;
    }

    public void setIdSeance(int idSeance) {
        this.idSeance = idSeance;
    }

    public Personne getPersonne() {
        return personne;
    }

    public void setPersonne(Personne personne) {
        this.personne = personne;
    }

    public boolean isEstPresent() {
        return estPresent;
    }

    public void setEstPresent(boolean estPresent) {
        this.estPresent = estPresent;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + this.idSeance;
        hash = 11 * hash + Objects.hashCode(this.personne);
        hash = 11 * hash + (this.estPresent ? 1 : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Presence other = (Presence) obj;
        if (this.idSeance != other.idSeance) {
            return false;
        }
        if (!Objects.equals(this.personne, other.personne)) {
            return false;
        }
        if (this.estPresent != other.estPresent) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Presence{" + "idSeance=" + idSeance + ", personne=" + personne + ", estPresent=" + estPresent + '}';
    }
    
}