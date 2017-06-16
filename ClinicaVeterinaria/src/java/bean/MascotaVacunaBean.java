/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import controller.MascotaVacunaController;
import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
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

    
    //es el metodo getMascotaVacunaByID, pero se usa Return aca para no confundir con los getters
    public void returnMascotaVacunaByID(){
        MascotaVacunaController mascotaVacunaController = new MascotaVacunaController();
        //Verificar la linea de abajo, ya que no puedo poner getId porque es un objeto, y esto recibe un int
        MascotaVacuna mascotaVacuna = mascotaVacunaController.getMascotaVacunaByID(mascota.getIdMascota());
        //si el bean no encuentra una mascotavacuna, devolvera null, de esa manera se sabe si la mascotavacuna existe o no
        if (mascotaVacuna != null){
            setId(mascotaVacuna.getId());
            setMascota(mascotaVacuna.getMascota());
            setMedicoVeterinario(mascotaVacuna.getMedicoVeterinario());
            setVacuna(mascotaVacuna.getVacuna());
            setNombreVacuna(mascotaVacuna.getNombreVacuna());
            setDetallesDosis(mascotaVacuna.getDetallesDosis());
            setFechaAplicacion(mascotaVacuna.getFechaAplicacion());
          
        } else {
            //para limpiar se pone vacios los datos del bean
            //ver si hace falta agregar esto
            setMascota(null);
            setMedicoVeterinario(null);
            setVacuna(null);
            setNombreVacuna("");
            setDetallesDosis("");
            setFechaAplicacion(null);
            
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Mascota Vacuna NO encontrada."));
        }
    }
    
    public void limpiarDatos(){
        setId(null);
        setMascota(null);
        setMedicoVeterinario(null);
        setVacuna(null);
        setNombreVacuna("");
        setDetallesDosis("");
        setFechaAplicacion(null);
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
