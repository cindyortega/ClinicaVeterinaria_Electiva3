/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.HibernateUtil;
import model.Vacuna;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author usuario
 */
public class VacunaController {
    //CRUD para Vacuna
    public void addVacuna(Vacuna vacuna) {
        Transaction tx = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        try {
            tx = session.beginTransaction();
            session.save(vacuna);
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
    
    public void deleteVacuna (int idVacuna) {
        
    }
    
    public void updateVacuna (Vacuna vacuna) {
        
    }
    
    //Buscar vacuna por su ID
    public Vacuna getVacunaByID (int idVacuna) {
        Vacuna vacuna = null;
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            String queryString = "from vacuna where id_vacuna = :idToFind";
            Query query = session.createQuery(queryString);
            query.setInteger("idToFind", idVacuna);
            vacuna = (Vacuna) query.uniqueResult();
        } catch (RuntimeException e){
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }       

        return vacuna;
    }
}
