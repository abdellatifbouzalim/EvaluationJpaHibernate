package org.example.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Avion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int NA; // numéro avion
    private String nom;
    private int capacite;
    private String localite;


    public int getNA() {
        return NA;
    }

    public void setNA(int NA) {
        this.NA = NA;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getCapacite() {
        return capacite;
    }

    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }

    public String getLocalite() {
        return localite;
    }

    public void setLocalite(String localite) {
        this.localite = localite;
    }
}
