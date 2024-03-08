package org.example.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pilote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int NP; // numéro pilote

    private String nom;
    private String adresse;

    public int getNP() {
        return NP;
    }

    public void setNP(int NP) {
        this.NP = NP;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
}
