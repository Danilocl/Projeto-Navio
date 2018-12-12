package projeto.centroOperacoes.modelo.dao;

import projeto.centroOperacoes.modelo.Evento;

public class EventoDao extends DaoGeneric<Evento> {
	
	public EventoDao() {
		super();
		classPersistence = Evento.class;
	}

}