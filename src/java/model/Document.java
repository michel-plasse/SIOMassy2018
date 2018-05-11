/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.time.LocalDateTime;

/**
 *
 * @author YohanMA
 */

public class Document {
    private int id;
    private int idProprietaire;
    private String nom;
    private String chemin;
    private LocalDateTime dateDepot;

    public Document(int id, int idProprietaire, String nom, LocalDateTime dateDepot) {
        this.id = id;
        this.idProprietaire = idProprietaire;
        this.nom = nom;
        this.chemin = "/agriotes2018/documents/" + nom;
        this.dateDepot = dateDepot;
    }

    public int getId() {
        return id;
    }

    public int getIdProprietaire() {
        return idProprietaire;
    }

    public String getNom() {
        return nom;
    }

    public String getChemin() {
        return chemin;
    }

    public String getDateDepot() {
        String day = String.valueOf(dateDepot.getDayOfMonth());
        String month = String.valueOf(dateDepot.getMonthValue());
        String year = String.valueOf(dateDepot.getYear());
        String hour = String.valueOf(dateDepot.getHour());
        String minute = String.valueOf(dateDepot.getMinute());
        String second = String.valueOf(dateDepot.getSecond());
        
        return day + "/" + month + "/" + year + " - " + hour + ":" + minute + ":" + second;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIdProprietaire(int idProprietaire) {
        this.idProprietaire = idProprietaire;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setChemin(String chemin) {
        this.chemin = chemin;
    }

    public void setDateDepot(LocalDateTime dateDepot) {
        this.dateDepot = dateDepot;
    }

}