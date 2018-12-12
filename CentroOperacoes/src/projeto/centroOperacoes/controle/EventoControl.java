package projeto.centroOperacoes.controle;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import projeto.centroOperacoes.modelo.Evento;
import projeto.centroOperacoes.modelo.dao.EventoDao;

@ManagedBean
@SessionScoped
public class EventoControl implements Serializable {

	private static final long serialVersionUID = 1L;

	EventoDao dao = new EventoDao();

	Evento evento = new Evento();

	public EventoControl() {
		dao = new EventoDao();

	}

	public void setDao(EventoDao dao) {
		this.dao = dao;
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	// Sempre chame esse método ao instanciar esta classe
	public void getNewEvento(Evento evento) {
		evento = new Evento();
		evento.setId(null);
	}

	public void insert() {
		evento.setId(null);
		dao.persist(evento);
	}

	public void desativar(Evento evento) {
		evento.setStatus(0);
		dao.merge(evento);
	}

	public void update() {
		dao.merge(evento);
	}

	public Evento buscaPorId() {
		return dao.getById(evento.getId());
	}

	public List<Evento> listar() {
		return dao.findAll();
	}

}
