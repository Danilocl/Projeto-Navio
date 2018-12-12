package projeto.centroOperacoes.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity(name = "alocacaoequipamentoe_vento")
public class AlocacaoEquipamentoEvento {

	@Id
	@Column(name = "alocacaoequipamento_alocacaoequipamento_id")
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "id_alocacaoequipamento", nullable = false)
	private AlocacaoEquipamento alocacaoEquipamento;
	
	@ManyToOne
	@JoinColumn(name = "evento_id", nullable = false)
	private Evento evento;
	
	@OneToOne
	private Erro erro;
	
	@Column(name = "erro_sensor_sensor_id")
	private int id_sensor;
	
	
//	private int id_equipamento;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public AlocacaoEquipamento getAlocacaoEquipamento() {
		return alocacaoEquipamento;
	}

	public void setAlocacaoEquipamento(AlocacaoEquipamento alocacaoEquipamento) {
		this.alocacaoEquipamento = alocacaoEquipamento;
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	public int getId_sensor() {
		return id_sensor;
	}

	public void setId_sensor(int id_sensor) {
		this.id_sensor = id_sensor;
	}

//	public int getId_equipamento() {
//		return id_equipamento;
//	}
//
//	public void setId_equipamento(int id_equipamento) {
//		this.id_equipamento = id_equipamento;
//	}

	public Erro getErro() {
		return erro;
	}

	public void setErro(Erro erro) {
		this.erro = erro;
	}
}
