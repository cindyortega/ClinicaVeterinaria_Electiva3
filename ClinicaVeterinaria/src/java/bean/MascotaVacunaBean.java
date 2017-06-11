/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import controller.MascotaVacunaController;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.Mascota;
import model.MascotaVacuna;
import model.MascotaVacunaId;
import model.MedicoVeterinario;
import model.Vacuna;

/**
 *
 * @author usuario
 */
@ManagedBean
@SessionScoped
public class MascotaVacunaBean {

    /**
     * Creates a new instance of MascotaVacunaBean
     */
    
     private MascotaVacunaId id;
     private Mascota mascota;
     private MedicoVeterinario medicoVeterinario;
     private Vacuna vacuna;
     private String nombreVacuna;
     private String detallesDosis;
     private Date fechaAplicacion;
     
     
    public MascotaVacunaBean() {
    }
    
    public void addMascotaVacuna(){
        MascotaVacuna mascotaVacuna = new MascotaVacuna (getId(), getMascota(), getMedicoVeterinario(), getVacuna(), getNombreVacuna(), getDetallesDosis(), getFechaAplicacion());
        MascotaVacunaController mascotaVacunaController = new MascotaVacunaController();
        mascotaVacunaController.addMascotaVacuna(mascotaVacuna);
    }

    /**
     * @return the id
     */
    public MascotaVacunaId getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(MascotaVacunaId id) {
        this.id = id;
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
     * @return the medicoVeterinario
     */
    public MedicoVeterinario getMedicoVeterinario() {
        return medicoVeterinario;
    }

    /**
     * @param medicoVeterinario the medicoVeterinario to set
     */
    public void setMedicoVeterinario(MedicoVeterinario medicoVeterinario) {
        this.medicoVeterinario = medicoVeterinario;
    }

    /**
     * @return the vacuna
     */
    public Vacuna getVacuna() {
        return vacuna;
    }

    /**
     * @param vacuna the vacuna to set
     */
    public void setVacuna(Vacuna vacuna) {
        this.vacuna = vacuna;
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
     * @return the detallesDosis
     */
    public String getDetallesDosis() {
        return detallesDosis;
    }

    /**
     * @param detallesDosis the detallesDosis to set
     */
    public void setDetallesDosis(String detallesDosis) {
        this.detallesDosis = detallesDosis;
    }

    /**
     * @return the fechaAplicacion
     */
    public Date getFechaAplicacion() {
        return fechaAplicacion;
    }

    /**
     * @param fechaAplicacion the fechaAplicacion to set
     */
    public void setFechaAplicacion(Date fechaAplicacion) {
        this.fechaAplicacion = fechaAplicacion;
    }
    
}
