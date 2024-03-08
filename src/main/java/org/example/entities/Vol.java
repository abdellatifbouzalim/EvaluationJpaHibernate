package org.example.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Entity
public class Vol {

    @Id
    private String NV; // numéro de vol

    private String VD; // ville de départ
    private String VA; // ville d'arrivée
    private LocalDateTime HD; // heure de départ
    private LocalDateTime HA; // heure d'arrivée

    @ManyToOne
    private Pilote pilote;

    @ManyToOne
    private Avion avion;

    public String getNV() {
        return NV;
    }

    public void setNV(String NV) {
        this.NV = NV;
    }

    public String getVD() {
        return VD;
    }

    public void setVD(String VD) {
        this.VD = VD;
    }

    public String getVA() {
        return VA;
    }

    public void setVA(String VA) {
        this.VA = VA;
    }

    public LocalDateTime getHD() {
        return HD;
    }

    public void setHD(LocalDateTime HD) {
        this.HD = HD;
    }

    public LocalDateTime getHA() {
        return HA;
    }

    public void setHA(LocalDateTime HA) {
        this.HA = HA;
    }

    public Pilote getPilote() {
        return pilote;
    }

    public void setPilote(Pilote pilote) {
        this.pilote = pilote;
    }

    public Avion getAvion() {
        return avion;
    }

    public void setAvion(Avion avion) {
        this.avion = avion;
    }
}
