/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.HibernateUtil;
import model.MascotaVacuna;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author usuario
 */
public class MascotaVacunaController {
    //CRUD para MascotaVacuna
    public void addGrupoUsuario(MascotaVacuna mascotaVacuna) {
        Transaction tx = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        try {
            tx = session.beginTransaction();
            session.save(mascotaVacuna);
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
    
    public void deleteMascotaVacuna (int idMascotaVacuna) {
        
    }
    
    public void updateMascotaVacuna (MascotaVacuna mascotaVacuna) {
        
    }
    
    public MascotaVacuna getMascotaVacunaByID (int idMascotaVacuna) {
        return null;
    }
}
