package projeto.centroOperacoes.controle;

import java.io.Serializable;
import java.util.List;

import projeto.centroOperacoes.modelo.AlocacaoEquipamento;
import projeto.centroOperacoes.modelo.dao.AlocacaoEquipamentoDao;

public class AlocacaoEquipamentoControle implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private AlocacaoEquipamentoDao dao;
	
	public AlocacaoEquipamentoControle() {
		dao = new AlocacaoEquipamentoDao();
	}
	
	public void inserir(AlocacaoEquipamento alocacao) {
		dao.persist(alocacao);
	}
	
	public void modificar(AlocacaoEquipamento alocacao) {
		dao.merge(alocacao);
	}
	
	public List<AlocacaoEquipamento> listarTodos() {
		return dao.findAll();
	}
	
	public AlocacaoEquipamento buscarPorId(AlocacaoEquipamento alocacao) {
		return dao.getById(alocacao.getId());
	}

	public AlocacaoEquipamento buscarPorId(int id) {
		return dao.getById(id);
	}
}