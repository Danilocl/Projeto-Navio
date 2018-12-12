package projeto.centroOperacoes.controle;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import projeto.centroOperacoes.modelo.Tripulante;
import projeto.centroOperacoes.modelo.Usuario;
import projeto.centroOperacoes.modelo.dao.UsuarioDao;

@ManagedBean
@SessionScoped
public class UsuarioControl implements Serializable {

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public UsuarioDao getDao() {
		return dao;
	}

	public void setDao(UsuarioDao dao) {
		this.dao = dao;
	}

	private static final long serialVersionUID = 1L;

	Usuario usuario = new Usuario();

	UsuarioDao dao = new UsuarioDao();

	public Boolean isUsuarioReadyToLogin(String login, String pass) {

		login = login.toLowerCase().trim();

		Boolean valid;

		if (login.equals("admin")) {
			// if ( senha.equals(convertStringToMd5("avancer63"))){
			valid = true;

		} else {
			valid = false;
		}
		return valid;

	}

	public void insert() {
		usuario.setId(null);
		dao.persist(usuario);
		System.out.println(usuario.getId());
	}

	public void desativar(Usuario usuario) {
		usuario.setStatus(0);
		dao.merge(usuario);
	}

	public Usuario buscaPorId() {
		return dao.getById(usuario.getId());
	}

	public List<Usuario> listar() {
		return dao.findAll();
	}

}
