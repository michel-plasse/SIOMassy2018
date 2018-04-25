/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 *
 * @author YohanMA
 */

public class Document {
    private int id;
    private int id_proprietaire;
    private String nom;
    private String chemin;
    private LocalDateTime date_depot;

    public Document(int id, int id_proprietaire, String nom, String chemin, LocalDateTime date_depot) {
        this.id = id;
        this.id_proprietaire = id_proprietaire;
        this.nom = nom;
        this.chemin = chemin;
        this.date_depot = date_depot;
    }

    public int getId() {
        return id;
    }

    public int getId_proprietaire() {
        return id_proprietaire;
    }

    public String getNom() {
        return nom;
    }

    public String getChemin() {
        return chemin;
    }

    public LocalDateTime getDate_depot() {
        return date_depot;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setId_proprietaire(int id_proprietaire) {
        this.id_proprietaire = id_proprietaire;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setChemin(String chemin) {
        this.chemin = chemin;
    }

    public void setDate_depot(LocalDateTime date_depot) {
        this.date_depot = date_depot;
    }

}
