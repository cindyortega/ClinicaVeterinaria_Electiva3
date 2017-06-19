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
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            //Para borrar un registro se debe crear una instancia con el id a eliminar,
            Vacuna vacuna = (Vacuna) session.load(Vacuna.class, new Integer(idVacuna));
            //despues invocar el metodo delete con el objeto que tiene el id en cuestion
            session.delete(vacuna);
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
