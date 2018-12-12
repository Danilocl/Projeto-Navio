package projeto.centroOperacoes.controle;

import java.io.Serializable;
import java.util.List;

import projeto.centroOperacoes.modelo.AlocacaoEquipamentoEvento;
import projeto.centroOperacoes.modelo.dao.AlocacaoEquipamentoEventoDao;

public class AlocacaoEquipamentoEventoControle  implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private AlocacaoEquipamentoEventoDao dao;
	
	public AlocacaoEquipamentoEventoControle() {
		dao = new AlocacaoEquipamentoEventoDao();
	}
	
	public void inserir(AlocacaoEquipamentoEvento alocacao) {
		dao.persist(alocacao);
	}
	
	public void modificar(AlocacaoEquipamentoEvento alocacao) {
		dao.merge(alocacao);
	}
	
	public List<AlocacaoEquipamentoEvento> listarTodos() {
		return dao.findAll();
	}	
	
	public AlocacaoEquipamentoEvento buscarPorId(int id) {
		return dao.getById(id);
	}
	
	public AlocacaoEquipamentoEvento buscarPorId(AlocacaoEquipamentoEvento alocacao) {
		return dao.getById(alocacao.getId());
	}
}