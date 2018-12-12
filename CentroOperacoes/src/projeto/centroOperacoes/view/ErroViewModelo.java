package projeto.centroOperacoes.view;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import projeto.centroOperacoes.controle.ErroControle;
import projeto.centroOperacoes.controle.SensorControle;
import projeto.centroOperacoes.modelo.Equipamento;
import projeto.centroOperacoes.modelo.Erro;
import projeto.centroOperacoes.modelo.Sensor;

@ManagedBean(name = "erroView")
public class ErroViewModelo {
	
	private Erro erro = new Erro();
	
	private List<Erro> erros = new ErroControle().listarTodos();

	private List<Sensor> sensores = new SensorControle().listarTodos();

	private int idSensor;
	
	public Erro getErro() {
		return erro;
	}

	public void setErro(Erro erro) {
		this.erro = erro;
	}
	
	public void erroErro(Erro erro) {
		this.erro = erro;
	}
	
	public List<Erro> getErros() {
		return erros;
	}

	public void sensorErro(Sensor sensor) {
		this.erro.setSensor(sensor);
		this.idSensor = sensor.getId();
	}

	public List<Sensor> getSensores() {
		return sensores;
	}

	public void modificarErro(Erro er) {

		if (er.getId() != 0) {
			new ErroControle().modificar(er);
		}
	}
	
	public void desativarErro(Erro er) {
		if (er.getId() != 0) {
			new ErroControle().desativar(er);
		}
	}

	public int getIdSensor() {
		return idSensor;
	}

	public void setIdSensor(int idSensor) {
		this.idSensor = idSensor;
	}
	
	public void inserirErro() {
		
		if (erro.getSensor() != null)
			System.out.println("Foiiiiiiiiiiiiiiiiiiiiiiiiiiiii");

		if (idSensor != 0) {
			erro.setSensor(new SensorControle().buscarPorId(idSensor));
			erro.setStatus(1);
			new ErroControle().inserir(erro);

			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_WARN, "Sucesso!", "Usuario cadastrado com sucesso."));
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso!", "Por favor preencer todos campos."));
		}			
	}
	
	public void atualizarErro(Erro erro) {
		
		if (erro.getId() != 0) {
			new ErroControle().modificar(erro);
		}
	}
}
