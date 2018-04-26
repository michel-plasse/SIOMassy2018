/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.time.LocalDateTime;
import java.util.Objects;

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

    public Evaluation() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return "Evaluation{" + "idEvaluation=" + idEvaluation + ", idModule=" + idModule + ", idSessionFormation=" + idSessionFormation + ", idFormateur=" + idFormateur + ", dateDebut=" + dateDebut + ", nbMinutes=" + nbMinutes + ", titre=" + titre + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.idEvaluation;
        hash = 79 * hash + this.idModule;
        hash = 79 * hash + this.idSessionFormation;
        hash = 79 * hash + this.idFormateur;
        hash = 79 * hash + Objects.hashCode(this.dateDebut);
        hash = 79 * hash + this.nbMinutes;
        hash = 79 * hash + Objects.hashCode(this.titre);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Evaluation other = (Evaluation) obj;
        if (this.idEvaluation != other.idEvaluation) {
            return false;
        }
        if (this.idModule != other.idModule) {
            return false;
        }
        if (this.idSessionFormation != other.idSessionFormation) {
            return false;
        }
        if (this.idFormateur != other.idFormateur) {
            return false;
        }
        if (this.nbMinutes != other.nbMinutes) {
            return false;
        }
        if (!Objects.equals(this.titre, other.titre)) {
            return false;
        }
        if (!Objects.equals(this.dateDebut, other.dateDebut)) {
            return false;
        }
        return true;
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
