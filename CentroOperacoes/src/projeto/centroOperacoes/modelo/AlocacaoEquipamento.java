package projeto.centroOperacoes.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class AlocacaoEquipamento {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "alocacaoequipamento_id")
	private int id;
	
	@OneToMany(mappedBy = "alocacaoEquipamento")
	private List<AlocacaoEquipamentoEvento> alocacaoEquipamentoEventos = new ArrayList<>();

	private String zona;
	
	@ManyToOne
	@JoinColumn(name = "id_navio", nullable = false)
	private Navio navio;
	
	@ManyToOne
	@JoinColumn(name = "id_equipamento", nullable = false)
	private Equipamento equipamento;
	
	private int status;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getZona() {
		return zona;
	}

	public void setZona(String zona) {
		this.zona = zona;
	}

	public Navio getNavio() {
		return navio;
	}

	public void setNavio(Navio navio) {
		this.navio = navio;
	}

	public Equipamento getEquipamento() {
		return equipamento;
	}

	public void setEquipamento(Equipamento equipamento) {
		this.equipamento = equipamento;
	}

	public List<AlocacaoEquipamentoEvento> getAlocacaoEquipamentoEventos() {
		return alocacaoEquipamentoEventos;
	}

	public void setAlocacaoEquipamentoEventos(List<AlocacaoEquipamentoEvento> alocacaoEquipamentoEventos) {
		this.alocacaoEquipamentoEventos = alocacaoEquipamentoEventos;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
}
