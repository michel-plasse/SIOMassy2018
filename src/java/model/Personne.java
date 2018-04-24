package model;

import java.util.Objects;

public class Personne {

  private int id;
  private String nom;
  private String prenom;
  private String mail;
  private String tel;
  private String adresse;
  private String codePostal;
  private String ville;
  private String motDePasse;
  private boolean estAdministration;
  private boolean estFormateur;

  public Personne() {

  }

  public Personne(int idPersonne, String nom, String prenom, String mail, String tel, String adresse, String codePostal, String ville, String motDePasse, boolean estAdministration, boolean estFormateur) {
    super();
    this.id = idPersonne;
    this.nom = nom;
    this.prenom = prenom;
    this.mail = mail;
    this.tel = tel;
    this.adresse = adresse;
    this.codePostal = codePostal;
    this.ville = ville;
    this.motDePasse = motDePasse;
    this.estAdministration = estAdministration;
    this.estFormateur = estFormateur;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getNom() {
    return nom;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }

  public String getPrenom() {
    return prenom;
  }

  public void setPrenom(String prenom) {
    this.prenom = prenom;
  }

  public String getMail() {
    return mail;
  }

  public void setMail(String mail) {
    this.mail = mail;
  }

  public String getTel() {
    return tel;
  }

  public void setTel(String tel) {
    this.tel = tel;
  }

  public String getAdresse() {
    return adresse;
  }

  public void setAdresse(String adresse) {
    this.adresse = adresse;
  }

  public String getCodePostal() {
    return codePostal;
  }

  public void setCodePostal(String codePostal) {
    this.codePostal = codePostal;
  }

  public String getVille() {
    return ville;
  }

  public void setVille(String ville) {
    this.ville = ville;
  }

  public String getMotDePasse() {
    return motDePasse;
  }

  public void setMotDePasse(String motDePasse) {
    this.motDePasse = motDePasse;
  }

  public boolean isEstAdministration() {
    return estAdministration;
  }

  public void setEstAdministration(boolean estAdministration) {
    this.estAdministration = estAdministration;
  }

  public boolean isEstFormateur() {
    return estFormateur;
  }

  public void setEstFormateur(boolean estFormateur) {
    this.estFormateur = estFormateur;
  }

  @Override
  public int hashCode() {
    int hash = 3;
    hash = 79 * hash + this.id;
    hash = 79 * hash + Objects.hashCode(this.nom);
    hash = 79 * hash + Objects.hashCode(this.prenom);
    hash = 79 * hash + Objects.hashCode(this.mail);
    hash = 79 * hash + Objects.hashCode(this.tel);
    hash = 79 * hash + Objects.hashCode(this.adresse);
    hash = 79 * hash + Objects.hashCode(this.codePostal);
    hash = 79 * hash + Objects.hashCode(this.ville);
    hash = 79 * hash + Objects.hashCode(this.motDePasse);
    hash = 79 * hash + (this.estAdministration ? 1 : 0);
    hash = 79 * hash + (this.estFormateur ? 1 : 0);
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
    final Personne other = (Personne) obj;
    if (this.id != other.id) {
      return false;
    }
    if (this.estAdministration != other.estAdministration) {
      return false;
    }
    if (this.estFormateur != other.estFormateur) {
      return false;
    }
    if (!Objects.equals(this.nom, other.nom)) {
      return false;
    }
    if (!Objects.equals(this.prenom, other.prenom)) {
      return false;
    }
    if (!Objects.equals(this.mail, other.mail)) {
      return false;
    }
    if (!Objects.equals(this.tel, other.tel)) {
      return false;
    }
    if (!Objects.equals(this.adresse, other.adresse)) {
      return false;
    }
    if (!Objects.equals(this.codePostal, other.codePostal)) {
      return false;
    }
    if (!Objects.equals(this.ville, other.ville)) {
      return false;
    }
    if (!Objects.equals(this.motDePasse, other.motDePasse)) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "Personne{" + "id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", mail=" + mail + ", tel=" + tel + ", adresse=" + adresse + ", codePostal=" + codePostal + ", ville=" + ville + ", motDePasse=" + motDePasse + ", estAdministration=" + estAdministration + ", estFormateur=" + estFormateur + '}';
  }
  
}
