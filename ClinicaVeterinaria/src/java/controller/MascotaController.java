/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.HibernateUtil;
import model.Mascota;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author usuario
 */
public class MascotaController {
    
    //CRUD para Mascota
    public void addMascota(Mascota mascota) {
        Transaction tx = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        try {
            tx = session.beginTransaction();
            session.save(mascota);
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
    
    public void deleteMascota (int idMascota) {
        
    }
    
    public void updateMascota (Mascota mascota) {
        
    }
    
    //buscar mascota por su ID
    public Mascota getMascotaByID (int idMascota) {
        Mascota mascota = null;
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            String queryString = "from mascota where id_mascota = :idToFind";
            Query query = session.createQuery(queryString);
            query.setInteger("idToFind", idMascota);
            mascota = (Mascota) query.uniqueResult();
        } catch (RuntimeException e){
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }       

        return mascota;
    }
}
