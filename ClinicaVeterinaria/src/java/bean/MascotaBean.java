/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import controller.MascotaController;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import model.Cliente;
import model.Mascota;

/**
 *
 * @author usuario
 */
@ManagedBean
@SessionScoped
public class MascotaBean {

    /**
     * Creates a new instance of MascotaBean
     */
    private int idMascota;
     private Cliente cliente;
     private String nombre;
     private String especie;
     private String raza;
     private String sexo;
     private String color;
     private Date fechaNacimiento;
     private int nroFicha;
     private Set mascotaVacunas = new HashSet(0);
     private Set proxVacunas = new HashSet(0);
    
    public MascotaBean() {
    }

      public void addMascota(){
        Mascota mascota = new Mascota (getIdMascota(), getCliente(), getNombre(), getEspecie(), getRaza(), getSexo(), getColor(), getFechaNacimiento(), getNroFicha(), getMascotaVacunas(), getProxVacunas());
        MascotaController mascotaController = new MascotaController();
        mascotaController.addMascota(mascota);
    }
    
    
    //es el metodo getMascotaByID, pero se usa Return aca para no confundir con los getters
    public void returnMascotaByID(){
        MascotaController mascotaController = new MascotaController();
        Mascota mascota = mascotaController.getMascotaByID(getIdMascota());
        //si el bean no encuentra una mascota, devolvera null, de esa manera se sabe si la mascota existe o no
        if (mascota != null){
            setIdMascota(mascota.getIdMascota());
            setCliente(mascota.getCliente());
            setNombre(mascota.getNombre());
            setEspecie(mascota.getEspecie());
            setRaza(mascota.getRaza());
            setSexo(mascota.getSexo());
            setColor(mascota.getColor());
            setFechaNacimiento(mascota.getFechaNacimiento());
            setNroFicha(mascota.getNroFicha());
        } else {
            //para limpiar se pone vacios los datos del bean
            //ver si hace falta agregar esto
            setCliente(null);
            setNombre("");
            setEspecie("");
            setRaza("");
            setSexo("");
            setColor("");
            Date fecha = new Date();
            setFechaNacimiento(fecha);
            setNroFicha(0);
            
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Mascota NO encontrada."));
        }
    }
    
    public void limpiarDatos(){
        setIdMascota(0);
        setCliente(null);
        setNombre("");
        setEspecie("");
        setRaza("");
        setSexo("");
        setColor("");
        setFechaNacimiento(null);
        setNroFicha(0);
    }
      
    /**
     * @return the idMascota
     */
    public int getIdMascota() {
        return idMascota;
    }

    /**
     * @param idMascota the idMascota to set
     */
    public void setIdMascota(int idMascota) {
        this.idMascota = idMascota;
    }

    /**
     * @return the cliente
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
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
     * @return the especie
     */
    public String getEspecie() {
        return especie;
    }

    /**
     * @param especie the especie to set
     */
    public void setEspecie(String especie) {
        this.especie = especie;
    }

    /**
     * @return the raza
     */
    public String getRaza() {
        return raza;
    }

    /**
     * @param raza the raza to set
     */
    public void setRaza(String raza) {
        this.raza = raza;
    }

    /**
     * @return the sexo
     */
    public String getSexo() {
        return sexo;
    }

    /**
     * @param sexo the sexo to set
     */
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    /**
     * @return the color
     */
    public String getColor() {
        return color;
    }

    /**
     * @param color the color to set
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * @return the fechaNacimiento
     */
    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * @param fechaNacimiento the fechaNacimiento to set
     */
    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * @return the nroFicha
     */
    public int getNroFicha() {
        return nroFicha;
    }

    /**
     * @param nroFicha the nroFicha to set
     */
    public void setNroFicha(int nroFicha) {
        this.nroFicha = nroFicha;
    }

    /**
     * @return the mascotaVacunas
     */
    public Set getMascotaVacunas() {
        return mascotaVacunas;
    }

    /**
     * @param mascotaVacunas the mascotaVacunas to set
     */
    public void setMascotaVacunas(Set mascotaVacunas) {
        this.mascotaVacunas = mascotaVacunas;
    }

    /**
     * @return the proxVacunas
     */
    public Set getProxVacunas() {
        return proxVacunas;
    }

    /**
     * @param proxVacunas the proxVacunas to set
     */
    public void setProxVacunas(Set proxVacunas) {
        this.proxVacunas = proxVacunas;
    }
    
}
