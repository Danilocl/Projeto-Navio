package projeto.centroOperacoes.controle;

import java.io.Serializable;
import java.util.List;

import projeto.centroOperacoes.modelo.Erro;
import projeto.centroOperacoes.modelo.Permissao;
import projeto.centroOperacoes.modelo.dao.PermissaoDao;

public class PermissaoControle implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private PermissaoDao dao;
	
	public PermissaoControle() {
		dao = new PermissaoDao();
	}

	public void inserir(Permissao permissao) {
		dao.persist(permissao);
	}
	
	public void modificar(Permissao permissao) {
		dao.merge(permissao);
	}
	
	public List<Permissao> listarTodos() {
		return dao.findAll();
	}	
	
	public Permissao buscarPorId(int id) {
		return dao.getById(id);
	}
	
	public Permissao buscarPorId(Permissao permissao) {
		return dao.getById(permissao.getId());
	}
		
	public void desativar(Permissao permissao) {
		Permissao pe = buscarPorId(permissao);
		pe.setStatus(0);
		modificar(pe);
	}
	
	public void ativar(Permissao permissao) {
		Permissao pe = buscarPorId(permissao);
		pe.setStatus(1);
		modificar(pe);
	}
	
	public void desativar(int id) {
		Permissao pe = buscarPorId(id);
		pe.setStatus(0);
		modificar(pe);
	}
	
	public void ativar(int id) {
		Permissao pe = buscarPorId(id);
		pe.setStatus(1);
		modificar(pe);
	}
}

