/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Cliente;
import model.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author usuario
 */
public class ClienteController {
    //CRUD para Cliente
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
    
    public Cliente getClienteByID (int idCliente) {
        return null;
    }
    
    
}
