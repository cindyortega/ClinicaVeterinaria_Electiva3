/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.GrupoUsuario;

/**
 *
 * @author usuario
 */
@ManagedBean
@SessionScoped
public class UsuarioBean {

    /**
     * Creates a new instance of UsuarioBean
     */
    
    private int idUsuario;
     private GrupoUsuario grupoUsuario;
     private String usuario;
     private String nombre;
     private String apellido;
     private String password;
    
    public UsuarioBean() {
    }

    /**
     * @return the idUsuario
     */
    public void addUsuario (){
        
    }
    
    public boolean checkLogin (){
        //verificar usuario y pass
        //esta mal la oarte del form
       /* if (usuario.getUsuario().equals(usuarioForm.getUsuario)&&usuario.getPassword().equals(usuarioForm.getPassword())){
            return true;
        }*/
       return false;
    }
    
    public int getIdUsuario() {
        return idUsuario;
    }

    /**
     * @param idUsuario the idUsuario to set
     */
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    /**
     * @return the grupoUsuario
     */
    public GrupoUsuario getGrupoUsuario() {
        return grupoUsuario;
    }

    /**
     * @param grupoUsuario the grupoUsuario to set
     */
    public void setGrupoUsuario(GrupoUsuario grupoUsuario) {
        this.grupoUsuario = grupoUsuario;
    }

    /**
     * @return the usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the apellido
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * @param apellido the apellido to set
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
    
}
