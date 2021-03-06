/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Cliente;
import model.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author usuario
 */
public class ClienteController {
    //CRUD para Cliente
    
    //Agregar Cliente
    public void addCliente(Cliente cliente) {
        Transaction tx = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        try {
            tx = session.beginTransaction();
            session.save(cliente);
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
    
    public void deleteCliente (int idCliente) {
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            //Para borrar un registro se debe crear una instancia con el id a eliminar,
            Cliente cliente = (Cliente) session.load(Cliente.class, new Integer(idCliente));
            //despues invocar el metodo delete con el objeto que tiene el id en cuestion
            session.delete(cliente);
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
    public void updateCliente (int idCliente, Cliente newCliente) {
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            //Se obtiene los datos existentes (x.class) en un objeto separado (oldX)
            Cliente oldCliente = (Cliente) session.load(Cliente.class, new Integer(idCliente));
            //Se sustituyen los datos existentes por los nuevos
            oldCliente.setNombre(newCliente.getNombre());
            oldCliente.setTelefono(newCliente.getTelefono());
            oldCliente.setDireccion(newCliente.getDireccion());
            oldCliente.setEmail(newCliente.getEmail());
            //se actualiza
            session.update(oldCliente);
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
    
    //Buscar Cliente por su ID
    public Cliente getClienteByID (int idCliente) {
        Cliente cliente = null;
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            String queryString = "from Cliente where id_cliente = :idToFind";
            Query query = session.createQuery(queryString);
            query.setInteger("idToFind", idCliente);
            cliente = (Cliente) query.uniqueResult();
        } catch (RuntimeException e){
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }       

        return cliente;
    }
    
    
}
