package org.epsi.Bean;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "produit")
public class Produit {

    //@Id
    //@Column(name = "reference")
    //@GeneratedValue(strategy = GenerationType.IDENTITY) // pour l'auto incrementation
    // Conflicts with the getter annotations => the generator is not started !
    private int reference;
    private String nom;
    private String codeProduit;
    private int quantite;
    private String datePeremption;


    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE) // pour l'auto incrementation
    public int getReference() {
        return reference;
    }

    public void setReference(int reference) {
        this.reference = reference;
    }

    @Basic(optional = false)
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Basic(optional = false)
    public String getCodeProduit() {
        return codeProduit;
    }

    public void setCodeProduit(String codeProduit) {
        this.codeProduit = codeProduit;
    }

    @Basic(optional = false)
    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    @Basic(optional = false)
    public String getDatePeremption() {
        return datePeremption;
    }

    public void setDatePeremption(String datePeremption) {
        this.datePeremption = datePeremption;
    }


    @Override
    public String toString() {
        return "reference : " + reference + " nom : " + nom + " code du Produit : " + codeProduit + " quantite : " + quantite + " date de peremption : " + datePeremption;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produit produit = (Produit) o;
        return reference == produit.reference;
    }

    @Override
    public int hashCode() {
        return Objects.hash(reference);
    }
}
