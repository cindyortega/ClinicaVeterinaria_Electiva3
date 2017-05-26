/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import controller.ClienteController;
import java.util.HashSet;
import java.util.Set;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.Cliente;

/**
 *
 * @author usuario
 */
@ManagedBean
@SessionScoped
public class ClienteBean {

    /**
     * Creates a new instance of ClienteBean
     */
    
     private int idCliente;
     private String nombre;
     private String telefono;
     private String direccion;
     private String email;
     private Set mascotas = new HashSet(0);
     
     
    public ClienteBean() {
    }
    
    public void addCliente(){
        Cliente cliente = new Cliente (getIdCliente(), getNombre(), getTelefono(), getDireccion(), getEmail(), getMascotas());
        ClienteController clienteController = new ClienteController();
        clienteController.addCliente(cliente);
    }

    /**
     * @return the idCliente
     */
    public int getIdCliente() {
        return idCliente;
    }

    /**
     * @param idCliente the idCliente to set
     */
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
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
     * @return the telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the mascotas
     */
    public Set getMascotas() {
        return mascotas;
    }

    /**
     * @param mascotas the mascotas to set
     */
    public void setMascotas(Set mascotas) {
        this.mascotas = mascotas;
    }
    
}
