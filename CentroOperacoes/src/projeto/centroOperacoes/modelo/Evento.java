package projeto.centroOperacoes.modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import projeto.centroOperacoes.util.UtilityDate;

@Entity
public class Evento {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "evento_id")
	private Integer id;
	
	@Column(name = "evento_data")
	private Date data;
	
	@Column(name = "evento_descricao")
	private String descricao;
	
	@Column(name = "evento_status")
	private int status;
	
	@ManyToOne
	@JoinColumn(name = "navio_id", nullable = false)
	private Navio navio;
	
	@ManyToOne
	@JoinColumn(name = "usuario_usuario_id")
	private Usuario usuario;
	
	@Column(name = "evento_token")
	private String token;
	
	@Column(name="evento_inicio_atendimento")
	private Date dataInicio;
	
	@Column(name="evento_fim_atendimento")
	private Date dataTerminoAtendimento;

	@OneToMany(mappedBy = "evento")
	private List<AlocacaoEquipamentoEvento> alocacaoEquipamentoEventos = new ArrayList<>();
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getData() {
		return UtilityDate.dateToString(data);
	}

	public void setData(String data) {
		this.data = UtilityDate.stringToDate(data);
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

	public String getDataInicio() {
		return UtilityDate.dateToString(dataInicio);
	}

	public void setDataInicio(String dataInicio) {
		this.dataInicio = UtilityDate.stringToDate(dataInicio);
	}

	public String getDataTerminoAtendimento() {
		return UtilityDate.dateToString(dataTerminoAtendimento);
	}

	public void setDataTerminoAtendimento(String dataTerminoAtendimento) {
		this.dataTerminoAtendimento = UtilityDate.stringToDate(dataTerminoAtendimento);
	}

	public List<AlocacaoEquipamentoEvento> getAlocacaoEquipamentoEventos() {
		return alocacaoEquipamentoEventos;
	}

	public void setAlocacaoEquipamentoEventos(List<AlocacaoEquipamentoEvento> alocacaoEquipamentoEventos) {
		this.alocacaoEquipamentoEventos = alocacaoEquipamentoEventos;
	}
}
