/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import controller.VacunaController;
import java.util.HashSet;
import java.util.Set;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
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
