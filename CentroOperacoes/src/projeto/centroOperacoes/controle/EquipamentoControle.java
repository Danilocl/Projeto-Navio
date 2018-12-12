package projeto.centroOperacoes.controle;

import java.io.Serializable;
import java.util.List;

import projeto.centroOperacoes.modelo.Equipamento;
import projeto.centroOperacoes.modelo.dao.EquipamentoDao;

public class EquipamentoControle implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private EquipamentoDao dao;
	
	public EquipamentoControle() {
		dao = new EquipamentoDao();
	}
	
	public void inserir(Equipamento equipamento) {
		dao.persist(equipamento);
	}
	
	public void modificar(Equipamento equipamento) {
		dao.merge(equipamento);
	}
	
	public List<Equipamento> listarTodos() {
		return dao.findAll();
	}
	
	public Equipamento buscarPorId(Equipamento equipamento) {
		return dao.getById(equipamento.getId());
	}

	public Equipamento buscarPorId(int id) {
		return dao.getById(id);
	}
	
	public void desativar(Equipamento equipamento) {
		Equipamento eq = buscarPorId(equipamento);
		eq.setStatus(0);
		modificar(eq);
	}
	
	public void desativar(int id) {
		Equipamento eq = buscarPorId(id);
		eq.setStatus(0);
		modificar(eq);
	}
	
	public void ativar(Equipamento equipamento) {
		Equipamento eq = buscarPorId(equipamento.getId());
		eq.setStatus(1);
		modificar(eq);
	}

	public void ativar(int id) {
		Equipamento eq = buscarPorId(id);
		eq.setStatus(1);
		modificar(eq);
	}
}
