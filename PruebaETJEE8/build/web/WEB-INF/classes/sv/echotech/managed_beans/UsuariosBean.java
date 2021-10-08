/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.echotech.managed_beans;

import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import sv.echotech.entities.UsuarioEntity;
import sv.echotech.model.UsuariosModel;


@ManagedBean
@ViewScoped
public class UsuariosBean implements Serializable{

    @EJB
    private UsuariosModel usuariosModel;
   
    List<UsuarioEntity> listaUsuarios;
    
    private UsuarioEntity usuario = new UsuarioEntity();

    
    public UsuariosBean() {
    }
    
    public String verificarCredenciales(){
       
            usuario = usuariosModel.verificarCredenciales(usuario.getUsuario(), usuario.getPassword());
            if(usuario==null){
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuario y/o contraseña incorrecta", null);
                FacesContext.getCurrentInstance().addMessage(null, message);
                return null;
            }
            else{
                //Si el usuario tiene verificacion 0 no debería de poder acceder al sistema
                if(usuario.getVerificacion() == 0){
                    FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Debe de verificar su cuenta", null);
                    FacesContext.getCurrentInstance().addMessage(null, message);
                    return null;
                }else{
                    //Si es 1 tiene permitido
                    HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
                    request.getSession().setAttribute("user", usuario.getUsuario());
                    request.getSession().setAttribute("rol", usuario.getRolId().getIdRol());
                    
                    return "bienvenido";
                }
            }
            
    }
    
    public String cerrarSesion(){
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        request.getSession().removeAttribute("user");
        request.getSession().removeAttribute("rol");
        return "index";
    }

    public List<UsuarioEntity> getListaUsuarios() {
        listaUsuarios = usuariosModel.listarUsuarios();
        return listaUsuarios;
    }
    
    public String insertarUsuario(){
        if(usuariosModel.insertarUsuarios(usuario)==0){
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ya existe un usuario registrado de igual manera", null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
        
        FacesContext.getCurrentInstance().getExternalContext().getFlash().put("exito", "Editorial insertado exitosamente");
        return "/usuarios/listaUsuarios?faces-redirect=true";
    }
    
    public String obtenerUsuario(){
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        int id = Integer.parseInt(request.getParameter("usuarioid"));
        usuario = usuariosModel.obtenerUsuario(id);
        return "/usuarios/editarUsuario";
    }

    public UsuarioEntity getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioEntity usuario) {
        this.usuario = usuario;
    }
    
    
}
