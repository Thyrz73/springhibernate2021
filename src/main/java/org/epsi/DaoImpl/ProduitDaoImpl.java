package org.epsi.DaoImpl;

import org.epsi.Bean.Produit;
import org.epsi.Dao.ProduitDao;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
        String hql = "from Produit ";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        return query.list();
    }

    @Override
    public Produit getP(String codeProduit) {
        return (Produit) sessionFactory.getCurrentSession().get(Produit.class, codeProduit);
    }

    @Override
    public boolean saveP(Produit produit) {
        try {
            sessionFactory.getCurrentSession().save(produit);
        } catch (Exception e) {
            e.printStackTrace();
        }
            return false;
    }

    @Override
    public boolean updateP(Produit produit) {
        try {
            sessionFactory.getCurrentSession().update(produit);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteP(Produit produit) {
        try {
            sessionFactory.getCurrentSession().delete(produit);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
