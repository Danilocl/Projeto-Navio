package projeto.centroOperacoes.controle;

import java.io.Serializable;
import java.util.List;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


import projeto.centroOperacoes.modelo.Sensor;
import projeto.centroOperacoes.modelo.dao.SensorDao;

@ManagedBean
@SessionScoped
public class SensorControl implements Serializable {

	private static final long serialVersionUID = 1L;

	Sensor sensor = new Sensor();

	SensorDao dao = new SensorDao();

	public SensorControl() {
		super();
		dao = new SensorDao();
	}

	public void insert() {
		sensor.setId(null);
		dao.persist(sensor);
	}

	public void desativar(Sensor sensor) {
		sensor.setStatus(0);
		dao.merge(sensor);
	}

	public void update() {
		dao.merge(sensor);
	}

	public Sensor getSensor() {
		return sensor;
	}

	public void setSensor(Sensor sensor) {
		this.sensor = sensor;
	}

	public SensorDao getDao() {
		return dao;
	}

	public void setDao(SensorDao dao) {
		this.dao = dao;
	}

	public Sensor buscaPorId() {
		return dao.getById(sensor.getId());
	}

	public List<Sensor> listar() {
		return dao.findAll();
	}

}
