package projeto.centroOperacoes.view;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import projeto.centroOperacoes.controle.ErroControle;
import projeto.centroOperacoes.controle.SensorControle;
import projeto.centroOperacoes.modelo.Erro;
import projeto.centroOperacoes.modelo.Sensor;

@ManagedBean(name = "sensoView")
@RequestScoped
public class SensorViewModelo implements Serializable {
	
	private static final long serialVersionUID = 1L;	
	
	public SensorViewModelo() {
		sensors = new SensorControle().listarTodos();
		erros = new ErroControle().listarTodos();
	}
	
	private String descricao;

	private int sensor;

	private int status;
	
	private Error erro;
	
	private List<Erro> erros;
	
	private List<Sensor> sensors;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getSensor() {
		return sensor;
	}

	public void setSensor(int sensor) {
		this.sensor = sensor;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Error getErro() {
		return erro;
	}

	public void setErro(Error erro) {
		this.erro = erro;
	}

	public List<Erro> getErros() {
		return erros;
	}

	public List<Sensor> getSensors() {
		return sensors;
	}
}