package projeto.centroOperacoes.controle;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import projeto.centroOperacoes.modelo.Evento;
import projeto.centroOperacoes.modelo.dao.EventoDao;

public class EventoControle implements Serializable {

	private static final long serialVersionUID = 1L;

	private EventoDao dao;

	public EventoControle() {
		dao = new EventoDao();
	}

	public void inserir(Evento evento) {
		dao.persist(evento);
	}

	public void modificar(Evento evento) {
		dao.merge(evento);
	}

	public List<Evento> listarTodos() {
		return dao.findAll();
	}
	
	public Evento buscarPorId(int id) {
		return dao.getById(id);
	}
	
	public Evento buscarPorId(Evento evento) {
		return dao.getById(evento.getId());
	}
		
	public void desativar(Evento evento) {
		Evento ev = buscarPorId(evento);
		ev.setStatus(0);
		modificar(ev);
	}
	
	public void ativar(Evento evento) {
		Evento ev = buscarPorId(evento);
		ev.setStatus(1);
		modificar(ev);
	}
	
	public void desativar(int id) {
		Evento ev = buscarPorId(id);
		ev.setStatus(0);
		modificar(ev);
	}
	
	public void ativar(int id) {
		Evento ev = buscarPorId(id);
		ev.setStatus(1);
		modificar(ev);
	}
	
}