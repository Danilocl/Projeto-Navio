package projeto.centroOperacoes.controle;

import java.io.Serializable;
import java.util.List;

import projeto.centroOperacoes.modelo.Navio;
import projeto.centroOperacoes.modelo.dao.NavioDao;

public class NavioControle implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private NavioDao dao;
	
	public NavioControle() {
		dao = new NavioDao();
	}
	
	public void inserir(Navio navio) {
		dao.persist(navio);
	}
	
	public void modificar(Navio navio) {
		dao.merge(navio);
	}
	
	public List<Navio> listarTodos() {
		return dao.findAll();
	}
	
	public Navio buscarPorId(Navio navio) {
		return dao.getById(navio.getId());
	}
	
	public Navio buscarPorId(int id) {
		return dao.getById(id);
	}
	
	public boolean desativar(Navio navio) {
		navio = buscarPorId(navio.getId());
		if (navio != null) {
			navio.setStatus(0);
			modificar(navio);
			return true;
		} else {
			return false;
		}
	}
	
	public boolean desativar(int id) {
		Navio navio = buscarPorId(id);
		if (navio != null) {
			navio.setStatus(0);
			modificar(navio);
			return true;
		} else {
			return false;
		}
	}
	
	public boolean ativar(Navio navio) {
		navio = buscarPorId(navio);
		if (navio != null) {
			navio.setStatus(1);
			modificar(navio);
			return true;
		} else {
			return false;
		}
	}
	
	public boolean ativar(int id) {
		Navio navio = buscarPorId(id);
		if (navio != null) {
			navio.setStatus(1);
			modificar(navio);
			return true;
		} else {
			return false;
		}
	}
}