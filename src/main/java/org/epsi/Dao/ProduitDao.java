package org.epsi.Dao;

import org.epsi.Bean.Produit;

import java.util.List;

public interface ProduitDao {

    public List<Produit> listProduits();

    public Produit getP(String codeProduit);

    public boolean saveP(Produit produit);

    public boolean updateP(Produit produit);

    public boolean deleteP(Produit produit);
}

