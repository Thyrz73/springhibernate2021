package org.epsi.DaoImpl;

import org.epsi.Bean.Utilisateur;
import org.epsi.Dao.UtilisateurDao;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

// Pour pouvoir utiliser l'injection de dépendances, la classe doit être un @Component !
@Component
public class UtilisateurDaoImpl implements UtilisateurDao {
    @Autowired
    UtilisateurDao utilisateurDao; // Ce champ n'est pas utilisé...

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
        // Il est inutile de caster le retour vers Utilisateur : la méthode get() récupère déjà
        // le type de retour dans le générique T de son premier argument : Class<T>.
        // L'utilisation du générique est à préférer car le compilateur va réaliser une vérification
        // statique de type à la compilation. Lors de l'utilisation d'un cast, les problèmes
        // de type ne seront détectés qu'à l'exécution du code.
        return (Utilisateur) sessionFactory.getCurrentSession().get(Utilisateur.class, nom);
    }

    @Transactional
    public  Utilisateur valider(String email, String motDePasse) {
        // 1. Attention : on ne stock jamais un mot de passe en BDD, toujours un hash !
        // 2. L'utilisation directe d'une requête de type SQL telle que réalisée ici est possible,
        //    on aurait également pu préparer un bean Utilisateur contenant les informations de requête
        //    et demander à Hibernate de compléter l'objet.
        String hql = "from Utilisateur WHERE email ='" + email + "' and motDePasse='" + motDePasse + "'";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);

        // Point de détail : Hibernate possède maintenant une méthode uniqueResultOptional().
        // L'usage d'un Optional est à privilégier car cela permet de distinguer
        // un cas métier "pas d'utilisateur touvé" -> return Optional.empty()
        // d'une erreur technique ou d'un bug : -> return null
        // D'une manière générale, on évite toujours au maximum d'utiliser des NullPointer
        // en langage objet.
        return (Utilisateur) query.uniqueResult();
    }

    @Transactional
    public boolean save(Utilisateur utilisateur) {
        try {
            sessionFactory.getCurrentSession().save(utilisateur);
        } catch (Exception e) {
            // 1. D'une manière générale (sauf exception, par exemple avant envoi du résultat final au client),
            // ne JAMAIS faire de bloc catch sur "Exception".
            // En Java, les Exception sont fortement typées et le catch permet de récupérer seulement celles
            // qui nous intéressent. Cela permet de changer le comportement métier / technique en fonction des
            // erreurs reçues.
            // 2. Il existe 2 types d'Exception en Java :
            //    - les "Checked Exception" qui représentent généralement des erreurs en dehors du programme
            //      (I/O sur un fichier, requête SQL ou HTTP invalide, ...). Ces exceptions sont décrites explicitement
            //      dans le protocole des méthodes qui les lèvent, et doivent être traîtées explicitement par les appelants
            //    - les "Unchecked Exception" (héritées de RuntimeException) sont des exceptions généralement liées au
            //      programme lui-même (NullPointerException, IllegalArgumentException, ...). Ces exceptions ne sont pas
            //      toujours décrites dans le protocole de la méthode qui les lévent, et certaines sont générées par le
            //      langage lui-même.
            // On évitera globalement toujours de masquer une exception, sauf lors du passage d'une couche technique à
            // une autre (par exemple, de la BDD au Backend ici) où il peut en effet être PARFOIS utile de masquer des
            // exceptions pour éviter de polluer les couches supérieures. Dans ce cas, il est préférable de masquer le
            // minimum d'exceptions pour éviter d'englober dans la logique actuelle un comportement d'une future exception
            // qui n'existe pas encore dans la couche inférieure et dont le traitement devrait être différent.
            // Ici, la méthode save() ne décrit pas de "Checked Exception", on pourrait donc par exemple masquer
            // uniquement les RuntimeException

            // Code de dev uniquement -> en production, on utilisera toujours un logger (sinon la trace est perdue !)
            // Il est également discutable de masquer l'exception : le code métier reste le même (cette méthode retourne
            // true ou false pour savoir si une exception a été reçue), mais le contexte technique de l'exception est
            // perdu.
            // Les exceptions sont l'une des fonctionnalités les plus puissantes de Java, car elles permettent de
            // corréler les problèmes techniques et le métier. On pourrait par exemple créer une exception personnalisée
            // PersistenceException qui retourne l'exception technique reçue, et y ajoute l'utilisateur en question :
            // throw new PersistenceException("Cannot save user : " + utilisateur, e);
            // Cela créera une stack (ou un log si intercepté dans les couches supérieures) de la forme :
            //         UtilisateurDaoImpl.save l.88 : Cannot save user : Utilisateur(.....)
            //    caused by : {exception initiale}
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
