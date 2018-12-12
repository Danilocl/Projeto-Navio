package projeto.centroOperacoes.view;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import projeto.centroOperacoes.controle.NavioControle;
import projeto.centroOperacoes.modelo.Navio;

@ManagedBean
@RequestScoped
public class NavioViewModelo {

	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void cadastrar() {
		
		if (nome.equals("")) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso!", "Por favor preencer todos campos."));
		} else {
			Navio navio = new Navio();
			navio.setNome(nome);
			
			NavioControle controle = new NavioControle();
			controle.inserir(navio);
			
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Sucesso!", "Usuario cadastrado com sucesso."));
		}
	}
}
