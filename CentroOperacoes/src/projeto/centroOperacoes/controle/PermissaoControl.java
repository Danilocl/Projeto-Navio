package projeto.centroOperacoes.controle;

import java.io.Serializable;
import java.util.List;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import projeto.centroOperacoes.modelo.AlocacaoEquipamento;
import projeto.centroOperacoes.modelo.Permissao;
import projeto.centroOperacoes.modelo.dao.PermissaoDao;

@ManagedBean
@SessionScoped
public class PermissaoControl implements Serializable {

	private static final long serialVersionUID = 1L;

	private Permissao permissao = new Permissao();
	private PermissaoDao dao =  new PermissaoDao();

	public Permissao getPermissao() {
		return permissao;
	}

	public void setPermissao(Permissao permissao) {
		this.permissao = permissao;
	}

	public PermissaoDao getDao() {
		return dao;
	}

	public void setDao(PermissaoDao dao) {
		this.dao = dao;
	}

	public void insert() {		 
		dao.persist(permissao);
	}
	
	public void update() {
		dao.merge(permissao);
	}

	public Permissao buscaPorId() {
		return dao.getById(permissao.getId());
	}

	public List<Permissao> listar() {
		return dao.findAll();
	}

}
