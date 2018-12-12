package projeto.centroOperacoes.controle;

import java.io.Serializable;
import java.util.List;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import projeto.centroOperacoes.modelo.Equipamento;
import projeto.centroOperacoes.modelo.Erro;
import projeto.centroOperacoes.modelo.dao.EquipamentoDao;

@ManagedBean
@SessionScoped
public class EquipamentoControl implements Serializable {

	private static final long serialVersionUID = 1L;

	private Equipamento equipamento = new Equipamento();

	private EquipamentoDao dao = new EquipamentoDao();

	public Equipamento getEquipamento() {
		return equipamento;
	}

	public void setEquipamento(Equipamento equipamento) {
		this.equipamento = equipamento;
	}

	public EquipamentoDao getDao() {
		return dao;
	}

	public void setDao(EquipamentoDao dao) {
		this.dao = dao;
	}
	
	public void insert() {
		equipamento.setId(null);
		dao.persist(equipamento);
	}
	public void desativar(Equipamento equipamento) {
		equipamento.setStatus(0);
		dao.merge(equipamento);
	}

	public void update() {
		dao.merge(equipamento);
	}

	public Equipamento buscaPorId() {
		return dao.getById(equipamento.getId());
	}

	public List<Equipamento> listar() {
		return dao.findAll();
	}
}
