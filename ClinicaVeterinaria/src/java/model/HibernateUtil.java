
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author usuario
 */
public class HibernateUtil {

    /**
     * private static final SessionFactory sessionFactory;
     *
     * static { try { // Create the SessionFactory from standard
     * (hibernate.cfg.xml) // config file. //asi estaba la linea de abajo:
     * sessionFactory = new
     * AnnotationConfiguration().configure("/<default package>/hibernate.cfg.xml").buildSessionFactory();
     * sessionFactory = new
     * AnnotationConfiguration().configure().buildSessionFactory(); } catch
     * (Throwable ex) { // Log the exception. System.err.println("Initial
     * SessionFactory creation failed." + ex); throw new
     * ExceptionInInitializerError(ex); } }
     *
     * public static SessionFactory getSessionFactory() { return sessionFactory;
    }
     */
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) { // loads configuration and mappings 
            //el configure estaba vacio asi configure()
            Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();

            // builds a session factory from the service registry sessionFactory =
            configuration.buildSessionFactory(serviceRegistry);
        }

        return sessionFactory;
    }
}
