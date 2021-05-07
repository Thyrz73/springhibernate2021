import org.epsi.Utils.Application;
import org.epsi.Bean.Produit;
import org.epsi.Bean.Utilisateur;
import org.epsi.Dao.ProduitDao;
import org.epsi.Dao.UtilisateurDao;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;


public class Main {
    public static void main(String [] args){

            SpringApplication.run(Application.class, args);

            ApplicationContext appContext = new AnnotationConfigApplicationContext("org.epsi");

            ProduitDao produitDao = appContext.getBean(ProduitDao.class);
            UtilisateurDao utilisateurDao = appContext.getBean(UtilisateurDao.class);

            //creation d'un nouveau Produit
            Produit produit = new Produit();
            produit.setNom("sucre"); produit.setCodeProduit("666hgt892"); produit.setQuantite(12); produit.setDatePeremption("2021/10/22");


            // creation d'un nouveau Produit
            Produit produit1 = new Produit();
            produit1.setNom("sel"); produit1.setCodeProduit("777gth953"); produit1.setQuantite(18); produit1.setDatePeremption("2020/05/10");


            // creation d'un nouveau Produit
            Produit produit2 = new Produit();
            produit2.setNom("poivre"); produit2.setCodeProduit("888juk621"); produit2.setQuantite(25); produit2.setDatePeremption("2020/02/12");

            //Creation des produits dans la BDD
            produitDao.saveP(produit);
            produitDao.saveP(produit1);
            produitDao.saveP(produit2);

            // Mise à jour d'un produit
            produit.setNom("sucre roux");
            produitDao.updateP(produit);

            // Suppression d'un produit
            produitDao.deleteP(produit2);

           // Listing des produits
            List<Produit> ListP = produitDao.listProduits();
            for (Produit p : ListP){
                    System.out.println("Liste de Produits :: " + p.toString());
            }
            // Création d'un compte utilisateur
            Utilisateur utilisateur = new Utilisateur();
            utilisateur.setNom("Dupont"); utilisateur.setPrenom("Roger");
            utilisateur.setEmail("roger.dupont@hotmail.fr"); utilisateur.setAdresse("1 rue de la Paix");
            utilisateur.setMotDePasse("Roger38");

            //Création de l'utilisateur dans la BDD
            utilisateurDao.save(utilisateur);


        }
}
