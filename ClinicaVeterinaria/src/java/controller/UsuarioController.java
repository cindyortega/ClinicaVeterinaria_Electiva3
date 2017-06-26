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
     
     //(String usuario, String password)
    public Usuario verificarDatos(String usuario, String password) throws Exception{
        Usuario us = new Usuario(usuario, password);
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            String hql = "from Usuario where usuario = '" + usuario
                    + "' and password = '" + password + "'";
            Query query = session.createQuery(hql);
            
            if(!query.list().isEmpty()) {
                us = (Usuario) query.list().get(0);
            } 
        } catch (Exception e){
            throw e;
        }
        return us;
        /*
        desde el if se cambia
        query.setParameter("usuario", usuario);
        query.setParameter("password", password);
        us = (Usuario) query.uniqueResult();
            
        
        */
    }
    
    public void deleteUsuario (int idUsuario) {
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            //Para borrar un registro se debe crear una instancia con el id a eliminar,
            Usuario usuario = (Usuario) session.load(Usuario.class, new Integer(idUsuario));
            //despues invocar el metodo delete con el objeto que tiene el id en cuestion
            session.delete(usuario);
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
    public void updateUsuario (int idUsuario, Usuario newUsuario) {
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            //Se obtiene los datos existentes (x.class) en un objeto separado (oldX)
            Usuario oldUsuario = (Usuario) session.load(Usuario.class, new Integer(idUsuario));
            //Se sustituyen los datos existentes por los nuevos
            oldUsuario.setGrupoUsuario(newUsuario.getGrupoUsuario());
            oldUsuario.setUsuario(newUsuario.getUsuario());
            oldUsuario.setNombre(newUsuario.getNombre());
            oldUsuario.setApellido(newUsuario.getApellido());
            oldUsuario.setPassword(newUsuario.getPassword());
            //se actualiza
            session.update(oldUsuario);
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
    
    //buscar usuario por su ID
    public Usuario getUsuarioByID (int idUsuario) {
        Usuario usuario = null;
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            String queryString = "from Usuario where id_usuario = :idToFind";
            Query query = session.createQuery(queryString);
            query.setInteger("idToFind", idUsuario);
            usuario = (Usuario) query.uniqueResult();
        } catch (RuntimeException e){
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }       

        return usuario;
    }

}
