/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.HibernateUtil;
import model.ProxVacuna;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author usuario
 */
public class ProxVacunaController {
    //CRUD para ProxVacuna
    public void addProxVacuna(ProxVacuna proxVacuna) {
        Transaction tx = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        try {
            tx = session.beginTransaction();
            session.save(proxVacuna);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            session.flush();
            session.close();
        }
    }
    
    public void deleteProxVacuna (int idProxVacuna) {
        
    }
    
    public void updateProxVacuna (ProxVacuna proxVacuna) {
        
    }
    
    //Buscar Prox vacuna por su ID
    public ProxVacuna getProxVacunaByID (int idProxVacuna) {
        ProxVacuna proxVacuna = null;
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            String queryString = "from prox_vacuna where id_prox_vacuna = :idToFind";
            Query query = session.createQuery(queryString);
            query.setInteger("idToFind", idProxVacuna);
            proxVacuna = (ProxVacuna) query.uniqueResult();
        } catch (RuntimeException e){
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }       

        return proxVacuna;
    }
}
