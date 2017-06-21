/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import controller.MedicoVeterinarioController;
import java.util.HashSet;
import java.util.Set;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import model.MedicoVeterinario;

/**
 *
 * @author usuario
 */
@ManagedBean
@SessionScoped
public class MedicoVeterinarioBean {

    /**
     * Creates a new instance of MedicoVeterinarioBean
     */
    
    private int idMedico;
    private String nombre;
    private String apellido;
    private int nroRegistro;
    private Set mascotaVacunas = new HashSet(0);
    
    public MedicoVeterinarioBean() {
    }

    public void addMedicoVeterinario(){
        MedicoVeterinario medicoVeterinario = new MedicoVeterinario (getIdMedico(), getNombre(), getApellido(), getNroRegistro(), getMascotaVacunas());
        MedicoVeterinarioController medicoVeterinarioController = new MedicoVeterinarioController();
        medicoVeterinarioController.addMedicoVeterinario(medicoVeterinario);
    }
    
    
    //es el metodo getMedicoVeterinarioByID, pero se usa Return aca para no confundir con los getters
    public void returnMedicoVeterinarioByID(){
        MedicoVeterinarioController medicoVeterinarioController = new MedicoVeterinarioController();
        MedicoVeterinario medicoVeterinario = medicoVeterinarioController.getMedicoVeterinarioByID(getIdMedico());
        //si el bean no encuentra un medico, devolvera null, de esa manera se sabe si el medico existe o no
        if (medicoVeterinario != null){
            setIdMedico(medicoVeterinario.getIdMedico());
            setNombre(medicoVeterinario.getNombre());
            setApellido(medicoVeterinario.getApellido());
            setNroRegistro(medicoVeterinario.getNroRegistro());
            
        } else {
            //para limpiar se pone vacios los datos del bean
            //ver si hace falta agregar esto
            setNombre("");
            setApellido("");
            setNroRegistro(0);
            
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Médico Veterinario NO encontrado."));
        }
    }
    
    public void limpiarDatos(){
        setIdMedico(0);
        setNombre("");
        setApellido("");
        setNroRegistro(0);
    }
    
    
    public  void deleteMedicoVeterinario(){
        MedicoVeterinarioController medicoVeterinarioController = new MedicoVeterinarioController();
        medicoVeterinarioController.deleteMedicoVeterinario(getIdMedico());
        setNombre("");
        setApellido("");
        setNroRegistro(0);
            
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage("Médico Veterinario con ID: " + getIdMedico() + " eliminado."));
    }
    
    
    public void updateMedicoVeterinario(){
        MedicoVeterinario newMedicoVeterinario = new MedicoVeterinario(getIdMedico(), getNombre(), getApellido(),getNroRegistro());
        MedicoVeterinarioController medicoVeterinarioController = new MedicoVeterinarioController();
        medicoVeterinarioController.updateMedicoVeterinario(idMedico, newMedicoVeterinario);
        FacesContext.getCurrentInstance().addMessage(null, 
                new FacesMessage("Médico Veterinario actualizado correctamente."));
    }
    
    /**
     * @return the idMedico
     */
    public int getIdMedico() {
        return idMedico;
    }

    /**
     * @param idMedico the idMedico to set
     */
    public void setIdMedico(int idMedico) {
        this.idMedico = idMedico;
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
     * @return the nroRegistro
     */
    public int getNroRegistro() {
        return nroRegistro;
    }

    /**
     * @param nroRegistro the nroRegistro to set
     */
    public void setNroRegistro(int nroRegistro) {
        this.nroRegistro = nroRegistro;
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
    
}
