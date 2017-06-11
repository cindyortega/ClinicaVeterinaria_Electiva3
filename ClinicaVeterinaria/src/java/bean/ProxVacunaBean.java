/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import controller.ProxVacunaController;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.Mascota;
import model.ProxVacuna;

/**
 *
 * @author usuario
 */
@ManagedBean
@SessionScoped
public class ProxVacunaBean {

    /**
     * Creates a new instance of ProxVacunaBean
     */
    
    private int idProxVacuna;
     private Mascota mascota;
     private Date fechaProxVacuna;
     private String nombreVacuna;
     private String detalles;
     
    public ProxVacunaBean() {
    }

    public void addProxVacuna(){
        ProxVacuna proxVacuna = new ProxVacuna (getIdProxVacuna(), getMascota(), getFechaProxVacuna(), getNombreVacuna(), getDetalles());
        ProxVacunaController proxVacunaController = new ProxVacunaController();
        proxVacunaController.addProxVacuna(proxVacuna);
    }
    
    /**
     * @return the idProxVacuna
     */
    public int getIdProxVacuna() {
        return idProxVacuna;
    }

    /**
     * @param idProxVacuna the idProxVacuna to set
     */
    public void setIdProxVacuna(int idProxVacuna) {
        this.idProxVacuna = idProxVacuna;
    }

    /**
     * @return the mascota
     */
    public Mascota getMascota() {
        return mascota;
    }

    /**
     * @param mascota the mascota to set
     */
    public void setMascota(Mascota mascota) {
        this.mascota = mascota;
    }

    /**
     * @return the fechaProxVacuna
     */
    public Date getFechaProxVacuna() {
        return fechaProxVacuna;
    }

    /**
     * @param fechaProxVacuna the fechaProxVacuna to set
     */
    public void setFechaProxVacuna(Date fechaProxVacuna) {
        this.fechaProxVacuna = fechaProxVacuna;
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
     * @return the detalles
     */
    public String getDetalles() {
        return detalles;
    }

    /**
     * @param detalles the detalles to set
     */
    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }
    
}
