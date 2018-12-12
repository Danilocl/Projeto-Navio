package projeto.centroOperacoes.controle;

import java.io.Serializable;
import java.util.List;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import projeto.centroOperacoes.modelo.Erro;
import projeto.centroOperacoes.modelo.dao.ErroDao;

@ManagedBean
@SessionScoped
public class ErroControl implements Serializable {

	private static final long serialVersionUID = 1L;

	private ErroDao dao = new ErroDao();

	private Erro erro = new Erro();

	public Erro getErro() {
		return erro;
	}

	public void setErro(Erro erro) {
		this.erro = erro;
	}


	public void getNewErro(Erro erro) {
		erro = new Erro();
		erro.setId(null);
	}

	public void insert() {
		erro.setId(null);
		dao.persist(erro);
	}

	public void desativar(Erro erro) {
		erro.setStatus(0);
		dao.merge(erro);
	}

	public void update() {
		dao.merge(erro);
	}

	public Erro buscaPorId() {
		return dao.getById(erro.getId());
	}

	public List<Erro> listar() {
		return dao.findAll();
	}

}
