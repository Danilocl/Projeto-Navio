package projeto.centroOperacoes.controle;

import java.io.Serializable;
import java.util.List;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


import projeto.centroOperacoes.modelo.Tripulante;
import projeto.centroOperacoes.modelo.dao.TripulanteDao;

@ManagedBean
@SessionScoped
public class TripulanteControl implements Serializable {

	private static final long serialVersionUID = 1L;

	Tripulante tripulante = new Tripulante();

	TripulanteDao dao = new TripulanteDao();

	public void getNewOperador(Tripulante tripulante) {
		tripulante = new Tripulante();
		tripulante.setId(null);
	}

	public void insert() {
		dao.persist(tripulante);
	}

	public void desativar(Tripulante trupulante) {
		trupulante.setStatus(0);
		dao.merge(trupulante);
	}

	public Tripulante buscaPorId() {
		return dao.getById(tripulante.getId());
	}

	public List<Tripulante> listar() {
		return dao.findAll();
	}

}
