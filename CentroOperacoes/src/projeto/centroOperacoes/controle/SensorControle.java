package projeto.centroOperacoes.controle;

import java.io.Serializable;
import java.util.List;

import projeto.centroOperacoes.modelo.Sensor;
import projeto.centroOperacoes.modelo.dao.ErroDao;
import projeto.centroOperacoes.modelo.dao.SensorDao;

public class SensorControle implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private SensorDao dao;
	
	public SensorControle() {
		dao = new SensorDao();
	}
	
	public void inserir(Sensor sensor) {
		dao.persist(sensor);
	}
	
	public void modificar(Sensor sensor) {
		dao.merge(sensor);
	}
	
	public List<Sensor> listarTodos() {
		return dao.findAll();
	}	
	
	public Sensor buscarPorId(int id) {
		return dao.getById(id);
	}
	
	public Sensor buscarPorId(Sensor sensor) {
		return dao.getById(sensor.getId());
	}
		
	public void desativar(Sensor sensor) {
		Sensor se = buscarPorId(sensor);
		se.setStatus(0);
		modificar(se);
	}
	
	public void ativar(Sensor sensor) {
		Sensor se = buscarPorId(sensor);
		se.setStatus(1);
		modificar(se);
	}
	
	public void desativar(int id) {
		Sensor se = buscarPorId(id);
		se.setStatus(0);
		modificar(se);
	}
	
	public void ativar(int id) {
		Sensor se = buscarPorId(id);
		se.setStatus(1);
		modificar(se);
	}

}
