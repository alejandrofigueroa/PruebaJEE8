package sv.edu.udb.www.managed_beans;

import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import sv.edu.udb.www.entities.UsuarioEntity;
import sv.edu.udb.www.model.UsuariosModel;


@Named(value = "usuariosBean")
@RequestScoped
public class UsuariosBean {

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
                    request.getSession().setAttribute("rol", usuario.getRolId());
                    return "bienvenido";
                }
            }
            
    }

    public List<UsuarioEntity> getListaUsuarios() {
        listaUsuarios = usuariosModel.listarUsuarios();
        return listaUsuarios;
    }

    public UsuarioEntity getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioEntity usuario) {
        this.usuario = usuario;
    }
    
    public String insertarUsuario(){
        usuariosModel.insertarUsuarios(usuario);
        return "/usuarios/listaUsuarios";
    }
    
       
}