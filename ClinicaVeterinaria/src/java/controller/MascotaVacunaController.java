/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.HibernateUtil;
import model.MascotaVacuna;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author usuario
 */
public class MascotaVacunaController {
    //CRUD para MascotaVacuna
    public void addMascotaVacuna(MascotaVacuna mascotaVacuna) {
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
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            //Para borrar un registro se debe crear una instancia con el id a eliminar,
            MascotaVacuna mascotaVacuna = (MascotaVacuna) session.load(MascotaVacuna.class, new Integer(idMascotaVacuna));
            //despues invocar el metodo delete con el objeto que tiene el id en cuestion
            session.delete(mascotaVacuna);
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
    
    public void updateMascotaVacuna (MascotaVacuna mascotaVacuna) {
        
    }
    
    //buscar mascotaVacuna por su ID
    public MascotaVacuna getMascotaVacunaByID (int id) {
        MascotaVacuna mascotaVacuna = null;
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            //aca ver como poner porque tiene dos claves, falta id_vacuna
            String queryString = "from mascota_vacuna where id_mascota = :idToFind";
            Query query = session.createQuery(queryString);
            query.setInteger("idToFind", id);
            mascotaVacuna = (MascotaVacuna) query.uniqueResult();
        } catch (RuntimeException e){
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }       

        return mascotaVacuna;
    }
}
