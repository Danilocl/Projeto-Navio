package projeto.centroOperacoes.controle;

import java.io.Serializable;
import java.util.List;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import projeto.centroOperacoes.modelo.AlocacaoEquipamento;

import projeto.centroOperacoes.modelo.dao.AlocacaoEquipamentoDao;

@ManagedBean
@SessionScoped
public class AlocacaoEquipamentoControl implements Serializable {

	private static final long serialVersionUID = 1L;

	private AlocacaoEquipamento equipamento;

	private AlocacaoEquipamentoDao dao;

	public AlocacaoEquipamento getEquipamento() {
		return equipamento;
	}

	public void setEquipamento(AlocacaoEquipamento equipamento) {
		this.equipamento = equipamento;
	}

	public AlocacaoEquipamentoDao getDao() {
		return dao;
	}

	public void setDao(AlocacaoEquipamentoDao dao) {
		this.dao = dao;
	}

	public void desativar(AlocacaoEquipamento equipamento) {
		equipamento.setStatus(0);
		dao.merge(equipamento);
	}

	public void update() {
		dao.merge(equipamento);
	}

	public AlocacaoEquipamento buscaPorId() {
		return dao.getById(equipamento.getId());
	}

	public List<AlocacaoEquipamento> listar() {
		return dao.findAll();
	}

}
