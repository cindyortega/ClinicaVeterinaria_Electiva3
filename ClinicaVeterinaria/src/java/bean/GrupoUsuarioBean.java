/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import controller.GrupoUsuarioController;
import java.util.HashSet;
import java.util.Set;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import model.GrupoUsuario;

/**
 *
 * @author usuario
 */
@ManagedBean
@SessionScoped
public class GrupoUsuarioBean {

    /**
     * Creates a new instance of GrupoUsuarioBean
     */
    
    private int idGrupo;
    private String nombreGrupo;
    private Set usuarios = new HashSet(0);
    
    public GrupoUsuarioBean() {
    }

    public void addGrupoUsuario(){
        GrupoUsuario grupoUsuario = new GrupoUsuario (getIdGrupo(), getNombreGrupo(), getUsuarios());
        GrupoUsuarioController grupoUsuarioController = new GrupoUsuarioController();
        grupoUsuarioController.addGrupoUsuario(grupoUsuario);
    }
    
    
     //es el metodo getGrupoUsuarioByID, pero se usa Return aca para no confundir con los getters
    public void returnGrupoUsuarioByID(){
        GrupoUsuarioController grupoUsuarioController = new GrupoUsuarioController();
        GrupoUsuario grupoUsuario = grupoUsuarioController.getGrupoUsuarioByID(getIdGrupo());
        //si el bean no encuentra un GrupoUsuario, devolvera null, de esa manera se sabe si el GrupoUsuario existe o no
        if (grupoUsuario != null){
            setIdGrupo(grupoUsuario.getIdGrupo());
            setNombreGrupo(grupoUsuario.getNombreGrupo());
        } else {
            //para limpiar se pone vacios los datos del bean
            //ver si hace falta agregar esto
            setNombreGrupo("");
            
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Grupo de Usuario NO encontrado."));
        }
    }
    
    public void limpiarDatos(){
        setIdGrupo(0);
        setNombreGrupo("");
    }
    
    /**
     * @return the idGrupo
     */
    public int getIdGrupo() {
        return idGrupo;
    }

    /**
     * @param idGrupo the idGrupo to set
     */
    public void setIdGrupo(int idGrupo) {
        this.idGrupo = idGrupo;
    }

    /**
     * @return the nombreGrupo
     */
    public String getNombreGrupo() {
        return nombreGrupo;
    }

    /**
     * @param nombreGrupo the nombreGrupo to set
     */
    public void setNombreGrupo(String nombreGrupo) {
        this.nombreGrupo = nombreGrupo;
    }

    /**
     * @return the usuarios
     */
    public Set getUsuarios() {
        return usuarios;
    }

    /**
     * @param usuarios the usuarios to set
     */
    public void setUsuarios(Set usuarios) {
        this.usuarios = usuarios;
    }
    
}
