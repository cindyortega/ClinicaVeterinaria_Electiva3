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
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            //Para borrar un registro se debe crear una instancia con el id a eliminar,
            ProxVacuna proxVacuna = (ProxVacuna) session.load(ProxVacuna.class, new Integer(idProxVacuna));
            //despues invocar el metodo delete con el objeto que tiene el id en cuestion
            session.delete(proxVacuna);
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
    
    //Recibe el id del registro a modificar, y los nuevos datos del objeto.
    public void updateProxVacuna (int idProxVacuna, ProxVacuna newProxVacuna) {
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            //Se obtiene los datos existentes (x.class) en un objeto separado (oldX)
            ProxVacuna oldProxVacuna = (ProxVacuna) session.load(ProxVacuna.class, new Integer(idProxVacuna));
            //Se sustituyen los datos existentes por los nuevos
            oldProxVacuna.setMascota(newProxVacuna.getMascota());
            oldProxVacuna.setFechaProxVacuna(newProxVacuna.getFechaProxVacuna());
            oldProxVacuna.setNombreVacuna(newProxVacuna.getNombreVacuna());
            oldProxVacuna.setDetalles(newProxVacuna.getDetalles());
            //se actualiza
            session.update(oldProxVacuna);
            trns.commit();
        } catch(RuntimeException e){
            e.printStackTrace();
            if (trns != null){
                trns.rollback();
            }
            e.printStackTrace();
        } finally{
            session.flush();
            session.close();
        }
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
