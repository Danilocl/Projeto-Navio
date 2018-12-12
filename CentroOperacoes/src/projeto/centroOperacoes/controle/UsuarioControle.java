package projeto.centroOperacoes.controle;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.faces.context.FacesContext;

import projeto.centroOperacoes.modelo.Usuario;
import projeto.centroOperacoes.modelo.dao.UsuarioDao;

public class UsuarioControle implements Serializable {

	private static final long serialVersionUID = 1L;

	private UsuarioDao dao;

	public UsuarioControle() {
		dao = new UsuarioDao();
	}

	public void inserir(Usuario usuario) {
		dao.persist(usuario);
	}

	public void modificar(Usuario usuario) {
		dao.merge(usuario);
	}

	public List<Usuario> listarTodos() {
		return dao.findAll();
	}

	public Usuario buscarPorId(int id) {
		return dao.getById(id);
	}

	public Usuario buscarPorId(Usuario usuario) {
		return dao.getById(usuario.getId());
	}

	public boolean desativar(int id) {
		Usuario usuario = buscarPorId(id);
		if (usuario != null) {
			usuario.setStatus(0);
			modificar(usuario);
			return true;
		} else {
			return false;
		}
	}

	public boolean desativar(Usuario usuario) {
		usuario = buscarPorId(usuario);
		if (usuario != null) {
			usuario.setStatus(0);
			modificar(usuario);
			return true;
		} else {
			return false;
		}
	}

	public boolean ativar(int id) {
		Usuario usuario = buscarPorId(id);
		if (usuario != null) {
			usuario.setStatus(1);
			modificar(usuario);
			return true;
		} else {
			return false;
		}
	}

	public boolean ativar(Usuario usuario) {
		Usuario usuario1 = buscarPorId(usuario.getId());
		if (usuario1 != null) {
			usuario1.setStatus(1);
			modificar(usuario1);
			return true;
		} else {
			return false;
		}
	}

	public Usuario isUsuarioReadyToLogin(String login, String pass) {
		try {
			login = login.toLowerCase().trim();

			Usuario user = dao.login(login, pass);

			if (user != null) {
				//if (query.get(0).getSenha().equals(pass)) {
				if ( user.getSenha().equals(convertStringToMd5(pass))){
					Usuario userFound = (Usuario) user;
					// Set user object in session
					FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("loggeduser", userFound);

					return userFound;
				}
			}
			return null;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private String convertStringToMd5(String value) {
		MessageDigest mDigest;
		try {
			// Instanciamos o nosso HASH MD5, poderíamos usar outro como
			// SHA, por exemplo, mas optamos por MD5.
			mDigest = MessageDigest.getInstance("MD5");

			// Convert a String valor para um array de bytes em MD5
			byte[] valorMD5 = mDigest.digest(value.getBytes("UTF-8"));

			// Convertemos os bytes para hexadecimal, assim podemos salvar
			// no banco para posterior comparação se senhas
			StringBuffer sb = new StringBuffer();
			for (byte b : valorMD5) {
				sb.append(Integer.toHexString((b & 0xFF) | 0x100).substring(1, 3));
			}

			return sb.toString();

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return null;
		}
	}

}
