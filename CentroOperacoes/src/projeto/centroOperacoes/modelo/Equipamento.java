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
public class Equipamento {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_equipamento")
	private int id;

	private String nome;

	private String descricao;

	private int status;

	@OneToMany(mappedBy = "equipamento")
	private List<AlocacaoEquipamento> alocacaoEquipamentos = new ArrayList<>();
	
	@OneToMany(mappedBy = "equipamento")
	private List<Sensor> sensors = new ArrayList<>();
	
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int estatus) {
		this.status = estatus;
	}

	public List<AlocacaoEquipamento> getAlocacaoEquipamentos() {
		return alocacaoEquipamentos;
	}

	public void setAlocacaoEquipamentos(List<AlocacaoEquipamento> alocacaoEquipamentos) {
		this.alocacaoEquipamentos = alocacaoEquipamentos;
	}

	public List<Sensor> getSensors() {
		return sensors;
	}

	public void setSensors(List<Sensor> sensors) {
		this.sensors = sensors;
	}
}
