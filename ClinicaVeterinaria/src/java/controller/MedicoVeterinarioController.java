/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.HibernateUtil;
import model.MedicoVeterinario;
import org.hibernate.Query;
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
         Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            //Para borrar un registro se debe crear una instancia con el id a eliminar,
            MedicoVeterinario medicoVeterinario = (MedicoVeterinario) session.load(MedicoVeterinario.class, new Integer(idMedicoVeterinario));
            //despues invocar el metodo delete con el objeto que tiene el id en cuestion
            session.delete(medicoVeterinario);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null){
                trns.rollback();
            }
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
    }
    
    public void updateMedicoVeterinario (MedicoVeterinario medicoVeterinario) {
        
    }
    
    //Buscar medico por su ID
    public MedicoVeterinario getMedicoVeterinarioByID (int idMedicoVeterinario) {
        MedicoVeterinario medicoVeterinario = null;
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            String queryString = "from medico_veterinario where id_medico = :idToFind";
            Query query = session.createQuery(queryString);
            query.setInteger("idToFind", idMedicoVeterinario);
            medicoVeterinario = (MedicoVeterinario) query.uniqueResult();
        } catch (RuntimeException e){
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }       

        return medicoVeterinario;
    }
}
