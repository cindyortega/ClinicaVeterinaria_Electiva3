/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.HibernateUtil;
import model.Usuario;
import org.hibernate.Query;
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
     
    public Usuario verificarDatos(String usuario, String password){
        Usuario us = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            String hql = "FROM usuario WHERE usuario = " + usuario
                    + "AND password = " + password + ";";
            Query query = session.createQuery(hql);
            
            if(query.list().isEmpty()) {
                us = (Usuario) query.list().get(0);
            }
        } catch (Exception e){
            throw e;
        }
        return us;
    }
    
    public void deleteUsuario (int idUsuario) {
        
    }
    
    public void updateUsuario (Usuario Usuario) {
        
    }
    
    public Usuario getUsuarioByID (int idUsuario) {
        return null;
    }

}
