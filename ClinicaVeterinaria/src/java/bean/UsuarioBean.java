 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import controller.UsuarioController;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
//esto esta importado en el video
//import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import model.GrupoUsuario;
import model.Usuario;

/**
 *
 * @author usuario
 */
@ManagedBean
@SessionScoped
public class UsuarioBean {

    /**
     * Creates a new instance of UsuarioBean
     */
    
    private int idUsuario;
     private GrupoUsuario grupoUsuario;
     private String usuario;
     private String nombre;
     private String apellido;
     private String password;
    
    public UsuarioBean() {
    }

   
    public void addUsuario (){
        try {
            Usuario usuario = new Usuario (getIdUsuario(), getGrupoUsuario(), getUsuario(), getNombre(), getApellido(), getPassword());
            UsuarioController usuarioController = new UsuarioController();
            usuarioController.addUsuario(usuario);
            //mensaje de exito, si no es aca cortar y pegar donde corresponda
            FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso éxito.", "Datos guardados."));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso error.", "Error."));
        }
    }
    
    public String verificarDatos (){
        //Verifica los datos para el login
        UsuarioController usuarioController = new UsuarioController();
        Usuario us;
        String resultado;
        try {
            //aca necesito un tipo de dato usuario, y solo encuentra string
            //Solucione: cambie los parametros de verificarDatos del controlador
             us = usuarioController.verificarDatos(this.usuario, this.password);
             if(us != null){
                 FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", us);
                 resultado = "exito";
             } else {
                 resultado = "index";
             }
             
             if ("exito".equals(resultado)){        //resultado == "exito"
                 if (verificarPermisos1()){
                     resultado = "menu1?faces-redirect=true";
                 }
                 if (verificarPermisos2()){
                    resultado = "menu2?faces-redirect=true";
                }
             }
        } catch(Exception e){
            throw e;
        } finally{
            
        }
        return resultado;
    }
    
    
    public boolean verificarSesion(){
        //Verificar la sesion para el renderizado, que solo acepta boolean
        //no se si le tiene que llamar a verificarSesion
        boolean estado;
        
        if(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario") == null){
            estado = false;
        } else {
            estado = true;
        }
        
        return estado;
    }
    
    public String cerrarSesion(){
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        //return "index?faces-redirect=true";
        return "index";
    }
    
    //no se si esto esta bien, pero la idea es renderizar en cada menu
    public boolean verificarPermisos1(){
        boolean bandera = false;
        Usuario us = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
        //Probar si funciona poniendo el 1 en el equals
        if (us.getGrupoUsuario().equals(1)){
            bandera = true;
        }
        return bandera;
    }
    
    public boolean verificarPermisos2(){
        boolean bandera = false;
        Usuario us = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
        //Probar si funciona poniendo el 1 en el equals
        if (us.getGrupoUsuario().equals(2)){
            bandera = true;
        }
        return bandera;
    }
    
    
    //es el metodo getUsuarioByID, pero se usa Return aca para no confundir con los getters
    public void returnUsuarioByID(){
        UsuarioController usuarioController = new UsuarioController();
       Usuario usuario = usuarioController.getUsuarioByID(getIdUsuario());
        //si el bean no encuentra un usuario, devolvera null, de esa manera se sabe si el usuario existe o no
        if (usuario != null){
            setIdUsuario(usuario.getIdUsuario());
            setGrupoUsuario(usuario.getGrupoUsuario());
            setUsuario(usuario.getUsuario());
            setNombre(usuario.getNombre());
            setApellido(usuario.getApellido());
            
        } else {
            //para limpiar se pone vacios los datos del bean
            //ver si hace falta agregar esto
            setGrupoUsuario(null);
            setUsuario("");
            setNombre("");
            setApellido("");
            
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Usuario NO encontrado."));
        }
    }
    
    public void limpiarDatos(){
            setIdUsuario(0);
            setGrupoUsuario(null);
            setUsuario("");
            setNombre("");
            setApellido("");
    }
    
     /**
     * @return the idUsuario
     */
    public int getIdUsuario() {
        return idUsuario;
    }

    /**
     * @param idUsuario the idUsuario to set
     */
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    /**
     * @return the grupoUsuario
     */
    public GrupoUsuario getGrupoUsuario() {
        return grupoUsuario;
    }

    /**
     * @param grupoUsuario the grupoUsuario to set
     */
    public void setGrupoUsuario(GrupoUsuario grupoUsuario) {
        this.grupoUsuario = grupoUsuario;
    }

    /**
     * @return the usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
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
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
    
    
}
