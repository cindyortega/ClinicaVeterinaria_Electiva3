/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import controller.ClienteController;
import java.util.HashSet;
import java.util.Set;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
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

    
    //es el metodo getClienteByID, pero se usa Return aca para no confundir con los getters
    public void returnClienteByID(){
        ClienteController clienteController = new ClienteController();
        Cliente cliente = clienteController.getClienteByID(getIdCliente());
        //si el bean no encuentra un cliente, devolvera null, de esa manera se sabe si el cliente existe o no
        if (cliente != null){
            setIdCliente(cliente.getIdCliente());
            setNombre(cliente.getNombre());
            setTelefono(cliente.getTelefono());
            setDireccion(cliente.getDireccion());
            setEmail(cliente.getEmail());
        } else {
            //para limpiar se pone vacios los datos del bean
            //ver si hace falta agregar esto
            setNombre("");
            setTelefono("");
            setDireccion("");
            setEmail("");
            
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Cliente NO encontrado."));
        }
    }
    
    
    public void limpiarDatos(){
        setIdCliente(0);
        setNombre("");
        setTelefono("");
        setDireccion("");
        setEmail("");
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
