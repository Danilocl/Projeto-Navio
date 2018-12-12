package projeto.centroOperacoes.modelo.dao;

import projeto.centroOperacoes.modelo.Sensor;

public class SensorDao extends DaoGeneric<Sensor>{

	public SensorDao() {
		super();
		classPersistence = Sensor.class;
	}
}
