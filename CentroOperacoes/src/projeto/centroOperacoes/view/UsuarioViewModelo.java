package projeto.centroOperacoes.view;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.primefaces.context.RequestContext;

import projeto.centroOperacoes.controle.PermissaoControle;
import projeto.centroOperacoes.controle.UsuarioControle;
import projeto.centroOperacoes.modelo.Permissao;
import projeto.centroOperacoes.modelo.Usuario;

@ManagedBean(name = "usuarioView")
@RequestScoped
public class UsuarioViewModelo implements Serializable{

	private static final long serialVersionUID = 1L;
	
	public UsuarioViewModelo() {
		usuarios = new UsuarioControle().listarTodos();
		permissoes = new PermissaoControle().listarTodos();
	}
	
	private String cpf;
	
	private String nome;
	
	private String funcao;
	
	private String status;
	
	private String login;
	
	private String senha;

	private Permissao permissao;
	
	private List<Permissao> permissoes;
	
	private List<Usuario> usuarios;
	
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public List<Usuario> getUsuarios() {
		return usuarios;
	}
	
	public Permissao getPermissao() {
		return permissao;
	}

	public void setPermissao(Permissao permissao) {
		this.permissao = permissao;
	}

	public List<Permissao> getPermissoes() {
		return permissoes;
	}
	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public void cadastrar() {

		if (cpf.equals("") || nome.equals("") || funcao.equals("")) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso!", "Por favor preencer todos campos."));
		} else {
			
			Usuario user = new Usuario();
			
			user.setCpf(cpf);
			user.setFuncao(funcao);
			user.setNome(nome);
			
			new UsuarioControle().inserir(user);
			
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Sucesso!", "Usuario cadastrado com sucesso."));
		}
	}
	
	public void modificarUsuario(Usuario user) {
		if (user != null) {
			new UsuarioControle().modificar(user);
		}
	}
	
	public void desativarUsuario(Usuario user) {
		if (user != null) {
			new UsuarioControle().ativar(user);			
		}
	}
	
	public void ativarUsuario(Usuario user) {
		if (user != null) {
			new UsuarioControle().ativar(user);
		}
	}
	
	public void logar(ActionEvent event) {
		try {    	
	        RequestContext context = RequestContext.getCurrentInstance();
	        FacesMessage message = null;
	        boolean loggedIn = false;
	        
	        Usuario user = new UsuarioControle().isUsuarioReadyToLogin(login, senha);
	        
	        if (user == null) {
	            FacesContext.getCurrentInstance().validationFailed();
	            loggedIn = false;
	            message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Erro de Login", "Acesso inválido");	          
	        }else{          
					loggedIn = true;
					FacesContext.getCurrentInstance().getExternalContext().redirect("main.xhtml");
					message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bem vindo ", user.getNome());
	        }
	        	        
		} catch (Exception e) {
			e.printStackTrace();
		}        
	}
}
	