/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.HibernateUtil;
import model.MedicoVeterinario;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author usuario
 */
public class MedicoVeterinarioController {
    //CRUD para MedicoVeterinario
    public void addMedicoVeterinario(MedicoVeterinario medicoVeterinario) {
        Transaction tx = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        try {
            tx = session.beginTransaction();
            session.save(medicoVeterinario);
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
    
    public void deleteMedicoVeterinario (int idMedicoVeterinario) {
        
    }
    
    public void updateMedicoVeterinario (MedicoVeterinario medicoVeterinario) {
        
    }
    
    public MedicoVeterinario getMedicoVeterinarioByID (int idMedicoVeterinario) {
        return null;
    }
}
