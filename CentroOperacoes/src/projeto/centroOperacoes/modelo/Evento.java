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
	@Column(name = "id_evento")
	private Integer id;
	
	private Date data;
	
	private String descricao;
	
	private int status;
	
	@ManyToOne
	@JoinColumn(name = "id_navio", nullable = false)
	private Navio navio;
	
	@ManyToOne
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;
	
	private String token;
	
	@Column(name="data_inicio_atendimento")
	private Date dataInicio;
	
	@Column(name="data_termino_atendimento")
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
