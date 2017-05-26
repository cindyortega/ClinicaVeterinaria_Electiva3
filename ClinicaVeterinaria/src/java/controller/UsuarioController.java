/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.HibernateUtil;
import model.Usuario;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author usuario
 */
public class UsuarioController {
    
     public void addUsuario(Usuario usuario) {
        Transaction tx = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        try {
            tx = session.beginTransaction();
            session.save(usuario);
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
    
    public void deleteUsuario (int idUsuario) {
        
    }
    
    public void updateUsuario (Usuario Usuario) {
        
    }
    
    public Usuario getUsuarioByID (int idUsuario) {
        return null;
    }
}
