package model;

import java.time.LocalDateTime;
import java.util.Objects;

public class SessionFormation {

    private int idSession;
    private int idFormation;
    private String nomFormation;
    private LocalDateTime dateDebut;
    private LocalDateTime dateFin;
    private boolean estOuverte;

    public int getIdSession() {
        return idSession;
    }

    public void setIdSession(int idSession) {
        this.idSession = idSession;
    }

    public String getNomFormation() {
        return nomFormation;
    }

    public void setNomFormation(String nomFormation) {
        this.nomFormation = nomFormation;
    }

    public int getIdFormation() {
        return idFormation;
    }

    public void setIdFormation(int idFormation) {
        this.idFormation = idFormation;
    }

    public LocalDateTime getDateDebut() {
        return dateDebut;
    }

    public String getDateDebutToString() {
        return String.valueOf(dateDebut.getDayOfMonth()) + "/" + String.valueOf(dateDebut.getMonthValue()) + "/" + String.valueOf(dateDebut.getYear());
    }

    public void setDateDebut(LocalDateTime dateDebut) {
        this.dateDebut = dateDebut;
    }

    public LocalDateTime getDateFin() {
        return dateFin;
    }

    public String getDateFinToString() {
        return String.valueOf(dateFin.getDayOfMonth()) + "/" + String.valueOf(dateFin.getMonthValue()) + "/" + String.valueOf(dateFin.getYear());
    }

    public void setDateFin(LocalDateTime dateFin) {
        this.dateFin = dateFin;
    }

    public boolean getEstOuverte() {
        return estOuverte;
    }

    public void setEstOuverte(boolean estOuverte) {
        this.estOuverte = estOuverte;
    }

    @Override
    public String toString() {
        return "SessionFormation{" + "idSession=" + idSession + ", idFormation=" + idFormation + ", nomFormation=" + nomFormation + ", dateDebut=" + dateDebut + ", dateFin=" + dateFin + ", estOuverte=" + estOuverte + '}';
    }

    public SessionFormation(int idSession, int idFormation, String nomFormation, LocalDateTime dateDebut, LocalDateTime dateFin, boolean estOuverte) {
        this.idSession = idSession;
        this.idFormation = idFormation;
        this.nomFormation = nomFormation;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.estOuverte = estOuverte;
    }

    public SessionFormation() {
        // TODO Auto-generated constructor stub
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.idSession;
        hash = 37 * hash + this.idFormation;
        hash = 37 * hash + Objects.hashCode(this.nomFormation);
        hash = 37 * hash + Objects.hashCode(this.dateDebut);
        hash = 37 * hash + Objects.hashCode(this.dateFin);
        hash = 37 * hash + (this.estOuverte ? 1 : 0);
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
        final SessionFormation other = (SessionFormation) obj;
        if (this.idSession != other.idSession) {
            return false;
        }
        if (this.idFormation != other.idFormation) {
            return false;
        }
        if (this.estOuverte != other.estOuverte) {
            return false;
        }
        if (!Objects.equals(this.nomFormation, other.nomFormation)) {
            return false;
        }
        if (!Objects.equals(this.dateDebut, other.dateDebut)) {
            return false;
        }
        if (!Objects.equals(this.dateFin, other.dateFin)) {
            return false;
        }
        return true;
    }

}
