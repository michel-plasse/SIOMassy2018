
package model;

import java.time.LocalDateTime;

/**
 *
 * @author SANOGO
 */
public class Echange {
    private int idEchange;
    private int idPersonne;
    private String typeEchange;
    private LocalDateTime instant;
    private String  texte;
    

    public Echange(int idEchange, int idPersonne, String typeEchange, LocalDateTime instant, String texte) {
        this.idEchange = idEchange;
        this.idPersonne = idPersonne;
        this.typeEchange = typeEchange;
        this.instant = instant;
        this.texte = texte;
    }

    public int getIdEchange() {
        return idEchange;
    }

    public void setIdEchange(int idEchange) {
        this.idEchange = idEchange;
    }

    public int getIdPersonne() {
        return idPersonne;
    }

    public void setIdPersonne(int idPersonne) {
        this.idPersonne = idPersonne;
    }

    public String getTypeEchange() {
        return typeEchange;
    }

    public void setTypeEchange(String typeEchange) {
        this.typeEchange = typeEchange;
    }

    public LocalDateTime getInstant() {
        return instant;
    }

    public void setInstant(LocalDateTime instant) {
        this.instant = instant;
    }

    public String getTexte() {
        return texte;
    }

    public void setTexte(String texte) {
        this.texte = texte;
    }
    public String getDateTimeToString(){
        return instant.toString().substring(0, 10) + " " + instant.toString().substring(11);
    }
  
}
