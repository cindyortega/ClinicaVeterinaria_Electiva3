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
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            //Para borrar un registro se debe crear una instancia con el id a eliminar,
            Mascota mascota = (Mascota) session.load(Mascota.class, new Integer(idMascota));
            //despues invocar el metodo delete con el objeto que tiene el id en cuestion
            session.delete(mascota);
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
    public void updateMascota (int idMascota, Mascota newMascota) {
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            //Se obtiene los datos existentes (x.class) en un objeto separado (oldX)
            Mascota oldMascota = (Mascota) session.load(Mascota.class, new Integer(idMascota));
            //Se sustituyen los datos existentes por los nuevos
            oldMascota.setCliente(newMascota.getCliente());
            oldMascota.setNombre(newMascota.getNombre());
            oldMascota.setEspecie(newMascota.getEspecie());
            oldMascota.setRaza(newMascota.getRaza());
            oldMascota.setSexo(newMascota.getSexo());
            oldMascota.setColor(newMascota.getColor());
            oldMascota.setFechaNacimiento(newMascota.getFechaNacimiento());
            oldMascota.setNroFicha(newMascota.getNroFicha());
            //se actualiza
            session.update(oldMascota);
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
    
    //buscar mascota por su ID
    public Mascota getMascotaByID (int idMascota) {
        Mascota mascota = null;
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            String queryString = "from Mascota where id_mascota = :idToFind";
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
