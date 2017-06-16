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
        
    }
    
    public void updateCliente (Cliente cliente) {
        
    }
    
    //Buscar Cliente por su ID
    public Cliente getClienteByID (int idCliente) {
        Cliente cliente = null;
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            String queryString = "from cliente where id_cliente = :idToFind";
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
