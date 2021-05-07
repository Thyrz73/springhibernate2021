package org.epsi.DaoImpl;

import org.epsi.Bean.Utilisateur;
import org.epsi.Dao.UtilisateurDao;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class UtilisateurDaoImpl implements UtilisateurDao {
    @Autowired
    UtilisateurDao utilisateurDao;

    @Autowired
    private SessionFactory sessionFactory;
    public UtilisateurDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public UtilisateurDaoImpl() {
        // TODO Auto-generated constructor stub
    }


    @Transactional
    public Utilisateur get(String nom) {
        return (Utilisateur) sessionFactory.getCurrentSession().get(Utilisateur.class, nom);
    }

    @Transactional
    public  Utilisateur valider(String email, String motDePasse) {
        String hql = "from Utilisateur WHERE email ='" + email + "' and motDePasse='" + motDePasse + "'";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        return (Utilisateur) query.uniqueResult();
    }

    @Transactional
    public boolean save(Utilisateur utilisateur) {
        try {
            sessionFactory.getCurrentSession().save(utilisateur);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    @Transactional
    public boolean update(Utilisateur utilisateur) {
        try {
            sessionFactory.getCurrentSession().update(utilisateur);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

}
