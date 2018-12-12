package projeto.centroOperacoes.view;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import projeto.centroOperacoes.controle.UsuarioControl;
import projeto.centroOperacoes.modelo.Usuario;

@ManagedBean
@RequestScoped
public class LoginView {

	private Usuario valid;
	private String username;
	private String password;

	public void setUsername(String name) {
		this.username = name;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void login(ActionEvent event) {
		try {
			FacesMessage message = null;
			UsuarioControl userController = new UsuarioControl();

			Boolean valid;

			valid = userController.isUsuarioReadyToLogin(username, password);

			if (valid == false) {
				FacesContext.getCurrentInstance().validationFailed();

				message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Erro de Login", "Acesso inválido");
			} else {

				FacesContext.getCurrentInstance().getExternalContext().redirect("main.xhtml");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}