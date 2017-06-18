/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.GrupoUsuario;
import model.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author usuario
 */
public class GrupoUsuarioController {
    //CRUD para GrupoUsuario
    public void addGrupoUsuario(GrupoUsuario grupoUsuario) {
        Transaction tx = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        try {
            tx = session.beginTransaction();
            session.save(grupoUsuario);
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
    
    public void deleteGrupoUsuario (int idGrupoUsuario) {
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            //Para borrar un registro se debe crear una instancia con el id a eliminar,
            GrupoUsuario grupoUsuario = (GrupoUsuario) session.load(GrupoUsuario.class, new Integer(idGrupoUsuario));
            //despues invocar el metodo delete con el objeto que tiene el id en cuestion
            session.delete(grupoUsuario);
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
    
    public void updateGrupoUsuario (GrupoUsuario grupoUsuario) {
        
    }
    
    //Buscar grupo de usuario por su ID
    public GrupoUsuario getGrupoUsuarioByID (int idGrupoUsuario) {
        GrupoUsuario grupoUsuario = null;
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            String queryString = "from grupo_usuario where id_grupo = :idToFind";
            Query query = session.createQuery(queryString);
            query.setInteger("idToFind", idGrupoUsuario);
            grupoUsuario = (GrupoUsuario) query.uniqueResult();
        } catch (RuntimeException e){
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }       

        return grupoUsuario;
    }
}
