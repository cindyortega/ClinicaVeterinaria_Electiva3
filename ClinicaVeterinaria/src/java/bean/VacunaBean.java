/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import controller.VacunaController;
import java.util.HashSet;
import java.util.Set;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import model.Vacuna;

/**
 *
 * @author usuario
 */
@ManagedBean
@SessionScoped
public class VacunaBean {

    /**
     * Creates a new instance of VacunaBean
     */
    
    private int idVacuna;
    private String nombreVacuna;
    private String descripcion;
    private Set mascotaVacunas = new HashSet(0);
     
    public VacunaBean() {
    }
    
     public void addVacuna(){
        Vacuna vacuna = new Vacuna (getIdVacuna(), getNombreVacuna(), getDescripcion(), getMascotaVacunas());
        VacunaController vacunaController = new VacunaController();
        vacunaController.addVacuna(vacuna);
    }

     
      //es el metodo getVacunaByID, pero se usa Return aca para no confundir con los getters
    public void returnVacunaByID(){
        VacunaController vacunaController = new VacunaController();
        Vacuna vacuna = vacunaController.getVacunaByID(getIdVacuna());
        //si el bean no encuentra una Vacuna, devolvera null, de esa manera se sabe si la Vacuna existe o no
        if (vacuna != null){
            setIdVacuna(vacuna.getIdVacuna());
            setNombreVacuna(vacuna.getNombreVacuna());
            setDescripcion(vacuna.getDescripcion());
            
        } else {
            //para limpiar se pone vacios los datos del bean
            //ver si hace falta agregar esto
            setNombreVacuna("");
            setDescripcion("");
            
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Vacuna NO encontrada."));
        }
    }
    
    public void limpiarDatos(){
        setIdVacuna(0);
        setNombreVacuna("");
        setDescripcion("");
    }
     
    
    public  void deleteVacuna(){
        VacunaController vacunaController = new VacunaController();
        vacunaController.deleteVacuna(getIdVacuna());
        setNombreVacuna("");
        setDescripcion("");
            
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage("Vacuna con ID: " + getIdVacuna() + " eliminada."));
    }
    
    /**
     * @return the idVacuna
     */
    public int getIdVacuna() {
        return idVacuna;
    }

    /**
     * @param idVacuna the idVacuna to set
     */
    public void setIdVacuna(int idVacuna) {
        this.idVacuna = idVacuna;
    }

    /**
     * @return the nombreVacuna
     */
    public String getNombreVacuna() {
        return nombreVacuna;
    }

    /**
     * @param nombreVacuna the nombreVacuna to set
     */
    public void setNombreVacuna(String nombreVacuna) {
        this.nombreVacuna = nombreVacuna;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
