package projeto.centroOperacoes.controle;

import java.util.List;

import projeto.centroOperacoes.modelo.Erro;
import projeto.centroOperacoes.modelo.dao.ErroDao;

public class ErroControle {

	private ErroDao dao;
	
	public ErroControle() {
		dao = new ErroDao();
	}
	
	public void inserir(Erro erro) {
		dao.persist(erro);
	}
	
	public void modificar(Erro erro) {
		dao.merge(erro);
	}
	
	public List<Erro> listarTodos() {
		return dao.findAll();
	}	
	
	public Erro buscarPorId(int id) {
		return dao.getById(id);
	}
	
	public Erro buscarPorId(Erro erro) {
		return dao.getById(erro.getId());
	}
		
	public void desativar(Erro erro) {
		Erro er = buscarPorId(erro);
		er.setStatus(0);
		modificar(er);
	}
	
	public void ativar(Erro erro) {
		Erro er = buscarPorId(erro);
		er.setStatus(1);
		modificar(er);
	}
	
	public void desativar(int id) {
		Erro er = buscarPorId(id);
		er.setStatus(0);
		modificar(er);
	}
	
	public void ativar(int id) {
		Erro er = buscarPorId(id);
		er.setStatus(1);
		modificar(er);
	}
}