package org.epsi.Dao;

import org.epsi.Bean.Utilisateur;

public interface UtilisateurDao {


    public Utilisateur get(String nom);

    public Utilisateur valider(String email, String motDePasse);

    public boolean save(Utilisateur utilisateur);

    public boolean update(Utilisateur utilisateur);
}
