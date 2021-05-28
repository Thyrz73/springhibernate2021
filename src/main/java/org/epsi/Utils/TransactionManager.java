package org.epsi.Utils;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
// Il faut activer le TransactionManager /
@EnableTransactionManagement
public class TransactionManager {

    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan("org.epsi");
        sessionFactory.setHibernateProperties(hibernateProperties());

        return sessionFactory;
    }

    @Bean // Connexion a la BDD
    public DataSource dataSource() {

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        //dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        //dataSource.setUrl("jdbc:mysql://localhost:3306/hibernate?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false& serverTimezone=UTC");
        dataSource.setDriverClassName("org.h2.Driver");
        dataSource.setUrl("jdbc:h2:mem:db;DB_CLOSE_DELAY=-1");
        dataSource.setUsername("root");
        dataSource.setPassword("");

        return dataSource;
    }

    @Bean
    public PlatformTransactionManager txManager() {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory().getObject());
        return transactionManager;
    }

    /* Comportement de hibernate pour la BDD */
    private Properties hibernateProperties() {
        Properties hibernateProperties = new Properties();
        hibernateProperties.setProperty(
                //"hibernate.hbm2ddl.auto", "create-drop");
                "hibernate.hbm2ddl.auto", "update");
        hibernateProperties.setProperty(
                //"hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
                  "hibernate.dialect", "org.hibernate.dialect.H2Dialect"); // pour correction

        // Bind one session per request : configures SessionFactory.useCurrentSession()
        hibernateProperties.setProperty(
                "hibernate.current_session_context_class", "thread");

        // Disable the second-level cache
        hibernateProperties.setProperty(
                "cache.provider_class", "org.hibernate.cache.internal.NoCachingRegionFactory");

        return hibernateProperties;
    }



    /* Transactions */
    /*
    @Override
    @Transactional
    public void createP(Produit produit) {
        String queryProduit = "insert into produit (codeProduit, nom, quantite, datePeremption) values (?,?,?,?)";

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.update(queryProduit, new Object[] { produit.getCodeProduit(),
                produit.getNom(), produit.getQuantite(), produit.getDatePeremption() });
    }

    @Override
    @Transactional
    public void delete(String cd) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Transaction tx =session.beginTransaction();
        List<Produit> produitList = (List<Produit>) session.createQuery("from Produit ").list();


        for (Produit p : produitList) {
            if(p.getCodeProduit().equals(cd)){
                String queryProduit = "delete from Produit where codeProduit = " + cd;

                //JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
                //jdbcTemplate.execute(queryProduit);
                int deletedEntities = session.createQuery( queryProduit )
                        .executeUpdate();
                tx.commit();
                break;
            }
        }
    }

    @Override
    public void modificate( Produit produit, String cd, String nom, int quantite, String date) {
        String queryProduit = "update produit set nom = "+ nom + " , quantite = "+ quantite +", datePeremption = "+ date + " where codeProduit = "+ cd;


        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.update(queryProduit, new Object[] { produit.getCodeProduit(),
                produit.getNom(), produit.getQuantite(), produit.getDatePeremption() });
    }

    @SuppressWarnings("unchecked")
    @Override
    @Transactional
    public List<Produit> listProduit() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        session.beginTransaction();
        List<Produit> produitList = (List<Produit>) session.createQuery("from Produit ").list();
        session.getTransaction().commit();
        return produitList;
    }

    @Override
    public void createU(Utilisateur utilisateur) {
        String queryProduit = "insert into utilisateur (nom, prenom, adresse, email, motDePasse) values (?,?,?,?,?)";

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.update(queryProduit, new Object[] { utilisateur.getNom(),
                utilisateur.getPrenom(), utilisateur.getAdresse(), utilisateur.getEmail(), utilisateur.getMotDePasse() });
    }
    */

}
