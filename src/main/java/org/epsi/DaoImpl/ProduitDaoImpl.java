package org.epsi.DaoImpl;

import org.epsi.Bean.Produit;
import org.epsi.Dao.ProduitDao;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

// Pour pouvoir utiliser l'injection de dépendances, la classe doit être un @Component !
@Component
public class ProduitDaoImpl implements ProduitDao {
    @Autowired
    private SessionFactory sessionFactory;

    public ProduitDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public ProduitDaoImpl(){

    }

    @Override
    @Transactional
    public List<Produit> listProduits() {
        // Il est également possible d'utiliser les méthodes de Query d'hibernate utilisant
        // des beans pour récupérer une liste typée de Produit (ici, un cast est obligatoire
        // dans le return de List<Objet> vers List<Produit>)
        String hql = "from Produit ";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        return query.list();
    }

    // Toute transaction avec la BDD en Hibernate doit avoir lieu dans une transaction !
    @Transactional
    @Override
    public Produit getP(String codeProduit) {
        // voir UtilisateurDaoImpl
        return (Produit) sessionFactory.getCurrentSession().get(Produit.class, codeProduit);
    }

    // Toute transaction avec la BDD en Hibernate doit avoir lieu dans une transaction !
    @Transactional
    @Override
    public boolean saveP(Produit produit) {
        try {
            sessionFactory.getCurrentSession().save(produit);
        } catch (Exception e) {
            // voir UtilisateurDaoImpl
            e.printStackTrace();
        }
            return false;
    }

    // Toute transaction avec la BDD en Hibernate doit avoir lieu dans une transaction !
    @Transactional
    @Override
    public boolean updateP(Produit produit) {
        try {
            sessionFactory.getCurrentSession().update(produit);
        } catch (Exception e) {
            // voir UtilisateurDaoImpl
            e.printStackTrace();
            return false;
        }
        return true;
    }

    // Toute transaction avec la BDD en Hibernate doit avoir lieu dans une transaction !
    @Transactional
    @Override
    public boolean deleteP(Produit produit) {
        try {
            sessionFactory.getCurrentSession().delete(produit);
        } catch (Exception e) {
            // voir UtilisateurDaoImpl
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
