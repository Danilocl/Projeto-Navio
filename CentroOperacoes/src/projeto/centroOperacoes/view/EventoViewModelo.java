package projeto.centroOperacoes.view;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import projeto.centroOperacoes.controle.AlocacaoEquipamentoEventoControle;
import projeto.centroOperacoes.controle.EventoControle;
import projeto.centroOperacoes.controle.NavioControle;
import projeto.centroOperacoes.controle.UsuarioControle;
import projeto.centroOperacoes.modelo.AlocacaoEquipamentoEvento;
import projeto.centroOperacoes.modelo.Navio;
import projeto.centroOperacoes.modelo.Usuario;

@ManagedBean
@RequestScoped
public class EventoViewModelo implements Serializable{

	private static final long serialVersionUID = 1L;
	
	public EventoViewModelo() {
		usuarios = new UsuarioControle().listarTodos();
		navios = new NavioControle().listarTodos();
		alocacaoEquipamentoEventos = new AlocacaoEquipamentoEventoControle().listarTodos();
	}
	
	private Date data;

	private String descricao;

	private int status;

	private Navio navio;

	private Usuario usuario;

	private String token;

	private Date dataInicio;

	private Date dataTerminoAtendimento;
	
	private List<Usuario> usuarios;
	
	private List<Navio> navios;
	
	private List<AlocacaoEquipamentoEvento> alocacaoEquipamentoEventos;

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Navio getNavio() {
		return navio;
	}

	public void setNavio(Navio navio) {
		this.navio = navio;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataTerminoAtendimento() {
		return dataTerminoAtendimento;
	}

	public void setDataTerminoAtendimento(Date dataTerminoAtendimento) {
		this.dataTerminoAtendimento = dataTerminoAtendimento;
	}

	public List<AlocacaoEquipamentoEvento> getAlocacaoEquipamentoEventos() {
		return alocacaoEquipamentoEventos;
	}

	public void setAlocacaoEquipamentoEventos(List<AlocacaoEquipamentoEvento> alocacaoEquipamentoEventos) {
		this.alocacaoEquipamentoEventos = alocacaoEquipamentoEventos;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public List<Navio> getNavios() {
		return navios;
	}
	
	
}
