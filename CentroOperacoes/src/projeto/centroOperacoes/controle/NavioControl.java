package projeto.centroOperacoes.controle;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


import projeto.centroOperacoes.modelo.Navio;
import projeto.centroOperacoes.modelo.dao.NavioDao;

@ManagedBean
@SessionScoped
public class NavioControl implements Serializable {

	private Navio navio = new Navio();
	
	private NavioDao dao = new NavioDao();
	
	
	//Sempre chame esse método ao instanciar esta classe
			public void getNewNavio(Navio navio) {
				navio = new Navio();
				navio.setId(null);
			}

			public void insert() {		 
				dao.persist(navio);
			}

			public void desativar(Navio navio) {
				navio.setStatus(0);
				dao.merge(navio);			
			}


			public void update() {
				dao.merge(navio);
			}

			public Navio buscaPorId() {
				return dao.getById(navio.getId());
			}
			

			public List<Navio> listar() {
				return dao.findAll();
			}
	
}
