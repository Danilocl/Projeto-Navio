package projeto.centroOperacoes.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Navio {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "navio_id")
	private int id;
	
	@Column(name = "navio_nome")
	private String nome;

	@Column(name = "navio_status")
	private int status;
	
	@OneToMany(mappedBy = "navio")
	private List<Evento> evento = new ArrayList<>();

	@OneToMany(mappedBy = "navio")
	private List<AlocacaoEquipamento> alocacaoEquipamentos = new ArrayList<>();
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int Status) {
		this.status = Status;
	}

	public List<Evento> getEvento() {
		return evento;
	}

	public void setEvento(List<Evento> evento) {
		this.evento = evento;
	}

	public List<AlocacaoEquipamento> getAlocacaoEquipamentos() {
		return alocacaoEquipamentos;
	}

	public void setAlocacaoEquipamentos(List<AlocacaoEquipamento> alocacaoEquipamentos) {
		this.alocacaoEquipamentos = alocacaoEquipamentos;
	}
}
