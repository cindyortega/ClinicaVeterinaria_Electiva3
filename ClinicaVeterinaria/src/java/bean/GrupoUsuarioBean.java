/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import controller.GrupoUsuarioController;
import java.util.HashSet;
import java.util.Set;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
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
