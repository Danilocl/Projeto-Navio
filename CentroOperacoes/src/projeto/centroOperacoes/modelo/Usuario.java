package projeto.centroOperacoes.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Usuario {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "usuario_id")
	private int id;
	
	@Column(name = "usuario_cpf")
	private String cpf;
	
	@Column(name = "usuario_nome")
	private String nome;
	
	@Column(name = "usuario_sobrenome")
	private String funcao;
	
	@Column(name = "usuario_login")
	private String login;
	
	@Column(name = "usuario_senha")
	private String senha;
	
	@Column(name = "usuario_status")
	private int status;
	
	@OneToMany(mappedBy = "usuario")
	private List<Evento> evento = new ArrayList<>();
	
	@ManyToMany(mappedBy = "usuario")
	private List<Permissao> permisao = new ArrayList<>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public List<Permissao> getPermisao() {
		return permisao;
	}

	public void setPermisao(List<Permissao> permisao) {
		this.permisao = permisao;
	}

	public List<Evento> getEvento() {
		return evento;
	}

	public void setEvento(List<Evento> evento) {
		this.evento = evento;
	}
}
