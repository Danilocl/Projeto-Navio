package projeto.centroOperacoes.controle;

import java.io.Serializable;
import java.util.List;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


import projeto.centroOperacoes.modelo.Operador;
import projeto.centroOperacoes.modelo.dao.OperadorDao;

@ManagedBean
@SessionScoped
public class OperadorControl implements Serializable {

	private static final long serialVersionUID = 1L;
	
	Operador operador = new Operador();
	
	OperadorDao dao = new OperadorDao();
	
	public void getNewOperador(Operador operador) {
		operador = new Operador();
		operador.setId(null);
	}
	
	
	public void insert() {		 
		dao.persist(operador);
	}

	public void desativar(Operador operador) {
		operador.setStatus(0);
		dao.merge(operador);			
	}


	public void update() {
		dao.merge(operador);
	}

	public Operador buscaPorId() {
		return dao.getById(operador.getId());
	}

	public List<Operador> listar() {
		return dao.findAll();
	}

}
