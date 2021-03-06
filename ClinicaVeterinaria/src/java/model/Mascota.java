package model;
// Generated 23/05/2017 10:07:46 by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Mascota generated by hbm2java
 */
public class Mascota  implements java.io.Serializable {


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

    public Mascota() {
    }

	
    public Mascota(int idMascota, Cliente cliente, String nombre, String especie, String raza, String sexo, String color, Date fechaNacimiento, int nroFicha) {
        this.idMascota = idMascota;
        this.cliente = cliente;
        this.nombre = nombre;
        this.especie = especie;
        this.raza = raza;
        this.sexo = sexo;
        this.color = color;
        this.fechaNacimiento = fechaNacimiento;
        this.nroFicha = nroFicha;
    }
    public Mascota(int idMascota, Cliente cliente, String nombre, String especie, String raza, String sexo, String color, Date fechaNacimiento, int nroFicha, Set mascotaVacunas, Set proxVacunas) {
       this.idMascota = idMascota;
       this.cliente = cliente;
       this.nombre = nombre;
       this.especie = especie;
       this.raza = raza;
       this.sexo = sexo;
       this.color = color;
       this.fechaNacimiento = fechaNacimiento;
       this.nroFicha = nroFicha;
       this.mascotaVacunas = mascotaVacunas;
       this.proxVacunas = proxVacunas;
    }
   
    public int getIdMascota() {
        return this.idMascota;
    }
    
    public void setIdMascota(int idMascota) {
        this.idMascota = idMascota;
    }
    public Cliente getCliente() {
        return this.cliente;
    }
    
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getEspecie() {
        return this.especie;
    }
    
    public void setEspecie(String especie) {
        this.especie = especie;
    }
    public String getRaza() {
        return this.raza;
    }
    
    public void setRaza(String raza) {
        this.raza = raza;
    }
    public String getSexo() {
        return this.sexo;
    }
    
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    public String getColor() {
        return this.color;
    }
    
    public void setColor(String color) {
        this.color = color;
    }
    public Date getFechaNacimiento() {
        return this.fechaNacimiento;
    }
    
    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    public int getNroFicha() {
        return this.nroFicha;
    }
    
    public void setNroFicha(int nroFicha) {
        this.nroFicha = nroFicha;
    }
    public Set getMascotaVacunas() {
        return this.mascotaVacunas;
    }
    
    public void setMascotaVacunas(Set mascotaVacunas) {
        this.mascotaVacunas = mascotaVacunas;
    }
    public Set getProxVacunas() {
        return this.proxVacunas;
    }
    
    public void setProxVacunas(Set proxVacunas) {
        this.proxVacunas = proxVacunas;
    }




}


