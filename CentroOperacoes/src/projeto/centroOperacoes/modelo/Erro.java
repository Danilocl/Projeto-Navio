package projeto.centroOperacoes.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Erro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_erro")
	private int id;

	private String nome;

	private String descricao;

	private int status;
	
	private int id_equipamento;

	@ManyToOne
	@JoinColumn(name = "id_sensor", nullable = false)
	private Sensor sensor;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Sensor getSensor() {
		return sensor;
	}

	public void setSensor(Sensor sensor) {
		this.setId_equipamento(sensor.getEquipamento().getId());
		this.sensor = sensor;
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

	public void setStatus(int status) {
		this.status = status;
	}

	public int getId_equipamento() {
		return id_equipamento;
	}

	public void setId_equipamento(int id_equipamento) {
		this.id_equipamento = id_equipamento;
	}
}