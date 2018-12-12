package projeto.centroOperacoes.modelo.dao;


import java.util.List;

import javax.persistence.Query;

import projeto.centroOperacoes.modelo.Usuario;

public class UsuarioDao extends DaoGeneric<Usuario>{

	public UsuarioDao() {
		super();
		classPersistence = Usuario.class;
	}
	
	public Usuario login(String login, String senha) {
		
		String hql = "from " + Usuario.class.getName() + " u where u.login = :login and u.senha = :senha";
		
		System.out.println(hql);
		
		Query query = entityManager.createQuery(hql);
		
		query.setParameter("login", login);
		query.setParameter("senha", senha);
		
		List<Usuario> result = query.getResultList();
		
		if (result.size() == 1) {
			return result.get(0);
		}
		return null;
	}
	
}
